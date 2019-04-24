package controller.admin.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.NoticeBoard;
import dto.Report;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;
import service.admin.report.ReportService;
import service.admin.report.ReportServiceImpl;

@WebServlet("/report/view")
public class ReportViewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터 -> MODEL
		Report report = reportService.getParam(req, resp);
		
		//게시글 조회수행
		Report reportdel = reportService.view(report);
		
		req.getSession().setAttribute("rp_no", report.getRp_no());
		req.getSession().setAttribute("rp_status", report.getRp_status());
		
		//MODEL 전달reportServic
		req.setAttribute("reportdel", reportdel);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/report/detail.jsp")
			.forward(req, resp);
		
	}
	
	
   @Override
   	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		
	   HttpSession httpsession = req.getSession(true);
	   httpsession.getAttribute("rp_no");
	   System.out.println("sadsaddsdas" + httpsession.getAttribute("nb_no"));
	   
	   Report report = new Report();
	   
	   
	   int rp_no = (Integer)httpsession.getAttribute("rp_no");
	   
	   System.out.println(rp_no);
	   
	   report.setRp_no(rp_no);
	   
	   reportService.update(report);
	   
	   resp.sendRedirect("/report/list");

   		
   	}	
	
	
}







