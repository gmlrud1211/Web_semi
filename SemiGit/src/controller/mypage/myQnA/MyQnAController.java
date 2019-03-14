package controller.mypage.myQnA;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.mypage.myQnA.myQnAService;
import service.mypage.myQnA.myQnAServiceImpl;


@WebServlet("/mypage/myqna")
public class MyQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	myQnAService qnaServ = new myQnAServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		List qnaList = qnaServ.getQnAListByUno(u_no);
		
		request.setAttribute("qnaList", qnaList);
		
		request.getRequestDispatcher("/view/mypage/myQnA/myQnAList.jsp").forward(request, response);
		
	}

}
