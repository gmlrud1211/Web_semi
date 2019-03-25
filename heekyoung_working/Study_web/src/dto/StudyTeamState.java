package dto;

public class StudyTeamState {

	private int u_no;
	private String u_name;
	private int study_no;
	private int ss_statecode;
	private int ts_statecode;
	private String ss_applydate;
	private String ss_decisiondate;
	private String ss_yesno;

	
	@Override
	public String toString() {
		return "StudyTeamState [u_no=" + u_no + ", u_name=" + u_name + ", study_no=" + study_no + ", ss_statecode="
				+ ss_statecode + ", ts_statecode=" + ts_statecode + ", ss_applydate=" + ss_applydate
				+ ", ss_decisiondate=" + ss_decisiondate + ", ss_yesno=" + ss_yesno + "]";
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
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
	
	
}
