package dto;

public class FileUploadType {
	
	private int fut_code;//게시판 코드
	private String fut_name;//게시판 이름
	@Override
	public String toString() {
		return "FileUploadType [fut_code=" + fut_code + ", fut_name=" + fut_name + "]";
	}
	public int getFut_code() {
		return fut_code;
	}
	public void setFut_code(int fut_code) {
		this.fut_code = fut_code;
	}
	public String getFut_name() {
		return fut_name;
	}
	public void setFut_name(String fut_name) {
		this.fut_name = fut_name;
	}
	
	

}
