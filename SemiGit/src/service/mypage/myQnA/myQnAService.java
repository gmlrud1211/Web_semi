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
	
	// 요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
				
	// 총 문의글 수 얻기
	public int getTotalMyQnACount(int u_no);
		
	// 사용자별 문의글 페이징 리스트 얻기
	public List getMyQnAPagingList(int u_no, Paging paging);
			

}
