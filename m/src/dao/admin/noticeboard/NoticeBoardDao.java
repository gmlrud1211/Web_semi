package dao.admin.noticeboard;

import java.util.List;

import dto.NoticeBoard;
import util.Paging;

public interface NoticeBoardDao {

	//�������� ��ü ��ȸ
	public List selectAll();
	

	//�������� ����ȸ ��ȯ

	//�������� ��ȸ�� ����
	public void updateCount(NoticeBoard nboardview);
	
	//�������� ����ȸ ��ȯ
	public NoticeBoard selectBoardByBoardno(NoticeBoard nboardview);
	
	//�������� ���� ��ȯ
	public int delectNboardByNboardno(NoticeBoard nboarddel);
	
	//�� �Խñ� �� ��ȯ
	public int selectCntBoard();
	
	//����¡ ó�� �Խñ� ��ȯ
	public List selectPaginglist(Paging paging);
		

    //�������� ���
	public void noticeBoardInsert(NoticeBoard nboardinsert);

	//�������� ����
	public void update(NoticeBoard nboardUpdate);
	
	//�������� �˻� 
	public List<NoticeBoard> search(String type, String word);
}
















