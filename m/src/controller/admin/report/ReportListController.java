package controller.admin.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Report;
import service.admin.report.ReportService;
import service.admin.report.ReportServiceImpl;
import util.Paging;

@WebServlet("/report/list")
public class ReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage = reportService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount = reportService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<Report> reportlist = reportService.getPagingList(paging);
		req.setAttribute("reportlist", reportlist);
		System.out.println(reportlist);
		
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/report/list.jsp")
			.forward(req, resp);
		
	}
	
}









