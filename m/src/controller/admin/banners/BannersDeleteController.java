package controller.admin.banners;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.banners.BannersDao;
import dao.admin.banners.BannersDaoImpl;
import dto.Banners;
import service.admin.banners.BannersService;
import service.admin.banners.BannersServiceImpl;

@WebServlet("/banners/delete")
public class BannersDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	private BannersDao reportDao = new BannersDaoImpl();
	private BannersService banService = new BannersServiceImpl();
		

protected void doGet(
		HttpServletRequest req,
		HttpServletResponse resp) 
				throws ServletException, IOException {
	//로그인 되어있지 않으면 /main으로 리다이렉트
			
	//요청파라미터 -> MODEL
	        Banners banners = banService.getParam(req, resp);
			
			//회원삭제 수행
		    int bannersdel = banService.delete(banners);
			
			//MODEL 전달
			req.setAttribute("reportdel", bannersdel);
			
			//VIEW지정
			req.getRequestDispatcher("/view/admin/banners/delete.jsp")
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






