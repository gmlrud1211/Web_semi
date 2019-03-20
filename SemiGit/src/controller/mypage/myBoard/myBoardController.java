package controller.mypage.myBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MyBoard;
import service.mypage.myBoard.myBoardService;
import service.mypage.myBoard.myBoardServiceImpl;
import util.Paging;


@WebServlet("/mypage/myboard")
public class myBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	myBoardService mbServ = new myBoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		int curPage = mbServ.getCurPage(request);
		int totalCount = mbServ.getTotalMyBoardCount(u_no);
						
		Paging paging = new Paging(totalCount, curPage);


		List<MyBoard> mbList = mbServ.getMyBoardPagingList(u_no, paging);
		request.setAttribute("mbList", mbList);					
						
		// ����¡ ��ü MODEL�� �߰�
		request.setAttribute("paging", paging);

		request.getRequestDispatcher("/view/mypage/myBoard/myBoardList.jsp").forward(request, response);
	}


}
