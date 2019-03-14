package service.mypage.myBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.mypage.myBoard.myBoardDao;
import dao.mypage.myBoard.myBoardDaoImpl;
import dto.MyBoard;
import utill.Paging;

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

		// null이나 ""면 0으로 반환
		return 0;
	}
	
	@Override
	public int getTotalMyBoardCount(int u_no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List getMyBoardPagingList(int u_no, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

}
