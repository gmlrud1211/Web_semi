package service.mypage.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Message;
import utill.Paging;

public interface MessageService {

	
		// ���� ����Ʈ���� ������ ���� ��ȯ 
		public Message getReceivedMessageByMno(int m_no);
			
		// ���� ����Ʈ���� ������ ���� ��ȯ
		public Message getSentMessageByMno(int m_no);
		
		// ���� ���� ������Ʈ
		public void updateRead(int m_no);
			
		// ���� ����
//		public void deleteMessage(int m_no);
		
		// ����ں� ���� ���� ��ȸ
//		public List getSentMessageListByUno(int u_no);
		
		
		// ���� ���� ������
		public void replyMessage(int sender_no, int receiver_no, String m_comment);
	
		
		// ��û�Ķ���Ϳ��� curPage ��ȯ
		public int getCurPage(HttpServletRequest req);
		
		// �� ���� ���� �� ���
		public int getTotalReceivedMsgCount(int receiver_no);
		
		// �� ���� ���� �� ���
		public int getTotalSentMsgCount(int sender_no);
		
		// ����ں� ���� ���� ����¡ ����Ʈ ���
		public List getReceivedMsgPagingList(int u_no, Paging paging);
	
		// ����ں� ���� ���� ����¡ ����Ʈ ���
		public List getSentMsgPagingList(int u_no, Paging paging);
	
}
