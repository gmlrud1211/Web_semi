package dao.mypage.message;

import java.util.List;

import dto.Message;

public interface MessageDao {

	// 사용자별 받은 쪽지 조회
	public List selectReceivedListByUserno(int u_no);
	
	// 받은 리스트에서 쪽지 선택
	public Message selectReceivedMessageByMno(int m_no);
	
	// 총 쪽지 수 반환
	public int selectCntMessage(int receiver_no);
	
	// 읽은 상태 업데이트
	public void updateRead(int m_no);
		
	// 메시지 삭제
	public void deleteMesssage(int m_no);
	
	// 사용자별 보낸 쪽지 조회
	public List selectSentListByUserno(int u_no);
	
	// 보낸 리스트에서 쪽지 선택
	public Message selectSentMessageByMno(int m_no);
	
	// 쪽지 보내기
	public void sendMessage(int sender_no, int receiver_no, String m_comment);
	
	
}
