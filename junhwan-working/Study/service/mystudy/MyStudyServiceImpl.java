package service.mypage.mystudy;

import java.util.List;

import dao.mypage.mystudy.MyStudy;
import dao.mypage.mystudy.MyStudyImpl;
import dao.study.DetailStudy;
import dao.study.DetailStudyImpl;
import dto.StudyTeamState;

public class MyStudyServiceImpl implements MyStudyService {
	//dao객체
	private MyStudy mystu = new MyStudyImpl();

	@Override
	public List getListStudyInfo(int u_no) {
		return mystu.selectMyStudyInfo(u_no);
	}

	@Override
	public void insertMyStudyList(StudyTeamState mystudy) {
			mystu.insertMyStudy(mystudy);
	}

	@Override
	public void deletMyStudyList(StudyTeamState mystudy) {
		mystu.deleteMyStudy(mystudy);
		
	}


}
