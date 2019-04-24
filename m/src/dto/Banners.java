package dto;

import java.util.Date;

public class Banners {

	private int bn_no;      
	private String bn_title; 
	private Date bn_date;
	
	private int file_no;
	
	private String file_storedname;
	
	

	public String getFile_storedname() {
		return file_storedname;
	}

	public void setFile_storedname(String file_storedname) {
		this.file_storedname = file_storedname;
	}

	public int getBn_no() {
		return bn_no;
	}

	public void setBn_no(int bn_no) {
		this.bn_no = bn_no;
	}

	public String getBn_title() {
		return bn_title;
	}

	public void setBn_title(String bn_title) {
		this.bn_title = bn_title;
	}

	public Date getBn_date() {
		return bn_date;
	}

	public void setBn_date(Date bn_date) {
		this.bn_date = bn_date;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	@Override
	public String toString() {
		return "Banners [bn_no=" + bn_no + ", bn_title=" + bn_title + ", bn_date=" + bn_date + ", file_no=" + file_no
				+ ", file_storedname=" + file_storedname + "]";
	}

	
	
	

	
	
}
