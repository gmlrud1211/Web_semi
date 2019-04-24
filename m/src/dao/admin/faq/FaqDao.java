package dao.admin.faq;

import java.util.List;

import dto.Faq;
import dto.NoticeBoard;
import util.Paging;

public interface FaqDao {

	// faq 전체 조회
	public List<Faq> selectAll();

	// faq 공지사항 상세조회 반환
	public Faq selectFaqByFaqno(Faq faqview);

	// faq 삭제 반환
	public int delectFaqByFaqno(Faq faqdel);

	// 총 게시글 수 반환
	public int selectCntFaq();

	// FAQ 등록
	public void faqInsert(Faq faqinsert);

	// FAQ 수정
	public void update(Faq faqup);
	
	// FAQ 삭제
	public int delectFaqByFaqdno(Faq faqdel);

}
