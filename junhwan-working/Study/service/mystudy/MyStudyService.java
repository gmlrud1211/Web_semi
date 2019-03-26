package service.mypage.mystudy;

import java.util.List;

import dto.StudyTeamState;

public interface MyStudyService {

	//신청한 스터디 전체 조회
//	public List getListStudyInfo(int u_no, int study_no);
	public List getListStudyInfo(int u_no);
	//신청하면 db넣기
	public void insertMyStudyList(StudyTeamState mystudy);
	//신청한거 취소하면 db삭제
	public void deletMyStudyList(StudyTeamState mystudy);
	
}
