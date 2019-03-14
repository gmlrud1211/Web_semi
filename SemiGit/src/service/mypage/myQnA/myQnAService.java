package service.mypage.myQnA;

import java.util.List;

import dto.QnA;

public interface myQnAService {
	
public List getQnAListByUno(int u_no);
	
	public QnA getQnAByOneno(int one_no); 
	
	public void writeQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);

}
