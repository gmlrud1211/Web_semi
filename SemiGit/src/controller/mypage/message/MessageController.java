package controller.mypage.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.mypage.message.MessageService;
import service.mypage.message.MessageServiceImpl;

@WebServlet("/message")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); // u_no 받아오기
		List msgList = mServ.getMessageListByUno(u_no); 
		
		session.setAttribute("msgList", msgList);
		
		request.getRequestDispatcher("/view/mypage/message/list.jsp").forward(request, response);	

	}

}
