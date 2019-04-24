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
		
		//��û�Ķ���� ������ ������ DTO��ü
		Faq faq = new Faq();
		
		//��û�Ķ���� �ޱ�
		String faq_no = req.getParameter("faq_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( faq_no!= null && !"".equals(faq_no) ) {
			faq.setFaq_no(Integer.parseInt(faq_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return faq;
	}

	
	
	//noticeboard ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List<Faq> getList() {
		return faqdao.selectAll();
	}

	
	
	//�Խñ� �� ��ȸ
	@Override
	public Faq view(Faq faqview) {

		
		//�󼼱� ��ȯ
		return faqdao.selectFaqByFaqno(faqview);
	}

	
	//��û�Ķ���Ϳ��� curPage ��ȯ
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//��û�Ķ���� curPage �ޱ�
		String param = req.getParameter("curPage");
		int curPage = -1;
		//null�̳� ""�� �ƴϸ� int�� ����
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			
		}
		
		//null�̳� ""�� 0���� ��ȯ�ϱ�
		return curPage;
	}


	//�� �Խñ� �� ���
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

















