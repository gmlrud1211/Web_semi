package service.admin.faq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.faq.FaqDao;
import dao.admin.faq.FaqDaoImpl;
import dto.Faq;
import dto.NoticeBoard;
import util.Paging;

public class FaqServiceImpl implements FaqService {

	private FaqDao faqdao = new FaqDaoImpl();

	@Override
	public Faq getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Faq faq = new Faq();
		
		//요청파라미터 받기
		String faq_no = req.getParameter("faq_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( faq_no!= null && !"".equals(faq_no) ) {
			faq.setFaq_no(Integer.parseInt(faq_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return faq;
	}

	
	
	//noticeboard 테이블 전체 조회결과 반환
	@Override
	public List<Faq> getList() {
		return faqdao.selectAll();
	}

	
	
	//게시글 상세 조회
	@Override
	public Faq view(Faq faqview) {

		
		//상세글 반환
		return faqdao.selectFaqByFaqno(faqview);
	}

	
	//요청파라미터에서 curPage 반환
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//요청파라미터 curPage 받기
		String param = req.getParameter("curPage");
		int curPage = -1;
		//null이나 ""이 아니면 int로 리턴
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			
		}
		
		//null이나 ""면 0으로 반환하기
		return curPage;
	}


	//총 게시글 수 얻기
	@Override
	public int getTotalCount() {
		return faqdao.selectCntFaq();
	}

	

	@Override
	public int delete(Faq faqdel) {
		return faqdao.delectFaqByFaqno(faqdel);
	}



	@Override
	public void insert(Faq faqinsert) {
		
		faqdao.faqInsert(faqinsert);
	}

	
	public void update(Faq faqup) {
		
		faqdao.update(faqup);
	}


}

















