package service.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.study.StudyDao;
import dao.study.StudyDaoImpl;
import dto.FileUpload;
import dto.Study;

public class StudyServiceImpl implements StudyService {

	private StudyDao studyDao = new StudyDaoImpl();
	
	@Override
	public Study getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		Study study = new Study();
	
		String study_name =(String)req.getParameter("study_name");
		int st_code = Integer.parseInt(req.getParameter("st_code"));
		//int file_no = Integer.parseInt(req.getParameter("file_no"));
		String study_region =(String)req.getParameter("study_region");
		String study_time =(String)req.getParameter("study_time");
		String study_freq =(String)req.getParameter("study_freq");
		int study_min = Integer.parseInt(req.getParameter("study_min"));
		int study_max = Integer.parseInt(req.getParameter("study_max"));
		String study_gender =(String)req.getParameter("study_gender");
		String study_opendate =(String)req.getParameter("study_opendate");
		String study_period = (String)req.getParameter("study_period");
		String study_detail =(String)req.getParameter("study_detail");
	
		HttpSession session = req.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 
				
		
		study.setStudy_name(study_name);
		study.setSt_code(st_code);
		//study.setFile_no(file_no);
		study.setStudy_region(study_region);
		study.setStudy_time(study_time);
		study.setStudy_freq(study_freq);
		study.setStudy_min(study_min);
		study.setStudy_max(study_max);
		study.setStudy_gender(study_gender);
		study.setStudy_opendate(study_opendate);
		study.setStudy_period(study_period);
		study.setStudy_details(study_detail);
		study.setU_no(u_no);


		return study;
	}

	@Override
	public Study studyopen(Study study) {
		studyDao.studyopen(study);
		
		return study;

	}

	@Override
	public void updateFile(FileUpload fileupload) {
		studyDao.updateFile(fileupload);
		
	}

	@Override
	public int getStudy_no() {
		return studyDao.getStudy_no();
	}

	


	
}
