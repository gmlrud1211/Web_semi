package service.mypage.myBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.MyBoard;
import util.Paging;

public interface myBoardService {
	
//	public List getBoardListByUno(int u_no);
	
	public MyBoard getBoardByBno(int b_no);
	
	// ��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
			
	// �� �ۼ� �Խñ� �� ���
	public int getTotalMyBoardCount(int u_no);
	
	// ����ں� �Խñ� ����¡ ����Ʈ ���
	public List getMyBoardPagingList(int u_no, Paging paging);
		
	

}
