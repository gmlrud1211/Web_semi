package service.mypage.myBoard;

import java.util.List;

import dto.MyBoard;

public interface myBoardService {
	
	public List getBoardListByUno(int u_no);
	
	public MyBoard getBoardByBno(int b_no);

}
