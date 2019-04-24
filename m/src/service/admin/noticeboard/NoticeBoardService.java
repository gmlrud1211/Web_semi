package service.admin.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import util.Paging;

public interface NoticeBoardService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public NoticeBoard getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//�������� ��ü ��ȸ
	public List getList();
	
	//�������� �˻� ��ȸ 
	public List<NoticeBoard> getSearch(String type, String word);
	
	//�Խñ� �� ��ȸ
	//	��ȸ�� �Խñ��� ��ȸ���� ������Ų��
	public NoticeBoard view(NoticeBoard nboardview);
	
	// �Խñ� ���� 
	public int delete(NoticeBoard nboarddel);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� �Խñ� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);
	
	//�Խñ� ���
	public void insert(NoticeBoard nboard);
	
	// �������� ����
	public void update(NoticeBoard nboardUpdate);
	
}

















