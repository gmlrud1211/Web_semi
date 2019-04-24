package dto;

import java.util.Date;

public class NoticeBoard {
 
	private int nb_no;
	private String nb_title;
	private String nb_content;
	private int file_no;
	private Date nb_date;
	private int nb_count;
	
   
	@Override
	public String toString() {
		return "NoticeBoard [nb_no=" + nb_no + ", nb_title=" + nb_title + ", nb_content=" + nb_content + ", file_no="
				+ file_no + ", nb_date=" + nb_date + ", nb_count=" + nb_count + "]";
	}
	public int getNb_no() {
		return nb_no;
	}
	public void setNb_no(int nb_no) {
		this.nb_no = nb_no;
	}
	public String getNb_title() {
		return nb_title;
	}
	public void setNb_title(String nb_title) {
		this.nb_title = nb_title;
	}
	public String getNb_content() {
		return nb_content;
	}
	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public Date getNb_date() {
		return nb_date;
	}
	public void setNb_date(Date nb_date) {
		this.nb_date = nb_date;
	}
	public int getNb_count() {
		return nb_count;
	}
	public void setNb_count(int nb_count) {
		this.nb_count = nb_count;
	}

	
	
}
