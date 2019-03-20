package controller.mypage.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Message;
import service.mypage.message.MessageService;
import service.mypage.message.MessageServiceImpl;
import util.Paging;

@WebServlet("/mypage/message/received")
public class ReceivedMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 		

		int side = 1;

		int curPage = mServ.getCurPage(request);
		int totalCount = mServ.getTotalMsgCount(side, u_no);
		
		Paging paging = new Paging(totalCount, curPage);
		

		List<Message> msgList = mServ.getMsgPagingList(side, u_no, paging);
		
		request.setAttribute("msgList", msgList);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher("/view/mypage/message/receivedMsgList.jsp").forward(request, response);	


	}

}
