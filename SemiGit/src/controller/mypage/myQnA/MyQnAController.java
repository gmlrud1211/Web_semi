package controller.mypage.myQnA;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.FileUpload;
import dto.QnA;
import service.mypage.myQnA.myQnAService;
import service.mypage.myQnA.myQnAServiceImpl;
import util.Paging;


@WebServlet("/mypage/myqna")
public class MyQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	myQnAService qnaServ = new myQnAServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		// ���� ������ ��ȣ ���
		int curPage = qnaServ.getCurPage(request);
								
		// �� ���� ���� �� ���
		int totalCount = qnaServ.getTotalMyQnACount(u_no);
								
		// ������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
						
		// �Խñ� ��� MODEL�� �߰�
		List<QnA> qnaList = qnaServ.getMyQnAPagingList(u_no, paging);
				
		request.setAttribute("qnaList", qnaList);
								
		// ����¡ ��ü MODEL�� �߰�
		request.setAttribute("paging", paging);

		request.getRequestDispatcher("/view/mypage/myQnA/myQnAList.jsp").forward(request, response);
		
	}

}
