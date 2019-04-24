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

		//현재 페이지 번호 얻기
		int curPage = reportService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount = reportService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//게시글목록 MODEL로 추가
		List<Report> reportlist = reportService.getPagingList(paging);
		req.setAttribute("reportlist", reportlist);
		System.out.println(reportlist);
		
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/report/list.jsp")
			.forward(req, resp);
		
	}
	
}









