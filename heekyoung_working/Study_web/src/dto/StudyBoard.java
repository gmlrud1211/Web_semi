package dto;

import java.util.Date;

public class StudyBoard {

	private int study_no;
	private int u_no;
	private String sb_content;
	private int file_no;
	private Date sb_date;
	private int sb_no;
	
	public int getStudy_no() {
		return study_no;
	}
	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getSb_content() {
		return sb_content;
	}
	public void setSb_content(String sb_content) {
		this.sb_content = sb_content;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public Date getSb_date() {
		return sb_date;
	}
	public void setSb_date(Date sb_date) {
		this.sb_date = sb_date;
	}
	public int getSb_no() {
		return sb_no;
	}
	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}
	@Override
	public String toString() {
		return "StudyBoard [study_no=" + study_no + ", u_no=" + u_no + ", sb_content=" + sb_content + ", file_no="
				+ file_no + ", sb_date=" + sb_date + ", sb_no=" + sb_no + "]";
	}
	
	
	
}
