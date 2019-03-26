package service.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.users.UsersDao;
import dao.users.UsersDaoImpl;
import dto.StudyCategory;
import dto.Users;

public class UsersServiceImpl implements UsersService {

	private UsersDao usersDao = new UsersDaoImpl();
	
	@Override
	public boolean dupId(String userId) {
		return usersDao.dupId(userId);
	}
	
	@Override
	public List<StudyCategory> cateList() {
		return usersDao.cateList();
	}

	@Override
	public Users getMemberParam(HttpServletRequest request) {
		Users mem = new Users();
		
		// 요청파라미터 받기
		String userId = (String) request.getParameter("id");
		String userPw = (String) request.getParameter("pw");
		String uesrName = (String) request.getParameter("uname");
		String emailId = (String) request.getParameter("eid");
		String eAddress = (String) request.getParameter("eAddress");
		String email = emailId + "@" + eAddress;
		String phone = (String) request.getParameter("phone");
		String year = (String) request.getParameter("birth_year");
		String month = (String) request.getParameter("birth_month");
		
		System.out.println(email);
		System.out.println(eAddress);
		
		int month_int = Integer.parseInt(month);
		if(month_int > 0) {
			month = "0" + month;
		}
				
		String day = (String) request.getParameter("birth_day");
		
		int day_int = Integer.parseInt(day);
		if(day_int > 0) {
			day = "0" + day;
		}
			
		String birthday = year + month + day;

		// DTO에 요청파라미터 담기
		mem.setU_id(userId);
		mem.setU_pw(userPw);
		mem.setU_name(uesrName);
		mem.setU_email(email);
		mem.setU_phone(phone);
		mem.setU_birth(birthday);
		
		return mem;
	}

	@Override
	public String[] getUserFavoriteCateParam(HttpServletRequest request) {
		String[] favoriteList = request.getParameterValues("cate");
		return favoriteList;
	}

	@Override
	public void joinMem(Users mem, String[] favoriteList) {
		mem.setU_no( usersDao.getUsersNo() );
		
		usersDao.insertUsers(mem);
		
		if( favoriteList != null) {
			for(String favorite : favoriteList) {
				usersDao.insertUserFavoriteCate(mem, favorite);
			}
		}
	}
	
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

		return usersDao.login(user);
	}

	@Override
	public Users getUserByUid(Users user) {
		return usersDao.selectUserByUid(user);
	}
}
