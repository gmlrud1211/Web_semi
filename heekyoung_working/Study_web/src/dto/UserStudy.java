package dto;

public class UserStudy {
	private int u_no;
	private int study_no;
	
	private String u_name;
	private String u_phone;
	private String u_email;
	private String u_birth;
	

	
	@Override
	public String toString() {
		return "UserStudy [u_no=" + u_no + ", study_no=" + study_no + ", u_name=" + u_name + ", u_phone=" + u_phone
				+ ", u_email=" + u_email + ", u_birth=" + u_birth + "]";
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_birth() {
		return u_birth;
	}
	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
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
