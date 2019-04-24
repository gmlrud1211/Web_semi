package dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.StudyCategory;
import dto.UserFavoritCate;
import dto.Users;
import util.DBConn;

public class UsersDaoImpl implements UsersDao {
private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;

	// yn begin --------------------------------------
	
	@Override
	public int seletCntUserByUid(Users u) {

		String sql = "";
		sql +="SELECT COUNT(*) FROM users";
		sql +=" WHERE u_id=?";
		
		int cnt=0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getU_id());
			rs = ps.executeQuery();

		while(rs.next()) {
			cnt = rs.getInt(1);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// --- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				// --------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 		
		System.out.println("CNT:"+cnt);
		return cnt;
	}

	@Override
	public Users selectUserByUid(Users u) {
		String sql = "";
		sql +="SELECT * FROM users";
		sql +=" WHERE u_id=?";
		
		Users user = new Users();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getU_id());
			
			rs = ps.executeQuery();

			while(rs.next()) {
				user.setU_no(rs.getInt("u_no"));
				user.setU_id(rs.getString("u_id"));
				user.setU_name(rs.getString("u_name"));
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// --- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				// --------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		return user;
	}

	@Override
	public boolean login(Users u) {
		String sql = "";
		sql +="SELECT COUNT(*) FROM users";
		sql +=" WHERE u_id=? "
				+ "AND u_pw=?";
		
		boolean login=false;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getU_id());
			ps.setString(2, u.getU_pw());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				login=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// --- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				// --------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		return login;
	}

	@Override
	public Users selectUserByUno(int u_no) {
		String sql = "";
		sql +="SELECT * FROM users";
		sql +=" WHERE u_no=?";
		
		Users user = new Users();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setU_no(rs.getInt("u_no"));
				user.setU_id(rs.getString("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_pw(rs.getString("u_pw"));
				user.setU_email(rs.getString("u_email"));
				user.setU_birth(rs.getString("u_birth").substring(0, 10));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_regdate(rs.getDate("u_regdate"));
				
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// --- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				// --------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		return user;
	}

	@Override
	public List selectFavoritCateByUno(int u_no) {

		String sql = "";
		
		sql += "SELECT U.u_no, F.st_code, C.st_catename ";
		sql += "	FROM userfavoritcate F";
		sql += " 	JOIN studycategory C";
		sql += " 	ON F.st_code = C.st_catecode";
		sql += " 	JOIN users U";
		sql += " 	ON F.u_no = U.u_no";
		sql += " 	WHERE U.u_no=?";
		sql += " 	ORDER BY F.st_code";	
		
		List <UserFavoritCate> ucList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
						
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserFavoritCate uc = new UserFavoritCate();

				uc.setU_no(rs.getInt("u_no"));
				uc.setSt_code(rs.getInt("st_code"));
				uc.setSt_catename(rs.getString("st_catename"));
				
				ucList.add(uc);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return ucList;
	}

	@Override
	public void updatePw(int u_no, String nu_pw) {
		String sql = "";
		sql +="UPDATE users";
		sql +=" SET u_pw=?";
		sql +=" WHERE u_no=?";
				
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,nu_pw);
			ps.setInt(2, u_no);
				
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

	@Override
	public List selectCateList() {
		String sql = "";
		sql += "SELECT * FROM studycategory";
		
		List<StudyCategory> cateList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				StudyCategory cate = new StudyCategory();
				
				cate.setSt_catecode(rs.getInt("st_catecode"));
				cate.setSt_catename(rs.getString("st_catename"));
				
				cateList.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cateList;
	}

	@Override
	public void updateUsers(int u_no, Users u) {
		String sql = "";
		sql +="UPDATE users";
		sql +=" SET u_email=?, u_phone=?, u_birth=TO_DATE(?, 'yyyy/MM/dd')";
		sql +=" WHERE u_no=?";
				
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,u.getU_email());
			ps.setString(2, u.getU_phone());
			ps.setString(3, u.getU_birth());
			ps.setInt(4, u_no);
				
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void addFavoriteCate(int u_no, String favorite) {
			
		String sql = "";
		sql +="INSERT INTO userfavoritcate(u_no, st_code)";
		sql +=" VALUES (?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, u_no);
			ps.setString(2, favorite);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteFavoriteCate(int u_no) {
		String sql = "";
		sql += "DELETE FROM userfavoritcate";
		sql +=" WHERE u_no=?";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, u_no);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// yn end -----------------------------------------------
	
	@Override
	public boolean dupId(String userId) {
		boolean dupFlat = false;
		
		String sql = "";
		sql += "SELECT COUNT(*) FROM USERS";
		sql += " WHERE U_ID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			rs.next();
			int result = rs.getInt(1);
			
			if(result == 0)
				dupFlat = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dupFlat;
	}

	@Override
	public List<StudyCategory> cateList() {
		String sql = "";
		sql += "SELECT * FROM STUDYCATEGORY";
		
		List<StudyCategory> cateList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				StudyCategory cate = new StudyCategory();
				
				cate.setSt_catecode(rs.getInt("st_catecode"));
				cate.setSt_catename(rs.getString("st_catename"));
				
				cateList.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cateList;
	}

	@Override
	public int getUsersNo() {
		String sql = "";
		sql += "SELECT users_seq.nextval FROM dual";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void insertUsers(Users mem) {
		// �쉶�썝 db insert
		String sql = "";
		sql += "INSERT INTO USERS ";
		sql += " (U_NO, U_ID, U_PW, U_NAME, U_PHONE, U_EMAIL, U_BIRTH, U_REGDATE)";
		sql += " VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(SYSDATE, 'YY/MM/DD'))";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mem.getU_no());
			ps.setString(2, mem.getU_id());
			ps.setString(3, mem.getU_pw());
			ps.setString(4, mem.getU_name());
			ps.setString(5, mem.getU_phone());
			ps.setString(6, mem.getU_email());
			ps.setString(7, mem.getU_birth());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertUserFavoriteCate(Users mem, String favorite) {
		
		System.out.println(mem.getU_no());
		System.out.println(favorite);
		
		String sql = "";
		sql += "INSERT INTO USERFAVORITCATE ";
		sql += " (U_NO, ST_CODE)";
		sql += " VALUES (?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mem.getU_no());
			ps.setString(2, favorite);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
