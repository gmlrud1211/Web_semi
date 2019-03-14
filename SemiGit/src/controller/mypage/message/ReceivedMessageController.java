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

@WebServlet("/mypage/message/received")
public class ReceivedMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 
		
		List rList = mServ.getReceivedMessageListByUno(u_no); 
		
		request.setAttribute("rList", rList);
		
		request.getRequestDispatcher("/view/mypage/message/receivedMsgList.jsp").forward(request, response);	


	}

}
