package service.admin.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public interface ReportService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Report getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//�Ű� ��ü ��ȸ
	public List getList();
	
	//�Ű�Խñ� �� ��ȸ
	public Report view(Report reportview);
	
    //�Ű� �Խñ� ���� 
	public int delete(Report reportup);
	
	//�Ű�ó������ ������Ʈ
	public void update(Report reportup);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� �Խñ� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);
	
	//�Ű�� �˻� 
	public List<Report> getSearch(String type, String word);
	
}

















