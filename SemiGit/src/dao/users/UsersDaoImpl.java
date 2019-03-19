package dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bookmark;
import dto.UserFavoritCate;
import dto.Users;
import util.DBConn;

public class UsersDaoImpl implements UsersDao {
private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;

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
				// --- 자원 해제 ---
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
				// --- 자원 해제 ---
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
				// --- 자원 해제 ---
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
//				user.setU_pw(rs.getString("u_pw"));
				user.setU_email(rs.getString("u_email"));
				user.setU_birth(rs.getString("u_birth"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_regdate(rs.getDate("u_regdate"));
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// --- 자원 해제 ---
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
		
		sql += "SELECT U.u_no, F.st_code, C.st_cate, C.st_subcate, C.st_category_code ";
		sql += "	FROM userfavoritcate F";
		sql += " 	JOIN studycate C";
		sql += " 	ON F.st_code = C.st_code";
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
				uc.setSt_cate(rs.getString("st_cate"));
				uc.setSt_subcate(rs.getString("st_subcate"));
//				uc.setSt_category_code(rs.getString("st_category_code"));
				
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
	public void updatePw(int u_no, String u_pw) {
		String sql = "";
		sql +="UPDATE users(u_pw)";
		sql +=" SET u_pw=?";
		sql +=" WHERE u_no=?";
				
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,u_pw);
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

}
