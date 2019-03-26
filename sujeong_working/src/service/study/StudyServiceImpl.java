package service.study;

import java.util.List;

import dao.study.StudyDao;
import dao.study.StudyDaoImpl;
import dto.Study;
import dto.StudyCategory;

public class StudyServiceImpl implements StudyService {
	
	StudyDao stdDao = new StudyDaoImpl();

	// 대분류 정보 가져오기
	@Override
	public List<StudyCategory> getCategory() {
		 return stdDao.getCategory();
	}
	
	// 나의 맞춤 스터디 가져오기
	@Override
	public List<Study> getMyStudy(int u_no) {
		return stdDao.getMyStudy(u_no);
	}

	// 모집마감 임박 스터디 가져오기
	@Override
	public List<Study> getHurryStudy() {
		return stdDao.getHurryStudy();
	}

	@Override
	public List<Study> getCateStudyList(int category_code) {
		return stdDao.getCateStudyList(category_code);
	}
}
