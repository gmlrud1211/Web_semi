package controller.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.study.Study;
import service.StudyService;
import service.StudyServiceImpl;

@WebServlet("/study/open")
public class StudyOpenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudyService studyservice = new StudyServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/study/studyopen.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩
		req.setCharacterEncoding("utf-8");
	
		//요청파라미터
		Study study = studyservice.getParam(req,resp);
		
		//스터디 정보 등록
		studyservice.studyopen(study);
		
	}

}
