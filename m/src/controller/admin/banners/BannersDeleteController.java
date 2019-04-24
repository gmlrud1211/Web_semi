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
	//�α��� �Ǿ����� ������ /main���� �����̷�Ʈ
			
	//��û�Ķ���� -> MODEL
	        Banners banners = banService.getParam(req, resp);
			
			//ȸ������ ����
		    int bannersdel = banService.delete(banners);
			
			//MODEL ����
			req.setAttribute("reportdel", bannersdel);
			
			//VIEW����
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






