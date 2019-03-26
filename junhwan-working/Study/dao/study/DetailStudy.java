package dao.study;

public interface DetailStudy {
	//찜하기 유효성 검사
	public boolean checkDupl(int study_no, int u_no);
	//신청하기 유효성 검사
	public boolean StudyAppDupl(int u_no, int study_no);

}
