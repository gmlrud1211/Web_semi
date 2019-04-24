package service.admin.usersmanage;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.usersmanage.UsersDao;
import dao.admin.usersmanage.UsersDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.Users;
import util.DBConn;
import util.Paging;

public class UsersServiceImpl implements UsersService {

	private UsersDao usersDao = new UsersDaoImpl();

	@Override
	public Users getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		Users users = new Users();
		
		//��û�Ķ���� �ޱ�
		String u_no = req.getParameter("u_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( u_no!= null && !"".equals(u_no) ) {
			users.setU_no(Integer.parseInt(u_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return users;
	}

	
	
	//users���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return usersDao.selectAll();
	}

	
	//ȸ������ �� ��ȸ
	@Override
	public Users view(Users usersview) {
	
		//�󼼱� ��ȯ
		return usersDao.selectUsersByUsersno(usersview);
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
		return usersDao.selectCntUsers();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return usersDao.selectPaginglist(paging);
	}



	@Override
	public boolean delete(Users userdel) {
		
		
		Connection conn = DBConn.getConnection();
		
		//ȸ������ ��ȯ
		if ( usersDao.deleteUsersByUsersno(userdel) ){
			//����  ����
			
			return  true;
		} else {
			//����  ����
			return false;
		}
		
		
		}
	
	@Override
	public List<Users> getSearch(String type, String word) {
		
		return usersDao.search(type, word);
	}
	}



















