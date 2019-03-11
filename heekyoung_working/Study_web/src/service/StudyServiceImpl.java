package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		int st_code = Integer.parseInt(req.getParameter("st_code"));
		String study_region =(String)req.getParameter("study_region");
		String study_time =(String)req.getParameter("study_time");
		String study_freq =(String)req.getParameter("study_freq");
		String study_min =(String)req.getParameter("study_min");
		String study_max =(String)req.getParameter("study_max");
		String study_gender =(String)req.getParameter("study_gender");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String study_opendate =df.format(req.getParameter("study_opendate"));
			String study_period =df.format(req.getParameter("study_period"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String study_detail =(String)req.getParameter("study_detail");
		
		study.setStudy_name(study_name);
		study.setSt_code(st_code);
		study.setStudy_region(study_region);
		study.setStudy_time(study_time);
		study.setStudy_freq(study_freq);
		//study.setStudy_min(study_min);
		//study.setStudy_max(study_max);
		study.setStudy_gender(study_gender);
		study.setStudy_opendate(study_opendate);
		study.setStudy_period(study_period);
		study.setStudy_details(study_detail);

				
		
		return study;
	}

	@Override
	public void studyopen(Study study) {
		studyDao.studyopen(study);
	}

	
}
