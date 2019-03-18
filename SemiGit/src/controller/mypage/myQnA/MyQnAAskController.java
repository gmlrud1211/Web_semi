package controller.mypage.myQnA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.QnA;
import service.mypage.myQnA.myQnAService;
import service.mypage.myQnA.myQnAServiceImpl;


@WebServlet("/mypage/myqna/ask")
public class MyQnAAskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	myQnAService qnaServ = new myQnAServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		request.setAttribute("u_no", u_no);
		request.getRequestDispatcher("/view/mypage/myQnA/ask.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		String one_title= req.getParameter("qnaTitle");
		String one_content = req.getParameter("qnaContent");
		
		QnA qna = new QnA();
		qna.setU_no(u_no);
		qna.setOne_title(one_title);
		qna.setOne_content(one_content);
		
		qnaServ.writeQnA(qna);
			
		resp.sendRedirect("/mypage/myqna");
		
	}

}
