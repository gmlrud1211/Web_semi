package controller.admin.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import service.admin.faq.FaqService;
import service.admin.faq.FaqServiceImpl;

@WebServlet("/faq/write")
public class FaqWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FaqService faqService = new FaqServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 /main으로 리다이렉트
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main"); //리다이렉트
			return; //doGet 중단
		}
		
		req.getRequestDispatcher("/view/admin/faq/write.jsp")
			.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		Faq faq = new Faq();
		
		
		String faq_cate = req.getParameter("cate");
		String faq_qusetion = req.getParameter("quse");
		String faq_answer = req.getParameter("ans");
		
		System.out.println(faq_cate);
		System.out.println(faq_qusetion);
		System.out.println(faq_answer);
		
		faq.setFaq_cate(faq_cate);
		faq.setFaq_qusetion(faq_qusetion);
		faq.setFaq_answer(faq_answer);
		
		faqService.insert(faq);
 	    resp.sendRedirect("/faq/list");
 	    
	}
	
}
















