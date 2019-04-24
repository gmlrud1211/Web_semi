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
		//��û�Ķ���� -> MODEL
		Faq faq = faqService.getParam(req, resp);
		
		//ȸ������ ����
		int faqdel = faqService.delete(faq);
		
		//MODEL ����
		req.setAttribute("faqdel", faqdel);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/faq/delete.jsp")
			.forward(req, resp);
		
	}
	
}







