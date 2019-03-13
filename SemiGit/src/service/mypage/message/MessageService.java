package service.mypage.message;

import java.util.List;

import dto.Message;

public interface MessageService {

	// 사용자별 받은 쪽지 조회
	public List getReceivedMessageListByUno(int u_no);
		
	// 받은 리스트에서 선택한 쪽지 반환 
	public Message getReceivedMessageByMno(int m_no);
		
	// 읽은 상태 업데이트
	public void updateRead(int m_no);
		
	// 쪽지 삭제
//	public void deleteMessage(int m_no);
	
	// 사용자별 보낸 쪽지 조회
	public List getSentMessageListByUno(int u_no);
	
	// 보낸 리스트에서 선택한 쪽지 반환
	public Message getSentMessageByMno(int m_no);
	
	// 쪽지 보내기
	public void sendMessage(int sender_no, int receiver_no, String m_comment);
	
	
	
}
