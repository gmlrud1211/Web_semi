package dto;

public class StudyCategory {

	private int st_catecode;
	private String st_catename;
	
	@Override
	public String toString() {
		return "StudyCategory [st_catecode=" + st_catecode + ", st_catename=" + st_catename + "]";
	}
	
	public int getSt_catecode() {
		return st_catecode;
	}
	public void setSt_catecode(int st_catecode) {
		this.st_catecode = st_catecode;
	}
	public String getSt_catename() {
		return st_catename;
	}
	public void setSt_catename(String st_catename) {
		this.st_catename = st_catename;
	}
	
}
