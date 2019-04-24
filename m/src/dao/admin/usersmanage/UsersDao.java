package dao.admin.usersmanage;

import java.util.List;

import dto.NoticeBoard;
import dto.Users;
import util.Paging;

public interface UsersDao {

	//users ��ü ��ȸ
	public List selectAll();
	
	//ȸ�� ��ȸ ��ȯ
	public Users selectUsersByUsersno(Users usersview);
	
    //ȸ�� ���� ��ȯ
	public boolean deleteUsersByUsersno(Users usersdel);
	
	//�� ȸ���� ��ȯ
	public int selectCntUsers();
	
	//����¡ ó�� �Խñ� ��ȯ
	public List selectPaginglist(Paging paging);
	
	// ȸ�� �˻�
	public List<Users> search(String type, String word);
	
    
}
















