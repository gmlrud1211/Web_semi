package dto;

import java.util.Date;

public class FileUpload {
	private int file_no;
	private String file_originname;
	private String file_storedname;
	private Date file_uploaddate;
	private int fut_code;
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_originname() {
		return file_originname;
	}
	public void setFile_originname(String file_originname) {
		this.file_originname = file_originname;
	}
	public String getFile_storedname() {
		return file_storedname;
	}
	public void setFile_storedname(String file_storedname) {
		this.file_storedname = file_storedname;
	}
	public Date getFile_uploaddate() {
		return file_uploaddate;
	}
	public void setFile_uploaddate(Date file_uploaddate) {
		this.file_uploaddate = file_uploaddate;
	}
	public int getFut_code() {
		return fut_code;
	}
	public void setFut_code(int fut_code) {
		this.fut_code = fut_code;
	}
	@Override
	public String toString() {
		return "FileUpload [file_no=" + file_no + ", file_originname=" + file_originname + ", file_storedname="
				+ file_storedname + ", file_uploaddate=" + file_uploaddate + ", fut_code=" + fut_code + "]";
	}
	
	
	
}
