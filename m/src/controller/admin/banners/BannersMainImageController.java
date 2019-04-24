package controller.admin.banners;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Banners;
import service.admin.banners.BannersService;
import service.admin.banners.BannersServiceImpl;
import util.Paging;

@WebServlet("/banners/main")
public class BannersMainImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BannersService banService = new BannersServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//배너 목록 MODEL로 추가
		List<Banners> bannerlist =  banService.getList();
		req.setAttribute("bannerlist", bannerlist);
		
		System.out.println(bannerlist);
		
		
		//VIEW지정
		req.getRequestDispatcher("/view/mainBanner.jsp")
			.forward(req, resp);
		
	}
	
}









