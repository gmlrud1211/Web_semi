package service.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.noticeboard.NoticeBoardDao;
import dao.admin.noticeboard.NoticeBoardDaoImpl;
import dto.NoticeBoard;
import util.Paging;

public class NoticeBoardServiceImpl implements NoticeBoardService {

	private NoticeBoardDao nboardDao = new NoticeBoardDaoImpl();

	@Override
	public NoticeBoard getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		NoticeBoard nboard = new NoticeBoard();
		
		//��û�Ķ���� �ޱ�
		String nb_no= req.getParameter("nb_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( nb_no!= null && !"".equals(nb_no) ) {
			nboard.setNb_no(Integer.parseInt(nb_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return nboard;
	}

	
	
	//noticeboard ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return nboardDao.selectAll();
	}

	
	
	//�Խñ� �� ��ȸ
	//	��ȸ�� �Խñ��� ��ȸ���� ������Ų��
	@Override
	public NoticeBoard view(NoticeBoard nboardView) {
		//��ȸ�� ����
		nboardDao.updateCount(nboardView);
		
		//�󼼱� ��ȯ
		return nboardDao.selectBoardByBoardno(nboardView);
	}

	
	//��û�Ķ���Ϳ��� curPage ��ȯ
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//��û�Ķ���� curPage �ޱ�
		String param = req.getParameter("curPage");
	
		//null�̳� ""�� �ƴϸ� int�� ����
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null�̳� ""�� 0���� ��ȯ�ϱ�
		return 0;
	}


	//�� �Խñ� �� ���
	@Override
	public int getTotalCount() {
		return nboardDao.selectCntBoard();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return nboardDao.selectPaginglist(paging);
	}



	@Override
	public int delete(NoticeBoard nboarddel) {
		
     return nboardDao.delectNboardByNboardno(nboarddel);
	}



	@Override
	public void insert(NoticeBoard nboard) {
		
		nboardDao.noticeBoardInsert(nboard);
	}



	@Override
	public void update(NoticeBoard nboardUpdate) {
		
		nboardDao.update(nboardUpdate);
		
	}



	@Override
	public List<NoticeBoard> getSearch(String type, String word) {
		
		return nboardDao.search(type,word);
	}

}

















