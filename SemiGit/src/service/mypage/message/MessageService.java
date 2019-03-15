package service.mypage.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Message;
import utill.Paging;

public interface MessageService {

	
		// 받은 리스트에서 선택한 쪽지 반환 
		public Message getReceivedMessageByMno(int m_no);
			
		// 보낸 리스트에서 선택한 쪽지 반환
		public Message getSentMessageByMno(int m_no);
		
		// 읽은 상태 업데이트
		public void updateRead(int m_no);
			
		// 쪽지 삭제
//		public void deleteMessage(int m_no);
		
		// 사용자별 보낸 쪽지 조회
//		public List getSentMessageListByUno(int u_no);
		
		
		// 쪽지 답장 보내기
		public void replyMessage(int sender_no, int receiver_no, String m_comment);
	
		
		// 요청파라미터에서 curPage 반환
		public int getCurPage(HttpServletRequest req);
		
		// 총 받은 쪽지 수 얻기
		public int getTotalReceivedMsgCount(int receiver_no);
		
		// 총 보낸 쪽지 수 얻기
		public int getTotalSentMsgCount(int sender_no);
		
		// 사용자별 받은 쪽지 페이징 리스트 얻기
		public List getReceivedMsgPagingList(int u_no, Paging paging);
	
		// 사용자별 받은 쪽지 페이징 리스트 얻기
		public List getSentMsgPagingList(int u_no, Paging paging);
	
}
