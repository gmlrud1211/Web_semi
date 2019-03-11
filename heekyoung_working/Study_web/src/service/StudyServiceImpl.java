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
				
		
		return study;
	}

	@Override
	public void studyopen(Study study) {
		studyDao.studyopen(study);
	}

	
}
