package dto;

public class Study {

	   private int study_no;
	   private int st_code;//스터디 분류 코드
	   private String study_name;
	   private int file_no;//파일번호
	   private String study_region;//희망지역
	   private String study_time;//시간
	   private String study_freq;//스터디 빈도
	   private int study_min;//최소인원
	   private int study_max;//최대인원
	   private int study_gender;//성별
	   private int study_details;//상세내용
	   private int study_opendate;//스터디시작일(모집마감)
	   private int study_period;//스터디 종료일
	   private int study_addrecruit;//추가모집기간
	   private int u_no;//회원번호
	   
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
	   public int getStudy_gender() {
	      return study_gender;
	   }
	   public void setStudy_gender(int study_gender) {
	      this.study_gender = study_gender;
	   }
	   public int getStudy_details() {
	      return study_details;
	   }
	   public void setStudy_details(int study_details) {
	      this.study_details = study_details;
	   }
	   public int getStudy_opendate() {
	      return study_opendate;
	   }
	   public void setStudy_opendate(int study_opendate) {
	      this.study_opendate = study_opendate;
	   }
	   public int getStudy_period() {
	      return study_period;
	   }
	   public void setStudy_period(int study_period) {
	      this.study_period = study_period;
	   }
	   public int getStudy_addrecruit() {
	      return study_addrecruit;
	   }
	   public void setStudy_addrecruit(int study_addrecruit) {
	      this.study_addrecruit = study_addrecruit;
	   }
	   public int getU_no() {
	      return u_no;
	   }
	   public void setU_no(int u_no) {
	      this.u_no = u_no;
	   }
	   @Override
	   public String toString() {
	      return "Study [study_no=" + study_no + ", st_code=" + st_code + ", study_name=" + study_name + ", file_no="
	            + file_no + ", study_region=" + study_region + ", study_time=" + study_time + ", study_freq="
	            + study_freq + ", study_min=" + study_min + ", study_max=" + study_max + ", study_gender="
	            + study_gender + ", study_details=" + study_details + ", study_opendate=" + study_opendate
	            + ", study_period=" + study_period + ", study_addrecruit=" + study_addrecruit + ", u_no=" + u_no + "]";
	   }

	
}
