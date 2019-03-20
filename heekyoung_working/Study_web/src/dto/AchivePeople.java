package dto;

public class AchivePeople {

	private int suba_no;
	private String sub_code;
	private int u_no;
	private boolean checked;

	
	
	@Override
	public String toString() {
		return "AchivePeople [suba_no=" + suba_no + ", sub_code=" + sub_code + ", u_no=" + u_no + ", checked=" + checked
				+ "]";
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
