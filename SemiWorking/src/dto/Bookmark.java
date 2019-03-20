package dto;

import java.util.Date;

public class Bookmark {

	private int bm_no; // 북마크 번호
	private int u_no; // 유저 번호
	private int study_no; // 스터디 번호
	private String study_name; // 스터디 이름
	private int file_no; // 대표 이미지 파일 번호
	private String file_originname; // 이미지 파일 원본이름
	private String file_storedname; // 이미지 파일 저장이름
	private Date bm_date; // 북마크 등록 날짜
	
	
	public int getBm_no() {
		return bm_no;
	}
	public void setBm_no(int bm_no) {
		this.bm_no = bm_no;
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
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
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
	public Date getBm_date() {
		return bm_date;
	}
	public void setBm_date(Date bm_date) {
		this.bm_date = bm_date;
	}
	
	
	
}
