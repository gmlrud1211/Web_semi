package service.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudyCategory;
import dto.UserFavoritCate;
import dto.Users;

public interface UsersService {

	// yn begin ---------------------------------------------
	public Users loginGetParam(HttpServletRequest req, HttpServletResponse resp);

	//	id/pw 일치하는 행 COUNT로 처리
	public boolean login(Users user);
	
	public Users getUserByUid(Users user);
	
	public Users getUserByUno(int u_no);

	public List<UserFavoritCate> getFavoritCateByUno(int u_no);
	
	public void changePw(int u_no, String nu_pw);
	
	// 스터디 카테고리 반환(대분류)
	public List<StudyCategory> getCateList();
	
	public Users updateGetParam(HttpServletRequest req, HttpServletResponse resp);
	
	public void updateUsers(int u_no, Users user, String[] favoritcate);

	// yn end -------------------------------------------------
	public boolean dupId(String userId);

	public List<StudyCategory> cateList();

	//회원가입 요청파라미터 얻기
	public Users getMemberParam(HttpServletRequest request);
	
	//회원가입 선호카테고리 얻기
	public String[] getUserFavoriteCateParam(HttpServletRequest request);
	
	//회원가입 처리
	public void joinMem(Users mem, String[] favoriteList);
	
}
