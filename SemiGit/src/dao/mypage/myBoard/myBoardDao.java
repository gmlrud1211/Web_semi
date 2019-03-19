package dao.mypage.myBoard;

import java.util.List;

import dto.MyBoard;
import util.Paging;

public interface myBoardDao {

//	public List selectBoardListByUno(int u_no);
	
	public MyBoard selectBoardByBno(int b_no);
	
	// �� �ۼ� �Խñ� �� ��ȯ
	public int cntMyBoard(int u_no);
	
	// ����ں� �ۼ� �Խñ� ����¡ ó�� ����Ʈ ��ȯ
	public List selectMyBoardPagingList(int u_no, Paging paging);
	
	
}
