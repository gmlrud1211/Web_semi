package controller.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileUpload;
import dto.Study;
import service.study.StudyService;
import service.study.StudyServiceImpl;

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
		
	
		//파일번호 구하기
		String filenoParam = req.getParameter("file_no");
		System.out.println(req.getParameter("file_no"));
		
		int file_no=-1;
		
		if(filenoParam!=null && !"".equals(filenoParam)) {
			file_no = Integer.parseInt(filenoParam);
		}
		System.out.println("구하기 : "+file_no);
		
		//스터디 번호 얻기
		int study_no = studyservice.getStudy_no();
			
		study.setStudy_no(study_no);
		study.setFile_no(file_no);
	
		//스터디 정보 등록
		studyservice.studyopen(study);
		
		
		//파일첨부 존재하면 처리
		if(file_no !=-1) {
			FileUpload fileupload = new FileUpload();
			fileupload.setFile_no(file_no);
			System.out.println("fdfdf"+file_no);
			
			//게시글,파일 연결
			studyservice.updateFile(fileupload);
		}
		
		resp.sendRedirect("/main");
		
	}

}
