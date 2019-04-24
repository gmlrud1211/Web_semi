package service.admin.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.report.ReportDao;
import dao.admin.report.ReportDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public class ReportServiceImpl implements ReportService {

	private ReportDao reportDao = new ReportDaoImpl();

	@Override
	public Report getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		Report report = new Report();
		
		//��û�Ķ���� �ޱ�
		String rp_no= req.getParameter("rp_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( rp_no!= null && !"".equals(rp_no) ) {
			report.setRp_no(Integer.parseInt(rp_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return report;
	}

	
	
	//noticeboard ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return reportDao.selectAll();
	}

	
	
	//�Խñ� �� ��ȸ
	@Override
	public Report view(Report reportview) {
		
		
		//�󼼱� ��ȯ
		return reportDao.selectReportByReportno(reportview);
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
		return reportDao.selectCntReport();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return reportDao.selectPaginglist(paging);
	}



	@Override
	public int delete(Report reportdel) {

		return reportDao.deleteReportByReportno(reportdel);
	}


	@Override
	public List<Report> getSearch(String type, String word) {
		
		return reportDao.search(type, word);
	}



	@Override
	public void update(Report reportup) {
	   reportDao.updateStatus(reportup);
		
	}

	
}

















