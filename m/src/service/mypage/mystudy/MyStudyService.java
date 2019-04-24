package service.mypage.mystudy;

import java.util.List;

import dto.Study;
import dto.StudyTeamState;

public interface MyStudyService {

	//신청한 스터디 전체 조회
//	public List getListStudyInfo(int u_no, int study_no);
	public List getListStudyInfo(int u_no);
	//신청하면 db넣기(ajax용)
	public void insertMyStudyList(StudyTeamState mystudy);
	//신청한거 취소하면 db삭제()
	public void deletMyStudyList(int study_no,int u_no);
	//신청자리스트조회
	public List<StudyTeamState> getListStudymember(int u_no, int study_no);
	
	// 내가 팀장인 스터디 리스트 조회
	public List<StudyTeamState> getLeaderStudyInfo(int u_no);
	
	// 내가 팀장인 스터디의 신청자 -> 신청 수락 
	public void memberAccept(int u_no, int study_no);
	// 내가 팀장인 스터디의 신청자 -> 신청 거절 
	public void memberDecline(int u_no, int study_no);
	
	// 모집종료 버튼 통해 모집종료
	public void recruitEnd(int study_no);
	
	// 진행 중인 나의 스터디 리스트 조회
	public List<Study> progressStudy(int u_no);
	
	
}
