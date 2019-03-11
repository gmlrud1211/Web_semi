package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.study.StudyDao;
import dao.study.StudyDaoImpl;
import dto.study.Study;

public class StudyServiceImpl implements StudyService {

	private StudyDao studyDao = new StudyDaoImpl();
	
	@Override
	public Study getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		Study study = new Study();
		
		String study_name =(String)req.getParameter("study_name");
		String st_code =(String)req.getParameter("st_code");
		String study_region =(String)req.getParameter("study_region");
		String study_time =(String)req.getParameter("study_time");
		String study_freq =(String)req.getParameter("study_freq");
		String study_min =(String)req.getParameter("study_min");
		String study_max =(String)req.getParameter("study_max");
		String study_gender =(String)req.getParameter("study_gender");
		String study_opendate =(String)req.getParameter("study_opendate");
		String study_period =(String)req.getParameter("study_period");
		String study_detail =(String)req.getParameter("study_detail");
		
				
		
		return study;
	}

	@Override
	public void studyopen(Study study) {
		studyDao.studyopen(study);
	}

	
}
