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
		
		//�α��� �Ǿ����� ������ /main���� �����̷�Ʈ
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //�����̷�Ʈ
			return; //doGet �ߴ�
		}
		
		  //��û�Ķ���� -> MODEL
	      Banners banners = banService.getParam(req, resp);
				
		  //�Խñ� ��ȸ����
		  Banners bannerup = banService.view(banners);
				
		  //MODEL ����
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
		//�ѱ����ڵ�
				req.setCharacterEncoding("utf-8");
				
				//��û�Ķ����
//				Banners banners = banService.getParam(req, resp)
				
				String bn_title = req.getParameter("title");
				System.out.println("��ʸ�" + bn_title);


				// ���Ϲ�ȣ ���ϱ�
				String filenoParam = req.getParameter("file_no");
				System.out.println(req.getParameter("file_no"));
				int file_no = -1;

				if (filenoParam != null && !"".equals(filenoParam)) {
					file_no = Integer.parseInt(filenoParam);
					System.out.println("file_no:" + file_no);

				}
				System.out.println("���ϱ� : " + file_no);

				
				//��� ��ȣ ��� 
				int bn_no = bannersDao.getBanners_no();
				
				//��� ���� �Է�
				Banners banners = new Banners();
				banners.setBn_title(bn_title);
				banners.setBn_no(bn_no);
				banners.setFile_no(file_no);
				
				//��� ����
				banService.insert(banners);
				
				System.out.println("�Խñ� ���� �� : "+file_no);
				
				 //����÷�ΰ� �����ϸ� ó��
				if(file_no != -1) {
					FileUpload fileupload = new FileUpload();
					fileupload.setFile_no(file_no);

				//�Խñ۰� ������ ����
				bannersDao.updateFile(fileupload);
				}
				
				System.out.println("����÷�� ������ ��� : "+file_no);
				
				resp.sendRedirect("/banners/list");
		
	}
	
}
















