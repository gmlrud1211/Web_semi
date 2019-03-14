package service.mypage.myQnA;

import java.util.List;

import dao.mypage.myQnA.myQnADao;
import dao.mypage.myQnA.myQnADaoImpl;
import dto.QnA;

public class myQnAServiceImpl implements myQnAService {

	myQnADao qnaDao = new myQnADaoImpl();
	
	@Override
	public List getQnAListByUno(int u_no) {
		return qnaDao.selectQnAListByUno(u_no);
	}

	@Override
	public QnA getQnAByOneno(int one_no) {
		return qnaDao.selectQnAByOneno(one_no);
	}

	@Override
	public void writeQnA(QnA qna) {
		qnaDao.insertQnA(qna);
	}

	@Override
	public void deleteQnA(int one_no) {
		qnaDao.deleteQnA(one_no);
	}

	@Override
	public void answerQnA(QnA qna) {
		qnaDao.answerQnA(qna);
	}

}
