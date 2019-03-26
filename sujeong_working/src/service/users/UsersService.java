package service.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudyCategory;
import dto.Users;

public interface UsersService {
	
	public boolean dupId(String userId);

	public List<StudyCategory> cateList();

	//회원가입 요청파라미터 얻기
	public Users getMemberParam(HttpServletRequest request);
	
	//회원가입 선호카테고리 얻기
	public String[] getUserFavoriteCateParam(HttpServletRequest request);
	
	//회원가입 처리
	public void joinMem(Users mem, String[] favoriteList);

	public Users getParam(HttpServletRequest req, HttpServletResponse resp);
	
//	id/pw 일치하는 행 COUNT로 처리
	public boolean login(Users user);
	
	public Users getUserByUid(Users user);

}
