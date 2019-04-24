package dto;

import java.util.Date;

public class Schedule {

//	private int calendar_no;       //일정 명칭
//	private String calendar_title;       //일정 명칭
//	private String calendar_start_date;     //일정 시작 날짜
//	private String calendar_end_date;       //일정 끝나는 날짜
//	
//
//	
//	@Override
//	public String toString() {
//		return "Schedule [calendar_no=" + calendar_no + ", calendar_title=" + calendar_title + ", calendar_start_date="
//				+ calendar_start_date + ", calendar_end_date=" + calendar_end_date + "]";
//	}
//	public int getCalendar_no() {
//		return calendar_no;
//	}
//	public void setCalendar_no(int calendar_no) {
//		this.calendar_no = calendar_no;
//	}
//	public String getCalendar_title() {
//		return calendar_title;
//	}
//	public void setCalendar_title(String calendar_title) {
//		this.calendar_title = calendar_title;
//	}
//	public String getCalendar_start_date() {
//		return calendar_start_date;
//	}
//	public void setCalendar_start_date(String calendar_start_date) {
//		this.calendar_start_date = calendar_start_date;
//	}
//	public String getCalendar_end_date() {
//		return calendar_end_date;
//	}
//	public void setCalendar_end_date(String calendar_end_date) {
//		this.calendar_end_date = calendar_end_date;
//	}
	
	
	private int s_no;      
	private int study_no;      
	private String s_title;
	private String s_content; 
	private String s_cname; 
	private Date s_date   ;     
	private String s_partname ;
	private Date s_rdate ;  
	private String s_name;
	private String s_start;
	private String s_end;
	
	private double p_lat;
	private double p_lng;
	private String p_address;
	
	
	private String s_place ;
	
	public double getP_lat() {
		return p_lat;
	}
	public void setP_lat(double p_lat) {
		this.p_lat = p_lat;
	}
	public double getP_lng() {
		return p_lng;
	}
	public void setP_lng(double p_lng) {
		this.p_lng = p_lng;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getStudy_no() {
		return study_no;
	}
	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}
	public String getS_title() {
		return s_title;
	}
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_cname() {
		return s_cname;
	}
	public void setS_cname(String s_cname) {
		this.s_cname = s_cname;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public String getS_partname() {
		return s_partname;
	}
	public void setS_partname(String s_partname) {
		this.s_partname = s_partname;
	}
	public String getS_place() {
		return s_place;
	}
	public void setS_place(String s_place) {
		this.s_place = s_place;
	}
	public Date getS_rdate() {
		return s_rdate;
	}
	public void setS_rdate(Date s_rdate) {
		this.s_rdate = s_rdate;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_start() {
		return s_start;
	}
	public void setS_start(String s_start) {
		this.s_start = s_start;
	}
	public String getS_end() {
		return s_end;
	}
	public void setS_end(String s_end) {
		this.s_end = s_end;
	}
	@Override
	public String toString() {
		return "Schedule [s_no=" + s_no + ", study_no=" + study_no + ", s_title=" + s_title + ", s_content=" + s_content
				+ ", s_cname=" + s_cname + ", s_date=" + s_date + ", s_partname=" + s_partname + ", s_rdate=" + s_rdate
				+ ", s_name=" + s_name + ", s_start=" + s_start + ", s_end=" + s_end + ", p_lat=" + p_lat + ", p_lng="
				+ p_lng + ", p_address=" + p_address + ", s_place=" + s_place + "]";
	}
	
	
	

	
	
	
	

	
	
}
