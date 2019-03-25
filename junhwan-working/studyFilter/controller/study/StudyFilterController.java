package controller.study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import dto.Study;
import dto.StudyCate;
import service.study.StudyService;
import service.study.StudyServiceImpl;

@WebServlet("/study/filter")
public class StudyFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudyService studyService = new StudyServiceImpl();;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.setContentType("text/html; charset=UTF-8");
		   request.setCharacterEncoding("utf-8");
		
		//Study객체에 요청파라미터 정보 저장
		Study study = studyService.getParam(request, response);
		System.out.println("study/filter : "+ study.getSt_code());
		
		//서비스의 view에 요청파라미터를 받은 study값을 대입해주고 List에 저장
		List studyFilter = studyService.view(study);
		
		System.out.println("studyFilter" + studyFilter);

		//setAttribute로 jsp에서 사용할 attribute지정
		request.setAttribute("studyFilter", studyFilter);
		int cate_no = Integer.parseInt(request.getParameter("cate_no"));
		StudyCate studycate = new StudyCate();
	      List<StudyCate> studycate1 = studyService.selectCate(cate_no);
	      
	      
	      //페이지 들어올때 카테넘버를 넘겨줌
	      request.setAttribute("cate_no", cate_no);
	      //페이지에 뿌려질 목록
	      request.setAttribute("studycate1", studycate1);
		//값 뿌려줄 view설정
		request.getRequestDispatcher("/view/study/searchStudy.jsp").forward(request, response);

	}

}
