package controller.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudyCategory;
import service.study.StudyService;
import service.study.StudyServiceImpl;


public class StudyCateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudyService studyservice = new StudyServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.getRequestDispatcher("/view/study/cateOption.jsp").forward(request, response);
		
	}

}
