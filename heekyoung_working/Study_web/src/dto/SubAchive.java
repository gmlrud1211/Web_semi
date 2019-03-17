package dto;

public class SubAchive {

	private int study_no;
	private int a_no;
	private int suba_no;
	private String suba_name;
	private String suba_sdate;
	private String suba_ddate;
	
	@Override
	public String toString() {
		return "SubAchive [study_no=" + study_no + ", a_no=" + a_no + ", suba_no=" + suba_no + ", suba_name="
				+ suba_name + ", suba_sdate=" + suba_sdate + ", suba_ddate=" + suba_ddate + "]";
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

	public int getSuba_no() {
		return suba_no;
	}

	public void setSuba_no(int suba_no) {
		this.suba_no = suba_no;
	}

	public String getSuba_name() {
		return suba_name;
	}

	public void setSuba_name(String suba_name) {
		this.suba_name = suba_name;
	}

	public String getSuba_sdate() {
		return suba_sdate;
	}

	public void setSuba_sdate(String suba_sdate) {
		this.suba_sdate = suba_sdate;
	}

	public String getSuba_ddate() {
		return suba_ddate;
	}

	public void setSuba_ddate(String suba_ddate) {
		this.suba_ddate = suba_ddate;
	}

	
	
}
