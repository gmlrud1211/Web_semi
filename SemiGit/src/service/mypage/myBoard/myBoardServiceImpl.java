package service.mypage.myBoard;

import java.util.List;

import dao.mypage.myBoard.myBoardDao;
import dao.mypage.myBoard.myBoardDaoImpl;
import dto.MyBoard;

public class myBoardServiceImpl implements myBoardService {
	
	myBoardDao mbDao = new myBoardDaoImpl();

	@Override
	public List getBoardListByUno(int u_no) {
		return mbDao.selectBoardListByUno(u_no);
	}

	@Override
	public MyBoard getBoardByBno(int b_no) {
		return mbDao.selectBoardByBno(b_no);
	}

}
