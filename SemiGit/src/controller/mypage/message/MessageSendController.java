package controller.mypage.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Message;
import service.mypage.message.MessageService;
import service.mypage.message.MessageServiceImpl;

@WebServlet("/message/send")
public class MessageSendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		int m_no = Integer.parseInt(request.getParameter("m_no"));
		Message sMsg = mServ.getReceivedMessageByMno(m_no);
		
		session.setAttribute("sMsg", sMsg);
		
		request.getRequestDispatcher("/view/mypage/message/sendMsg.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int sender_no = Integer.parseInt(request.getParameter("sender_no"));
		int receiver_no = Integer.parseInt(request.getParameter("receiver_no"));
		String m_comment = request.getParameter("m_comment");
//		System.out.println("m"+ m_no);
//		System.out.println("s"+ sender_no);
//		System.out.println("r"+ receiver_no);
		
		mServ.sendMessage(sender_no, receiver_no, m_comment);
		
	}

}
