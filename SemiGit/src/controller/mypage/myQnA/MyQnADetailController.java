package controller.mypage.myQnA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnA;
import service.mypage.myQnA.myQnAService;
import service.mypage.myQnA.myQnAServiceImpl;


@WebServlet("/mypage/myqna/detail")
public class MyQnADetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	myQnAService qnaServ = new myQnAServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int one_no = (int) request.getAttribute("one_no");
		
		QnA qna = qnaServ.getQnAByOneno(one_no);
		
		request.setAttribute("qna", qna);
		
		request.getRequestDispatcher("/view/mypage/myQnA/QnADetail.jsp").forward(request, response);
		
		
	}

}
