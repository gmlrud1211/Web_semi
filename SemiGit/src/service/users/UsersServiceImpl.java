package service.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.users.UsersDao;
import dao.users.UsersDaoImpl;
import dto.Users;

public class UsersServiceImpl implements UsersService {
	
	private UsersDao uDao = new UsersDaoImpl();
	
	@Override
	public Users getParam(HttpServletRequest req, HttpServletResponse resp) {
		String u_id = req.getParameter("u_id");
		String u_pw = req.getParameter("u_pw");
		
		Users u = new Users();
		u.setU_id(u_id);
		u.setU_pw(u_pw);
		
		return u;
	}

	@Override
	public boolean login(Users user) {

		return uDao.login(user);
	}

	@Override
	public Users getUserByUid(Users user) {
		
		return uDao.selectUserByUid(user);
	}

	@Override
	public Users getUserByUno(int u_no) {
		return uDao.selectUserByUno(u_no);
	}

	@Override
	public List getFavoritCateByUno(int u_no) {
		return uDao.selectFavoritCateByUno(u_no);
	}

	@Override
	public void changePw(int u_no, String u_pw) {
		uDao.updatePw(u_no, u_pw);
	}


}
