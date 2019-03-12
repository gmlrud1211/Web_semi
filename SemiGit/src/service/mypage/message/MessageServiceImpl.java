package service.mypage.message;

import java.util.List;

import dao.mypage.message.MessageDao;
import dao.mypage.message.MessageDaoImpl;
import dto.Message;

public class MessageServiceImpl implements MessageService {

	private MessageDao msgDao = new MessageDaoImpl();
	
	@Override
	public List getMessageListByUno(int u_no) {
		return msgDao.selectByUserno(u_no);
	}

	@Override
	public Message getMessageByMno(int m_no) {
		return msgDao.selectByMessageno(m_no);
	}

	@Override
	public void updateRead(int m_no) {
		msgDao.updateRead(m_no);
	}

	@Override
	public void deleteMessage(int m_no) {
		msgDao.deleteMesssage(m_no);
	}


	
	
	
}
