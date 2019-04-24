package dao.mypage.mystudy;

import java.util.List;

import dto.Study;
import dto.StudyTeamState;
import dto.Users;

public interface MyStudy {
	// MyStudy정보 select
	public List selectMyStudyInfo(int u_no);

	// DB삽입(준환 추가)
	public void insertMyStudy(StudyTeamState mystudy);

	// DB삭제(MyStudyList.jsp에서 버튼 클릭시 삭제, 준환추가)
	public void deleteMyStudy(int study_no, int u_no);
	// 신청자리스트조회
	public List<StudyTeamState> getListStudymember(int u_no, int study_no);
	// 내가 팀장인 스터디
	public List<StudyTeamState> selectMyStudybyUserNo(int u_no);

	public void memberAccept(int u_no, int study_no);

	public void memberDecline(int u_no, int study_no);

	public void recruitEnd(int study_no);

	public List<Study> progressStudy(int u_no);

}
