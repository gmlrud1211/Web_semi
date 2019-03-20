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
import utill.Paging;


@WebServlet("/mypage/message/sent")
public class SentMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MessageService mServ = new MessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 
		
		
		// 현재 페이지 번호 얻기
		int curPage = mServ.getCurPage(request);
				
		// 총 보낸 쪽지 수 얻기
		int totalCount = mServ.getTotalSentMsgCount(u_no);
				
		// 페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);

				
		// 게시글 목록 MODEL로 추가
		
		List<Message> rList = mServ.getSentMsgPagingList(u_no, paging);
		request.setAttribute("rList", rList);
				
				
		// 페이징 객체 MODEL로 추가
		request.setAttribute("paging", paging);
				
		
		request.getRequestDispatcher("/view/mypage/message/sentMsgList.jsp").forward(request, response);	
	}

}
