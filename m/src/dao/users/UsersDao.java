package dao.users;

import java.util.List;

import dto.Users;

public interface UsersDao {
	
	// yn begin ---------------------------------------------

	public int seletCntUserByUid(Users u);
	
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);
	
	public Users selectUserByUno(int u_no);
	
	public List selectFavoritCateByUno(int u_no);
			
	public void updatePw(int u_no, String nu_pw);
	
	public List selectCateList();
	
	public void updateUsers(int u_no, Users u);
	
	public void addFavoriteCate(int u_no, String favorite);
	
	public void deleteFavoriteCate(int u_no);
	
	// yn end -------------------------------------------------
	
	public boolean dupId(String userId);
	
	public List cateList();
	
	public int getUsersNo();
	
	public void insertUsers(Users mem);
	
	public void insertUserFavoriteCate(Users mem, String favorite);
	
}
