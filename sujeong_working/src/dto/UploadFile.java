package dto;

import java.util.Date;

public class UploadFile {
	private int fileno;
	private int boardno;
	private String origin_name;
	private String stored_name;
	private String content_type;
	private long file_size;
	private Date upload_date;
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public String getStored_name() {
		return stored_name;
	}
	public void setStored_name(String stored_name) {
		this.stored_name = stored_name;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long l) {
		this.file_size = l;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	@Override
	public String toString() {
		return "UploadFile [fileno=" + fileno + ", boardno=" + boardno + ", origin_name=" + origin_name
				+ ", stored_name=" + stored_name + ", content_type=" + content_type + ", file_size=" + file_size
				+ ", upload_date=" + upload_date + "]";
	}
}
