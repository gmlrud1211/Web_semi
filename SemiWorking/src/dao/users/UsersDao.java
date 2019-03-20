package dao.users;

import dto.Users;

public interface UsersDao {

	public int seletCntUserByUid(Users u);
	
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);

	
}
