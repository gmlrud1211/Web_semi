package dao.admin.faq;

import java.util.List;

import dto.Faq;
import dto.NoticeBoard;
import util.Paging;

public interface FaqDao {

	// faq ��ü ��ȸ
	public List<Faq> selectAll();

	// faq �������� ����ȸ ��ȯ
	public Faq selectFaqByFaqno(Faq faqview);

	// faq ���� ��ȯ
	public int delectFaqByFaqno(Faq faqdel);

	// �� �Խñ� �� ��ȯ
	public int selectCntFaq();

	// FAQ ���
	public void faqInsert(Faq faqinsert);

	// FAQ ����
	public void update(Faq faqup);
	
	// FAQ ����
	public int delectFaqByFaqdno(Faq faqdel);

}
