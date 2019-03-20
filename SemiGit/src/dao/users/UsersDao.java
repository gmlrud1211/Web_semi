package dao.users;

import java.util.List;

import dto.Users;

public interface UsersDao {

	public int seletCntUserByUid(Users u);
	
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);
	
	public Users selectUserByUno(int u_no);
	
	public List selectFavoritCateByUno(int u_no);
			
	public void updatePw(int u_no, String nu_pw);

	
}
