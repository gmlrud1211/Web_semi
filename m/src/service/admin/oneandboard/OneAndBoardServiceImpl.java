package service.admin.oneandboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.oneandboard.OneAndBoardDao;
import dao.admin.oneandboard.OneAndBoardDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.OneAndBoard;
import util.Paging;

public class OneAndBoardServiceImpl implements OneAndBoardService {

	private OneAndBoardDao oboardDao = new OneAndBoardDaoImpl();

	@Override
	public OneAndBoard getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		OneAndBoard oboard = new OneAndBoard();
		
		//��û�Ķ���� �ޱ�
		String one_no= req.getParameter("one_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( one_no!= null && !"".equals(one_no) ) {
			oboard.setOne_no(Integer.parseInt(one_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return oboard;
	}

	
	
	//noticeboard ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return oboardDao.selectAll();
	}

	
	
	//�Խñ� �� ��ȸ
	
	@Override
	public OneAndBoard view(OneAndBoard oboardView) {
	
		//�󼼱� ��ȯ
		return oboardDao.selectOneBoardByOneno(oboardView);
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
		return oboardDao.selectCntOneBoard();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return oboardDao.selectPaginglist(paging);
	}

	
	@Override
	public void update(OneAndBoard oboardupdate) {
		
		oboardDao.oneAndBoardUpdate(oboardupdate);
    }

	@Override
	public List<OneAndBoard> getSearch(String type, String word) {
		
		return oboardDao.search(type, word);
	}



}













