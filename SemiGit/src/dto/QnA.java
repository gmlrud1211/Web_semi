package dto;

import java.util.Date;

public class QnA {

	private int u_no;
	private int one_no;
	private String one_title;
	private String one_content;
	private int file_no;
	private String file_storedname;
	private Date one_date;
	private String one_status;
	private String one_anscontent;
	private Date one_ansdate;
	
	
	
	public String getFile_storedname() {
		return file_storedname;
	}
	public void setFile_storedname(String file_storedname) {
		this.file_storedname = file_storedname;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public int getOne_no() {
		return one_no;
	}
	public void setOne_no(int one_no) {
		this.one_no = one_no;
	}
	public String getOne_title() {
		return one_title;
	}
	public void setOne_title(String one_title) {
		this.one_title = one_title;
	}
	public String getOne_content() {
		return one_content;
	}
	public void setOne_content(String one_content) {
		this.one_content = one_content;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public Date getOne_date() {
		return one_date;
	}
	public void setOne_date(Date one_date) {
		this.one_date = one_date;
	}
	public String getOne_status() {
		return one_status;
	}
	public void setOne_status(String one_status) {
		this.one_status = one_status;
	}
	public String getOne_anscontent() {
		return one_anscontent;
	}
	public void setOne_anscontent(String one_anscontent) {
		this.one_anscontent = one_anscontent;
	}
	public Date getOne_ansdate() {
		return one_ansdate;
	}
	public void setOne_ansdate(Date one_ansdate) {
		this.one_ansdate = one_ansdate;
	}
	
	
	
	
}
