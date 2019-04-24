package controller.study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Study;
import service.study.StudyCateService;
import service.study.StudyCateServiceImpl;


@WebServlet("/study/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudyCateService scServ = new StudyCateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int st_code = Integer.parseInt(req.getParameter("st_code"));
		
		List<Study> sList = scServ.getCateStudyList(st_code);
		
		req.setAttribute("sList", sList);
		session.setAttribute("st_code", st_code);
		
		req.getRequestDispatcher("/view/study/categoryStudy.jsp").forward(req, resp);	

		
	}

}
