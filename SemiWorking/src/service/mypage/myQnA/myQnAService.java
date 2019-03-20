package service.mypage.myQnA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.QnA;
import utill.Paging;

public interface myQnAService {
	
//public List getQnAListByUno(int u_no);
	
	public QnA getQnAByOneno(int one_no); 
	
	public void writeQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);
	
	// ��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
				
	// �� ���Ǳ� �� ���
	public int getTotalMyQnACount(int u_no);
		
	// ����ں� ���Ǳ� ����¡ ����Ʈ ���
	public List getMyQnAPagingList(int u_no, Paging paging);
			

}
