package dao.users;

import java.util.List;

import dto.Users;

public interface UsersDao {
	public boolean dupId(String userId);
	
	public List cateList();
	
	public int getUsersNo();
	
	public void insertUsers(Users mem);
	
	public void insertUserFavoriteCate(Users mem, String favorite);
	
	public int seletCntUserByUid(Users u);
	
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);
}

