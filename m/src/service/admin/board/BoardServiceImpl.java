package service.admin.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.board.BoardDao;
import dao.admin.board.BoardDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		Board board = new Board();
		
		//��û�Ķ���� �ޱ�
		String b_no= req.getParameter("b_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( b_no!= null && !"".equals(b_no) ) {
			board.setB_no(Integer.parseInt(b_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return board;
	}

	
	
	//board ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	
	
	//�Խñ� �� ��ȸ
	
	@Override
	public Board view(Board boardView) {
//		//��ȸ�� ����
//		boardDao.updateCount(boardView);
		
		//�󼼱� ��ȯ
		return boardDao.selectBoardByBoardno(boardView);
	}

	
	//��û�Ķ���Ϳ��� curPage ��ȯ
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//��û�Ķ���� curPage �ޱ�
		String param = req.getParameter("curPage");
	
		//null�̳� ""�� �ƴϸ� int�� ����
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null�̳� ""�� 0���� ��ȯ�ϱ�
		return 0;
	}


	//�� �Խñ� �� ���
	@Override
	public int getTotalCount() {
		return boardDao.selectCntBoard();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return boardDao.selectPaginglist(paging);
	}



	@Override
	public void delete(int b_no) {
	   boardDao.delectBoardCommentByBoardno(b_no);
       boardDao.delectBoardByBoardno(b_no);
	}



	@Override
	public List<Board> getSearch(String type, String word) {
		
		return boardDao.search(type, word);
	}



	

}

















