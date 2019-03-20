package service.mypage.myQnA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.mypage.myQnA.myQnADao;
import dao.mypage.myQnA.myQnADaoImpl;
import dto.FileUpload;
import dto.QnA;
import util.Paging;

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

		// null�̳� ""�� 0���� ��ȯ
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

	@Override
	public int getQnA_no() {
		return qnaDao.getQnA_no();
	}

	@Override
	public void updateFile(FileUpload fileupload) {
		qnaDao.updateFile(fileupload);
		
	}

	@Override
	public FileUpload getFileByFileno(int file_no) {
		return qnaDao.selectFileByFileno(file_no);
	}

}
