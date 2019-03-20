package dao.mypage.myQnA;

import java.util.List;

import dto.QnA;
import utill.Paging;

public interface myQnADao {

//	public List selectQnAListByUno(int u_no);
	
	public QnA selectQnAByOneno(int one_no); 
	
	public void insertQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);
	
	// �� �ۼ� �Խñ� �� ��ȯ
	public int cntMyQnA(int u_no);
		
	// ����ں� �ۼ� �Խñ� ����¡ ó�� ����Ʈ ��ȯ
	public List selectMyQnAPagingList(int u_no, Paging paging);
		
}
