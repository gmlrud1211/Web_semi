package controller.mypage.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Message;
import service.mypage.message.MessageService;
import service.mypage.message.MessageServiceImpl;


@WebServlet("/mypage/message/read")
public class MessageReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		Message rMsg = mServ.getReceivedMessageByMno(m_no);
		
		if(rMsg.getM_read().equals("n")) {
			mServ.updateRead(m_no);			
		}
		
		request.setAttribute("rMsg", rMsg);
		
		request.getRequestDispatcher("/view/mypage/message/readMsg.jsp").forward(request, response);
		
	}
	

}
