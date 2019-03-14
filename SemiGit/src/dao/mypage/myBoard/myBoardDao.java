package dao.mypage.myBoard;

import java.util.List;

import dto.MyBoard;

public interface myBoardDao {

	public List selectBoardListByUno(int u_no);
	
	public MyBoard selectBoardByBno(int b_no);
	
	
}
