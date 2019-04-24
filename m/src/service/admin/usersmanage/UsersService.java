package service.admin.usersmanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import dto.Users;
import util.Paging;

public interface UsersService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Users getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//ȸ�� ��ü ��ȸ
	public List getList();
	
	//ȸ������ �� ��ȸ
	public Users view(Users usersview);
	
	//ȸ�� ����
	public boolean delete(Users userdel);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� ȸ�� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);
	
	//ȸ����ȸ
	public List<Users> getSearch(String type, String word);
}

















