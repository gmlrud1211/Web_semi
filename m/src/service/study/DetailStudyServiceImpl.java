package service.study;

import dao.study.DetailStudy;
import dao.study.DetailStudyImpl;

public class DetailStudyServiceImpl implements DetailStudyService {
	//Dao객체
	DetailStudy det = new DetailStudyImpl();
	//찜하기 중복검사
	@Override
	public boolean getDuplicated(int study_no, int u_no) {
	
		return det.checkDupl(study_no, u_no);
	}
	//신청하기 중복검사
	@Override
	public boolean getAppDuplicated(int u_no, int study_no) {
		return det.StudyAppDupl(u_no, study_no);
	}
	
}
