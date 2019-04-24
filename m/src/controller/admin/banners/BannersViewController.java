package controller.admin.banners;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import dto.Report;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;
import service.admin.report.ReportService;
import service.admin.report.ReportServiceImpl;

@WebServlet("/banners/view")
public class BannersViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��û�Ķ���� -> MODEL
		Report report = reportService.getParam(req, resp);
		
		//�Խñ� ��ȸ����
		Report reportdel = reportService.view(report);
		
		//MODEL ����reportServic
		req.setAttribute("reportdel", reportdel);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/report/view.jsp")
			.forward(req, resp);
		
	}
	
}







