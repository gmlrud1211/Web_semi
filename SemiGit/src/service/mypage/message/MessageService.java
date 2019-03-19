package service.mypage.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Message;
import util.Paging;

public interface MessageService {


		// ���� ���� ������Ʈ
		public void updateRead(int m_no);
			
		// ���� ����
//		public void deleteMessage(int m_no);
		
		
		// ���� ���� ������
		public void sendMsg(Message msg);
		
		// ��û�Ķ���Ϳ��� curPage ��ȯ
		public int getCurPage(HttpServletRequest req);

		
		// 쪽지 페이징 처리 리스트 반환
		public List getMsgPagingList(int side, int u_no, Paging paging);
		
		// 총 쪽지 수 반환
		public int getTotalMsgCount(int side, int u_no);
		
		// 선택한 쪽지 반환
		public Message getMsgByMno(int m_no);
		
		public String getSide(HttpServletRequest req, HttpServletResponse resp);
		
	
}
