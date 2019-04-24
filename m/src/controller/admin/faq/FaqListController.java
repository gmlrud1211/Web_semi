package controller.admin.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import service.admin.faq.FaqService;
import service.admin.faq.FaqServiceImpl;
import util.Paging;

@WebServlet("/faq/list")
public class FaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
//		//현재 페이지 번호 얻기
//		int curPage = faqService.getCurPage(req);
//		System.out.println(curPage);
//		//총 게시글 수 얻기
//		int totalCount = faqService.getTotalCount();
//		System.out.println(totalCount);
//		//페이지 객체 생성
//		Paging paging = new Paging(totalCount, curPage);
////		System.out.println(paging);
//		
		Faq faq = new Faq();
	
		//게시글목록 MODEL로 추가
		List<Faq> faqlist = faqService.getList();
		req.setAttribute("faqlist", faqlist);
		
	
		//VIEW지정
		req.getRequestDispatcher("/view/admin/faq/list.jsp")
			.forward(req, resp);
		
	}
	
}









