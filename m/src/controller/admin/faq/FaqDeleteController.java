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

@WebServlet("/faq/delete")
public class FaqDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청파라미터 -> MODEL
		Faq faq = faqService.getParam(req, resp);
		
		//회원삭제 수행
		int faqdel = faqService.delete(faq);
		
		//MODEL 전달
		req.setAttribute("faqdel", faqdel);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/faq/delete.jsp")
			.forward(req, resp);
		
	}
	
}







