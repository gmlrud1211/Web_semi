package dto;

public class AchivePeople {

	private int suba_no;
	private String sub_code;
	private int u_no;
	
	private int study_no;
	private int a_no;
	private boolean checked;

	
	@Override
	public String toString() {
		return "AchivePeople [suba_no=" + suba_no + ", sub_code=" + sub_code + ", u_no=" + u_no + ", study_no="
				+ study_no + ", a_no=" + a_no + ", checked=" + checked + "]";
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public int getSuba_no() {
		return suba_no;
	}
	public void setSuba_no(int suba_no) {
		this.suba_no = suba_no;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	
	
}
