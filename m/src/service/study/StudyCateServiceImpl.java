package service.study;

import java.util.List;

import dao.study.StudyCateDao;
import dao.study.StudyCateDaoImpl;
import dto.Study;

public class StudyCateServiceImpl implements StudyCateService {

	StudyCateDao sDao = new StudyCateDaoImpl();
	
	@Override
	public List<Study> getCateStudyList(int st_code) {
		
		return sDao.getCateStudyList(st_code);
	}

}
