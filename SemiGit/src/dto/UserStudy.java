package dto;

public class UserStudy {
	private int u_no;
	private int study_no;
	
	@Override
	public String toString() {
		return "UserStudy [u_no=" + u_no + ", study_no=" + study_no + "]";
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public int getStudy_no() {
		return study_no;
	}
	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}
	
	
	
}
