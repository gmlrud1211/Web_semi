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

@WebServlet("/report/search")
public class ReportSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		
		//요청파라미터 -> MODEL
		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type);
		System.out.println(word);		
		
		//게시글 조회수행
		List<Report> reportlist = reportService.getSearch(type, word);
		
		//MODEL 전달
		req.setAttribute("reportlist", reportlist);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/report/list.jsp")
			.forward(req, resp);
		
	}
	
}







