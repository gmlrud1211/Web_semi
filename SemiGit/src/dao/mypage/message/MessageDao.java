package dao.mypage.message;

import java.util.List;

import dto.Message;

public interface MessageDao {

	// 사용자별 쪽지 조회
	public List selectByUserno(int u_no);
	
	// 쪽지 선택
	public Message selectByMessageno(int m_no);
	
	// 총 쪽지 수 반환
	public int selectCntMessage(int receiver_no);
	
	// 읽은 상태 업데이트
	public void updateRead(int m_no);
		
	// 메시지 삭제
	public void deleteMesssage(int m_no);
	
}
