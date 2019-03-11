package dto.study;

import java.util.Date;

public class Study {

	private int study_no;
	private int st_code;
	private String study_name;
	private int file_no;
	private String study_region;
	private String study_time;
	private String study_freq;
	private int study_min;
	private int study_max;
	private String study_gender;
	private String study_details;
	private Date study_opendate;
	private Date study_period;
	private Date study_addrecruit;
	private int u_no;
	
	
	@Override
	public String toString() {
		return "Study [study_no=" + study_no + ", st_code=" + st_code + ", study_name=" + study_name + ", file_no="
				+ file_no + ", study_region=" + study_region + ", study_time=" + study_time + ", study_freq="
				+ study_freq + ", study_min=" + study_min + ", study_max=" + study_max + ", study_gender="
				+ study_gender + ", study_details=" + study_details + ", study_opendate=" + study_opendate
				+ ", study_period=" + study_period + ", study_addrecruit=" + study_addrecruit + ", u_no=" + u_no + "]";
	}
	
	
	
	public int getStudy_no() {
		return study_no;
	}
	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}
	public int getSt_code() {
		return st_code;
	}
	public void setSt_code(int st_code) {
		this.st_code = st_code;
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
	public String getStudy_region() {
		return study_region;
	}
	public void setStudy_region(String study_region) {
		this.study_region = study_region;
	}
	public String getStudy_time() {
		return study_time;
	}
	public void setStudy_time(String study_time) {
		this.study_time = study_time;
	}
	public String getStudy_freq() {
		return study_freq;
	}
	public void setStudy_freq(String study_freq) {
		this.study_freq = study_freq;
	}
	public int getStudy_min() {
		return study_min;
	}
	public void setStudy_min(int study_min) {
		this.study_min = study_min;
	}
	public int getStudy_max() {
		return study_max;
	}
	public void setStudy_max(int study_max) {
		this.study_max = study_max;
	}
	public String getStudy_gender() {
		return study_gender;
	}
	public void setStudy_gender(String study_gender) {
		this.study_gender = study_gender;
	}
	public String getStudy_details() {
		return study_details;
	}
	public void setStudy_details(String study_details) {
		this.study_details = study_details;
	}
	public Date getStudy_opendate() {
		return study_opendate;
	}
	public void setStudy_opendate(Date study_opendate) {
		this.study_opendate = study_opendate;
	}
	public Date getStudy_period() {
		return study_period;
	}
	public void setStudy_period(Date study_period) {
		this.study_period = study_period;
	}
	public Date getStudy_addrecruit() {
		return study_addrecruit;
	}
	public void setStudy_addrecruit(Date study_addrecruit) {
		this.study_addrecruit = study_addrecruit;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	
	
}
