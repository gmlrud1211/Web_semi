package service.admin.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import util.Paging;

public interface BoardService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Board getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//�Խñ� ��ü ��ȸ
	public List getList();

	
	//�Խñ� �˻� ��ȸ
	public List<Board> getSearch(String type, String word);
	
	//�Խñ� �� ��ȸ
	public Board view(Board boardview);
	
	// �Խñ� , ��� ���� 
	public void delete(int b_no);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� �Խñ� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);
	
	
	
}

















