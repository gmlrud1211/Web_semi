package service.study;

public interface DetailStudyService {

	public boolean getDuplicated(int study_no, int u_no);

	public boolean getAppDuplicated(int u_no, int study_no);
}
