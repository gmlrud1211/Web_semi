package dto;


import java.sql.Date;

public class StudyTeamState {

	private int u_no;// 회원번호
	private int study_no;// 스터디 번호
	private int ss_statecode;// 스터디 상태코드
	private int ts_statecode;// 신청상태코드
	private String ss_applydate;// 신청날짜
	private String ss_decisiondate;// 결정날짜
	private String ss_yesno;// 팀장여부

	// join용
	private String ss_statename;// 스터디 상태 이름
	private String ts_statename;// 신청 상태 이름
	private String u_name;//유저 이름
	private String study_name;//스터디이름
	private String study_region;//희망지역
	private String study_details;//상세내용
	private String study_freq;//횟수
	private Date study_opendate;//시작일
	private String u_phone;
	private String u_email;
	private String u_birth;
	private String gender;
	private String file_storedname;
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
	public int getSs_statecode() {
		return ss_statecode;
	}
	public void setSs_statecode(int ss_statecode) {
		this.ss_statecode = ss_statecode;
	}
	public int getTs_statecode() {
		return ts_statecode;
	}
	public void setTs_statecode(int ts_statecode) {
		this.ts_statecode = ts_statecode;
	}
	public String getSs_applydate() {
		return ss_applydate;
	}
	public void setSs_applydate(String ss_applydate) {
		this.ss_applydate = ss_applydate;
	}
	public String getSs_decisiondate() {
		return ss_decisiondate;
	}
	public void setSs_decisiondate(String ss_decisiondate) {
		this.ss_decisiondate = ss_decisiondate;
	}
	public String getSs_yesno() {
		return ss_yesno;
	}
	public void setSs_yesno(String ss_yesno) {
		this.ss_yesno = ss_yesno;
	}
	public String getSs_statename() {
		return ss_statename;
	}
	public void setSs_statename(String ss_statename) {
		this.ss_statename = ss_statename;
	}
	public String getTs_statename() {
		return ts_statename;
	}
	public void setTs_statename(String ts_statename) {
		this.ts_statename = ts_statename;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	public String getStudy_region() {
		return study_region;
	}
	public void setStudy_region(String study_region) {
		this.study_region = study_region;
	}
	public String getStudy_details() {
		return study_details;
	}
	public void setStudy_details(String study_details) {
		this.study_details = study_details;
	}
	public String getStudy_freq() {
		return study_freq;
	}
	public void setStudy_freq(String study_freq) {
		this.study_freq = study_freq;
	}
	public Date getStudy_opendate() {
		return study_opendate;
	}
	public void setStudy_opendate(Date study_opendate) {
		this.study_opendate = study_opendate;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_birth() {
		return u_birth;
	}
	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFile_storedname() {
		return file_storedname;
	}
	public void setFile_storedname(String file_storedname) {
		this.file_storedname = file_storedname;
	}
	@Override
	public String toString() {
		return "StudyTeamState [u_no=" + u_no + ", study_no=" + study_no + ", ss_statecode=" + ss_statecode
				+ ", ts_statecode=" + ts_statecode + ", ss_applydate=" + ss_applydate + ", ss_decisiondate="
				+ ss_decisiondate + ", ss_yesno=" + ss_yesno + ", ss_statename=" + ss_statename + ", ts_statename="
				+ ts_statename + ", u_name=" + u_name + ", study_name=" + study_name + ", study_region=" + study_region
				+ ", study_details=" + study_details + ", study_freq=" + study_freq + ", study_opendate="
				+ study_opendate + ", u_phone=" + u_phone + ", u_email=" + u_email + ", u_birth=" + u_birth
				+ ", gender=" + gender + ", file_storedname=" + file_storedname + "]";
	}
	
}