package service.mypage.mystudy;

import java.util.List;

import dao.mypage.mystudy.MyStudy;
import dao.mypage.mystudy.MyStudyImpl;
import dto.Study;
import dto.StudyTeamState;

public class MyStudyServiceImpl implements MyStudyService {
	//dao객체
	private MyStudy mystu = new MyStudyImpl();

	//u_no으로 신청한 스터디 리스트 조회
	@Override
	public List getListStudyInfo(int u_no) {
		return mystu.selectMyStudyInfo(u_no);
	}
	//MyStudyInsertController에서 처리
	@Override
	public void insertMyStudyList(StudyTeamState mystudy) {
			mystu.insertMyStudy(mystudy);
	}
	//MyStudyDeleteController에서 처리
	@Override
	public void deletMyStudyList(int study_no, int u_no) {
		mystu.deleteMyStudy(study_no,u_no);
		
	}
	@Override
	public List<StudyTeamState> getListStudymember(int u_no, int study_no) {
		return mystu.getListStudymember(u_no, study_no);
	}
	@Override
	public List<StudyTeamState> getLeaderStudyInfo(int u_no) {
		return mystu.selectMyStudybyUserNo(u_no);
	}
	@Override
	public void memberAccept(int u_no, int study_no) {
		 mystu.memberAccept(u_no, study_no);
		
	}
	@Override
	public void memberDecline(int u_no, int study_no) {
		 mystu.memberDecline(u_no, study_no);
	}
	@Override
	public void recruitEnd(int study_no) {
		mystu.recruitEnd(study_no);
		
	}
	@Override
	public List<Study> progressStudy(int u_no) {
		return mystu.progressStudy(u_no);
	}
}
