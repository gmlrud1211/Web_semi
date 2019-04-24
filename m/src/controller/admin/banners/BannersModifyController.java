package controller.admin.banners;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.admin.banners.BannersDao;
import dao.admin.banners.BannersDaoImpl;
import dto.Banners;
import dto.FileUpload;
import service.admin.banners.BannersService;
import service.admin.banners.BannersServiceImpl;

@WebServlet("/banners/modify")
public class BannersModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BannersService banService = new BannersServiceImpl();
	private BannersDao bannersDao = new BannersDaoImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 /main으로 리다이렉트
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //리다이렉트
			return; //doGet 중단
		}
		
		  //요청파라미터 -> MODEL
	      Banners banners = banService.getParam(req, resp);
				
		  //게시글 조회수행
		  Banners bannerup = banService.view(banners);
				
		  //MODEL 전달
		  req.setAttribute("bannerup", bannerup);
		  
//		  req.getSession().setAttribute("bn_no", banners.getBn_no());
		
		req.getRequestDispatcher("/view/admin/banners/modify.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpsession = req.getSession(true);
		httpsession.getAttribute("bn_no");
		System.out.println("sadsaddsdas" + httpsession.getAttribute("bn_no"));
		//한글인코딩
				req.setCharacterEncoding("utf-8");
				
				//요청파라미터
//				Banners banners = banService.getParam(req, resp)
				
				String bn_title = req.getParameter("title");
				System.out.println("배너명" + bn_title);


				// 파일번호 구하기
				String filenoParam = req.getParameter("file_no");
				System.out.println(req.getParameter("file_no"));
				int file_no = -1;

				if (filenoParam != null && !"".equals(filenoParam)) {
					file_no = Integer.parseInt(filenoParam);
					System.out.println("file_no:" + file_no);

				}
				System.out.println("구하기 : " + file_no);

				
				//배너 번호 얻기 
				int bn_no = bannersDao.getBanners_no();
				
				//배너 정보 입력
				Banners banners = new Banners();
				banners.setBn_title(bn_title);
				banners.setBn_no(bn_no);
				banners.setFile_no(file_no);
				
				//배너 삽입
				banService.insert(banners);
				
				System.out.println("게시글 삽입 후 : "+file_no);
				
				 //파일첨부가 존재하면 처리
				if(file_no != -1) {
					FileUpload fileupload = new FileUpload();
					fileupload.setFile_no(file_no);

				//게시글과 파일을 연결
				bannersDao.updateFile(fileupload);
				}
				
				System.out.println("파일첨부 존재할 경우 : "+file_no);
				
				resp.sendRedirect("/banners/list");
		
	}
	
}
















