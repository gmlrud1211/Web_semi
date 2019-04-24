package service.faq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;

public interface FaqService {

	// ��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Faq getParam(HttpServletRequest req, HttpServletResponse resp);

	// �������� ��ü ��ȸ
	public List getList();

	// �Խñ� �� ��ȸ
	public Faq view(Faq faqview);

	// FAQ ����
	public int delete(Faq faqdel);

	// ��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);

	// �� �Խñ� �� ���
	public int getTotalCount();

	// faq ���
	public void insert(Faq faqinsert);

	// FAQ ����
	public void update(Faq faqup);

	

}
