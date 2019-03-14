package dao.study;

import dto.Study;

public interface StudyDao {

	//스터디 정보 등록
	public void studyopen(Study study);

	//study_no조회
	public int getStudy_no(Study study);

	
	//스터디 카테고리 번호 조회
	//public int selectCate();

}
