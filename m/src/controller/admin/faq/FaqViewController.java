package controller.admin.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import dto.NoticeBoard;
import service.admin.faq.FaqService;
import service.admin.faq.FaqServiceImpl;

@WebServlet("/faq/view")
public class FaqViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//요청파라미터 -> MODEL
		Faq faq = faqService.getParam(req, resp);
		
		//게시글 조회수행
		Faq faqlist = faqService.view(faq);
		
		//MODEL 전달
		req.setAttribute("faqlist", faqlist);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/faq/view.jsp")
			.forward(req, resp);
		
	}
	
}







