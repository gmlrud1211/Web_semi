package service.mypage.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mypage.message.MessageDao;
import dao.mypage.message.MessageDaoImpl;
import dto.Message;
import utill.Paging;

public class MessageServiceImpl implements MessageService {

	private MessageDao msgDao = new MessageDaoImpl();
	

	@Override
	public Message getReceivedMessageByMno(int m_no) {
		return msgDao.selectReceivedMessageByMno(m_no);
	}

	@Override
	public void updateRead(int m_no) {
		msgDao.updateRead(m_no);
	}

//	@Override
//	public List getSentMessageListByUno(int u_no) {
//		return msgDao.selectSentListByUserno(u_no);
//	}

	@Override
	public Message getSentMessageByMno(int m_no) {
		return msgDao.selectSentMessageByMno(m_no);
	}

	@Override
	public void replyMessage(int sender_no, int receiver_no, String m_comment) {
		msgDao.replyMessage(sender_no, receiver_no, m_comment);
	}


	@Override
	public int getCurPage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		if(param!=null && !"".equals(param) ) {

			int curPage = Integer.parseInt(param);
			return curPage;
		}

		// null이나 ""면 0으로 반환
		return 0;
	}

	@Override
	public int getTotalReceivedMsgCount(int receiver_no) {
		
		return msgDao.cntReceivedMessage(receiver_no);
	}

	@Override
	public List getReceivedMsgPagingList(int u_no, Paging paging) {
		
		return msgDao.selectReceivedPagingList(u_no, paging);
	}

	@Override
	public int getTotalSentMsgCount(int sender_no) {
		return msgDao.cntSentMessage(sender_no);
	}

	@Override
	public List getSentMsgPagingList(int u_no, Paging paging) {
		return msgDao.selectSentPagingList(u_no, paging);
	}

//	@Override
//	public void deleteMessage(int m_no) {
//		msgDao.deleteMesssage(m_no);
//	}

	

	
	
	
}
