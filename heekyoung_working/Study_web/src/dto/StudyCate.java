package dto;

public class StudyCate {

	private int st_code;
	private String st_cate;
	private String st_subcate;
	private String st_category_code;
	
	@Override
	public String toString() {
		return "StudyCate [st_code=" + st_code + ", st_cate=" + st_cate + ", st_subcate=" + st_subcate
				+ ", st_category_code=" + st_category_code + "]";
	}
	
	public int getSt_code() {
		return st_code;
	}
	public void setSt_code(int st_code) {
		this.st_code = st_code;
	}
	public String getSt_cate() {
		return st_cate;
	}
	public void setSt_cate(String st_cate) {
		this.st_cate = st_cate;
	}
	public String getSt_subcate() {
		return st_subcate;
	}
	public void setSt_subcate(String st_subcate) {
		this.st_subcate = st_subcate;
	}
	public String getSt_category_code() {
		return st_category_code;
	}
	public void setSt_category_code(String st_category_code) {
		this.st_category_code = st_category_code;
	}
	

	
}
