package dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
