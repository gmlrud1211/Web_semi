package dto;

import java.util.Date;

public class Faq {

	private int faq_no;
	private String faq_cate;     
	private String faq_qusetion; 
	private String faq_answer;    
	private Date faq_date;
	

	
	@Override
	public String toString() {
		return "Faq [faq_no=" + faq_no + ", faq_cate=" + faq_cate + ", faq_qusetion=" + faq_qusetion + ", faq_answer="
				+ faq_answer + ", faq_date=" + faq_date + "]";
	}
	
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_cate() {
		return faq_cate;
	}
	public void setFaq_cate(String faq_cate) {
		this.faq_cate = faq_cate;
	}
	public String getFaq_qusetion() {
		return faq_qusetion;
	}
	public void setFaq_qusetion(String faq_qusetion) {
		this.faq_qusetion = faq_qusetion;
	}
	public String getFaq_answer() {
		return faq_answer;
	}
	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	
	
}
