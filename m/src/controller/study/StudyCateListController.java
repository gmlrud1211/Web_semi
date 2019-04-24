package controller.study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Study;
import service.study.StudyService;
import service.study.StudyServiceImpl;

@WebServlet("/study/catecode")
public class StudyCateListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudyService studyservice = new StudyServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categorycode = request.getParameter("category_code");
		int category_code = Integer.parseInt(categorycode);
		
		List<Study> StudyList_cate = studyservice.getCateStudyList(category_code);
		request.setAttribute("StudyList_cate", StudyList_cate);
		
		request.getRequestDispatcher("/view/subArea.jsp").forward(request, response);
	}
}
