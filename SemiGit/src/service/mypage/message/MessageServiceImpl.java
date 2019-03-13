package service.mypage.message;

import java.util.List;

import dao.mypage.message.MessageDao;
import dao.mypage.message.MessageDaoImpl;
import dto.Message;

public class MessageServiceImpl implements MessageService {

	private MessageDao msgDao = new MessageDaoImpl();
	
	@Override
	public List getReceivedMessageListByUno(int u_no) {
		return msgDao.selectReceivedListByUserno(u_no);
	}

	@Override
	public Message getReceivedMessageByMno(int m_no) {
		return msgDao.selectReceivedMessageByMno(m_no);
	}

	@Override
	public void updateRead(int m_no) {
		msgDao.updateRead(m_no);
	}

	@Override
	public List getSentMessageListByUno(int u_no) {
		return msgDao.selectSentListByUserno(u_no);
	}

	@Override
	public Message getSentMessageByMno(int m_no) {
		return msgDao.selectSentMessageByMno(m_no);
	}

	@Override
	public void sendMessage(int sender_no, int receiver_no, String m_comment) {
		msgDao.sendMessage(sender_no, receiver_no, m_comment);
	}

//	@Override
//	public void deleteMessage(int m_no) {
//		msgDao.deleteMesssage(m_no);
//	}

	

	
	
	
}
