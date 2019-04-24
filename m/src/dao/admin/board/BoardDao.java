package dao.admin.board;

import java.util.List;

import dto.Board;
import dto.BoardComment;
import util.Paging;

public interface BoardDao {

	//�������� ��ü ��ȸ
	public List selectAll();

//	// ��ȸ�� ����
//	public void updateCount(NoticeBoard nboardview);
	
	//�Խñ� ����ȸ ��ȯ
	public Board selectBoardByBoardno(Board boardview);
	
	//�����Խ��� ���� ��ȯ
	public void delectBoardByBoardno(int b_no);
	
	//�����Խ��� ��� ���� ��ȯ
	public void delectBoardCommentByBoardno(int b_no);
	
	//�� �Խñ� �� ��ȯ
	public int selectCntBoard();
	
	//����¡ ó�� �Խñ� ��ȯ
	public List selectPaginglist(Paging paging);
	
	
	//�Խ��� �� �˻� �� ������ ��ȯ
	public List<Board> search(String type, String word);
	
}
















