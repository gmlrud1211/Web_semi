package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

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
		int study_min = Integer.parseInt(req.getParameter("study_min"));
		int study_max = Integer.parseInt(req.getParameter("study_max"));
		String study_gender =(String)req.getParameter("study_gender");
	
		String study_opendate =(String)req.getParameter("study_opendate");
		String study_period = (String)req.getParameter("study_period");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date date2 = null;
		
		try {
			date = (Date) sdf.parse(study_opendate);
			date2 = (Date) sdf.parse(study_period);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String study_detail =(String)req.getParameter("study_detail");
		
		study.setStudy_name(study_name);
		study.setSt_code(st_code);
		study.setStudy_region(study_region);
		study.setStudy_time(study_time);
		study.setStudy_freq(study_freq);
		study.setStudy_min(study_min);
		study.setStudy_max(study_max);
		study.setStudy_gender(study_gender);
		study.setStudy_opendate(date);
		study.setStudy_period(date2);
		study.setStudy_details(study_detail);

				
		
		return study;
	}

	@Override
	public void studyopen(Study study) {
		
	}



	
}
