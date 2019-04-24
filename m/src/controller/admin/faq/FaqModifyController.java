package controller.admin.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Faq;
import dto.NoticeBoard;
import service.admin.faq.FaqService;
import service.admin.faq.FaqServiceImpl;

@WebServlet("/faq/modify")
public class FaqModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//�α��� �Ǿ����� ������ /main���� �����̷�Ʈ
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //�����̷�Ʈ
			return; //doGet �ߴ�
		}
		
		  //��û�Ķ���� -> MODEL
          Faq faq = faqService.getParam(req, resp);
				
		  //�Խñ� ��ȸ����
          Faq faqview = faqService.view(faq);
				
		  //MODEL ����
		  req.setAttribute("faqview", faqview);
		
		  
		  req.getSession().setAttribute("faq_no", faq.getFaq_no());
			
		req.getRequestDispatcher("/view/admin/faq/modify.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpSession httpsession = req.getSession(true);
		//httpsession.getAttribute("faq_no");
		//System.out.println("sadsaddsdas" + httpsession.getAttribute("faq_no"));

		req.setCharacterEncoding("utf-8");

		
		Faq faq= new Faq();
		
		
	   // int faq_no = (Integer)httpsession.getAttribute("faq_no");
	    
	    int faq_no = Integer.parseInt(req.getParameter("faq_no"));
		String faq_cate = req.getParameter("cate");
		String faq_qusetion = req.getParameter("quse");
		String faq_answer = req.getParameter("ans");
		
		
		System.out.println(faq_no);
		System.out.println(faq_cate);
		System.out.println(faq_qusetion);
		System.out.println(faq_answer);
		
		
		faq.setFaq_no(faq_no);
		faq.setFaq_cate(faq_cate);
		faq.setFaq_qusetion(faq_qusetion);
		faq.setFaq_answer(faq_answer);
		
		faqService.update(faq);
		
 	    resp.sendRedirect("/faq/list");
		
	}
	
}
















