package service.admin.oneandboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import dto.OneAndBoard;
import util.Paging;

public interface OneAndBoardService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public OneAndBoard getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//1��1 ��ü ��ȸ
	public List getList();
	
	//1��1 �� ��ȸ
    public OneAndBoard view(OneAndBoard oboardview);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� �Խñ� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);


	// �亯 ��� ������Ʈ
	public void update(OneAndBoard oboardupdate);


	//1��1 ���� �˻� ��ȸ
	public List<OneAndBoard> getSearch(String type, String word);
	
}

















