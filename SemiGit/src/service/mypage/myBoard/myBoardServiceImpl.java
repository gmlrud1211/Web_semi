package service.mypage.myBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.mypage.myBoard.myBoardDao;
import dao.mypage.myBoard.myBoardDaoImpl;
import dto.MyBoard;
import util.Paging;

public class myBoardServiceImpl implements myBoardService {
	
	myBoardDao mbDao = new myBoardDaoImpl();

//	@Override
//	public List getBoardListByUno(int u_no) {
//		return mbDao.selectBoardListByUno(u_no);
//	}

	@Override
	public MyBoard getBoardByBno(int b_no) {
		return mbDao.selectBoardByBno(b_no);
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
	public int getTotalMyBoardCount(int u_no) {
		return mbDao.cntMyBoard(u_no);
	}
	
	@Override
	public List getMyBoardPagingList(int u_no, Paging paging) {
		return mbDao.selectMyBoardPagingList(u_no, paging);
	}

}
