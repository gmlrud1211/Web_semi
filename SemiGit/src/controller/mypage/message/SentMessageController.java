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


@WebServlet("/mypage/message/sent")
public class SentMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 
		List sList = mServ.getSentMessageListByUno(u_no); 
		
		request.setAttribute("sList", sList);
		
		request.getRequestDispatcher("/view/mypage/message/sentMsgList.jsp").forward(request, response);	
	}

}
