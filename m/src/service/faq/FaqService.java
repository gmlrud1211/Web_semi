package service.faq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;

public interface FaqService {

	// 요청파라미터 데이터를 객체화하여 반환
	public Faq getParam(HttpServletRequest req, HttpServletResponse resp);

	// 공지사항 전체 조회
	public List getList();

	// 게시글 상세 조회
	public Faq view(Faq faqview);

	// FAQ 삭제
	public int delete(Faq faqdel);

	// 요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);

	// 총 게시글 수 얻기
	public int getTotalCount();

	// faq 등록
	public void insert(Faq faqinsert);

	// FAQ 수정
	public void update(Faq faqup);

	

}
