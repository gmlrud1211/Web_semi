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
	
	// 총 작성 게시글 수 반환
	public int cntMyQnA(int u_no);
		
	// 사용자별 작성 게시글 페이징 처리 리스트 반환
	public List selectMyQnAPagingList(int u_no, Paging paging);
		
}
