package dto;

public class Achive {

	private int study_no;
	private int a_no;
	private String a_title;
	private String a_adate; //목표생성일(sysdate)
	private String a_ddate; //목표마감일
	
	@Override
	public String toString() {
		return "Achive [study_no=" + study_no + ", a_no=" + a_no + ", a_title=" + a_title + ", a_adate=" + a_adate
				+ ", a_ddate=" + a_ddate + "]";
	}
	
	public int getStudy_no() {
		return study_no;
	}
	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_adate() {
		return a_adate;
	}
	public void setA_adate(String a_adate) {
		this.a_adate = a_adate;
	}
	public String getA_ddate() {
		return a_ddate;
	}
	public void setA_ddate(String a_ddate) {
		this.a_ddate = a_ddate;
	}
	
	
}
