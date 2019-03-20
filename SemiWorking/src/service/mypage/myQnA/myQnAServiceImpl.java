package service.mypage.myQnA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.mypage.myQnA.myQnADao;
import dao.mypage.myQnA.myQnADaoImpl;
import dto.QnA;
import utill.Paging;

public class myQnAServiceImpl implements myQnAService {

	myQnADao qnaDao = new myQnADaoImpl();
	
//	@Override
//	public List getQnAListByUno(int u_no) {
//		return qnaDao.selectQnAListByUno(u_no);
//	}

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
	public int getTotalMyQnACount(int u_no) {
		return qnaDao.cntMyQnA(u_no);
	}

	@Override
	public List getMyQnAPagingList(int u_no, Paging paging) {
		return qnaDao.selectMyQnAPagingList(u_no, paging);
	}

}
