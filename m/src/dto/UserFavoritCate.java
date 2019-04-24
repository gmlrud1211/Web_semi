package dto;

public class UserFavoritCate {

	private int u_no;
	private int st_code;
	private String st_catename;
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public int getSt_code() {
		return st_code;
	}
	public void setSt_code(int st_code) {
		this.st_code = st_code;
	}
	public String getSt_catename() {
		return st_catename;
	}
	public void setSt_catename(String st_catename) {
		this.st_catename = st_catename;
	}
	@Override
	public String toString() {
		return "UserFavoritCate [u_no=" + u_no + ", st_code=" + st_code + ", st_catename=" + st_catename + "]";
	}

	
	
}	