package dto;

import java.util.Date;

public class Report {
/*	RP_NO	신고번호	NUMBER
	B_NO	게시글번호	NUMBER
	U_NO	신고자	NUMBER
	RP_DATE	신고일	DATE
	RP_STATUS	신고상태	VARCHAR2(20 BYTE)
	RE_YESNO	삭제여부	VARCHAR2(20 BYTE)
	RE_DATE	삭제일	DATE*/
	
	private int rp_no;
	private int b_no;
	private int u_no;
	private Date rp_date;
	private String rp_status;
	private String re_yesno;
	private Date re_date;
	private String u_name; //신고자 이름 
	private String b_title; // 게시글 제목
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public int getRp_no() {
		return rp_no;
	}
	public void setRp_no(int rp_no) {
		this.rp_no = rp_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public Date getRp_date() {
		return rp_date;
	}
	public void setRp_date(Date rp_date) {
		this.rp_date = rp_date;
	}
	public String getRp_status() {
		return rp_status;
	}
	public void setRp_status(String rp_status) {
		this.rp_status = rp_status;
	}
	public String getRe_yesno() {
		return re_yesno;
	}
	public void setRe_yesno(String re_yesno) {
		this.re_yesno = re_yesno;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	@Override
	public String toString() {
		return "Report [rp_no=" + rp_no + ", b_no=" + b_no + ", u_no=" + u_no + ", rp_date=" + rp_date + ", rp_status="
				+ rp_status + ", re_yesno=" + re_yesno + ", re_date=" + re_date + ", u_name=" + u_name + ", b_title="
				+ b_title + ", getU_name()=" + getU_name() + ", getB_title()=" + getB_title() + ", getRp_no()="
				+ getRp_no() + ", getB_no()=" + getB_no() + ", getU_no()=" + getU_no() + ", getRp_date()="
				+ getRp_date() + ", getRp_status()=" + getRp_status() + ", getRe_yesno()=" + getRe_yesno()
				+ ", getRe_date()=" + getRe_date() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
