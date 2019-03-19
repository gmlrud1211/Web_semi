package dao.mypage.message;

import java.util.List;

import dto.Message;
import util.Paging;

public interface MessageDao {
		
		// 읽은 상태 업데이트
		public void updateRead(int m_no);
		
//		// 메시지 삭제
//		public void deleteMesssage(int m_no);
		
		// 쪽지 보내기
		public void insertMsg(Message msg);
		
		// 쪽지 페이징 처리 리스트 반환
		public List selectMsgPagingList(int side, int u_no, Paging paging);
		
		// 총 쪽지 수 반환
		public int cntMsg(int side, int u_no);
		
		// 리스트에서 쪽지 선택
		public Message selectMsgByMno(int m_no);
		
		
	
	
}
