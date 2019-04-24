package dto;

import java.sql.Date;

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
	private String study_opendate;
	private String study_period;
	private String study_addrecruit;
	private int u_no;
	//join��
	private String u_name;//�����̸�
	private String st_category_code;//ī�װ� ��з� �ڵ�
	private String st_cate;// 대분류명
	private String st_subcate;// 중분류명
	private String file_storedname; // 파일 저장명
	private int st_catecode;	// 대분류 코드
	
	
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
	public String getStudy_opendate() {
		return study_opendate;
	}
	public void setStudy_opendate(String study_opendate) {
		this.study_opendate = study_opendate;
	}
	public String getStudy_period() {
		return study_period;
	}
	public void setStudy_period(String study_period) {
		this.study_period = study_period;
	}
	public String getStudy_addrecruit() {
		return study_addrecruit;
	}
	public void setStudy_addrecruit(String study_addrecruit) {
		this.study_addrecruit = study_addrecruit;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getSt_category_code() {
		return st_category_code;
	}
	public void setSt_category_code(String st_category_code) {
		this.st_category_code = st_category_code;
	}
	public String getSt_cate() {
		return st_cate;
	}
	public void setSt_cate(String st_cate) {
		this.st_cate = st_cate;
	}
	public String getSt_subcate() {
		return st_subcate;
	}
	public void setSt_subcate(String st_subcate) {
		this.st_subcate = st_subcate;
	}
	public String getFile_storedname() {
		return file_storedname;
	}
	public void setFile_storedname(String file_storedname) {
		this.file_storedname = file_storedname;
	}
	public int getSt_catecode() {
		return st_catecode;
	}
	public void setSt_catecode(int st_catecode) {
		this.st_catecode = st_catecode;
	}
	@Override
	public String toString() {
		return "Study [study_no=" + study_no + ", st_code=" + st_code + ", study_name=" + study_name + ", file_no="
				+ file_no + ", study_region=" + study_region + ", study_time=" + study_time + ", study_freq="
				+ study_freq + ", study_min=" + study_min + ", study_max=" + study_max + ", study_gender="
				+ study_gender + ", study_details=" + study_details + ", study_opendate=" + study_opendate
				+ ", study_period=" + study_period + ", study_addrecruit=" + study_addrecruit + ", u_no=" + u_no
				+ ", u_name=" + u_name + ", st_category_code=" + st_category_code + ", st_cate=" + st_cate
				+ ", st_subcate=" + st_subcate + ", file_storedname=" + file_storedname + ", st_catecode=" + st_catecode
				+ "]";
	}


	
	
}
