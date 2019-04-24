package controller.admin.report;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.report.ReportDao;
import dao.admin.report.ReportDaoImpl;
import dto.NoticeBoard;
import dto.Report;
import service.admin.report.ReportService;
import service.admin.report.ReportServiceImpl;

@WebServlet("/report/delete")
public class ReportDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportDao reportDao = new ReportDaoImpl();
	private ReportService reportService = new ReportServiceImpl();
		

protected void doGet(
		HttpServletRequest req,
		HttpServletResponse resp) 
				throws ServletException, IOException {
	//로그인 되어있지 않으면 /main으로 리다이렉트
			
	//요청파라미터 -> MODEL
			Report report = reportService.getParam(req, resp);
			
			//회원삭제 수행
		    int reportdel = reportService.delete(report);
			
			//MODEL 전달
			req.setAttribute("reportdel", reportdel);
			
			//VIEW지정
			req.getRequestDispatcher("/view/admin/report/delete.jsp")
				.forward(req, resp);
			
}

//@Override
//protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	req.setCharacterEncoding("utf-8");
//	
////	String param = req.getParameter("rp_no");
//	
//	Report report = new Report();
//	
//	int rp_no = Integer.parseInt(req.getParameter("rp_no"));
//	
//	System.out.println(rp_no);
//	
//	report.setRp_no(rp_no);
//	
//	
//	reportService.delete(report);
//	
//	resp.sendRedirect("/report/list");
//	
//	
////-------------------------------------------------------
//	
//
//}

}






