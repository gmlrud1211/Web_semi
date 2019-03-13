package service.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;

public interface UsersService {

	public Users getParam(HttpServletRequest req, HttpServletResponse resp);

//	id/pw 일치하는 행 COUNT로 처리
	public boolean login(Users user);
	
	public Users getUserByUid(Users user);

	
}
