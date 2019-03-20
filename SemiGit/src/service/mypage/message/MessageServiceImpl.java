package service.mypage.message;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mypage.message.MessageDao;
import dao.mypage.message.MessageDaoImpl;
import dto.Message;
import util.Paging;

public class MessageServiceImpl implements MessageService {

	private MessageDao msgDao = new MessageDaoImpl();
	

	@Override
	public void updateRead(int m_no) {
		msgDao.updateRead(m_no);
	}


	@Override
	public void sendMsg(Message msg) {
		msgDao.insertMsg(msg);
	}


	@Override
	public int getCurPage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		if(param!=null && !"".equals(param) ) {

			int curPage = Integer.parseInt(param);
			return curPage;
		}

		return 0;
	}

	@Override
	public List getMsgPagingList(int side, int u_no, Paging paging) {
		return msgDao.selectMsgPagingList(side, u_no, paging);
	}

	@Override
	public int getTotalMsgCount(int side, int u_no) {
		return msgDao.cntMsg(side, u_no);
	}


	@Override
	public Message getMsgByMno(int m_no) {
		return msgDao.selectMsgByMno(m_no);
	}


	@Override
	public String getSide(HttpServletRequest req, HttpServletResponse resp) {
				
		String side = "sender";
		
		return side;
	}
	
	
//	@Override
//	public void deleteMessage(int m_no) {
//		msgDao.deleteMesssage(m_no);
//	}

	

	
	
	
}
