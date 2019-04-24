package dao.admin.report;

import java.util.List;

import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public interface ReportDao {

	//�Ű� ��ü ��ȸ
	public List selectAll();

	
	//�Ű����ȸ ��ȯ
	public Report selectReportByReportno(Report reportview);
	
	//�Ű� �Խñ� ���� ��ȯ
	public int deleteReportByReportno(Report reportdel);
	
	//�Ű�� Ŭ���� ���� ������Ʈ 
	public void updateStatus(Report reportup);
	
	//�� �Խñ� �� ��ȯ
	public int selectCntReport();
	
	//����¡ ó�� �Խñ� ��ȯ
	public List selectPaginglist(Paging paging);
	
	//�Ű�� �˻�
	public List<Report> search(String type, String word);
		
	
}
















