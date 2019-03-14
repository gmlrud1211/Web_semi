package dao.mypage.myQnA;

import java.util.List;

import dto.QnA;

public interface myQnADao {

	public List selectQnAListByUno(int u_no);
	
	public QnA selectQnAByOneno(int one_no); 
	
	public void insertQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);
}
