package dao.bookmark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.bookmark.Bookmark;
import dto.users.Users;
import utill.DBConn;

public class BookmarkDaoImpl implements BookmarkDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectByUserno(int u_no) {
		
		String sql = "";
		sql +="SELECT * FROM bookmark";
		sql +=" WHERE u_no=?";

		List<Bookmark> bmList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Bookmark bm = new Bookmark();
				
				bm.setBm_no(rs.getInt("bm_no"));
				bm.setU_no(rs.getInt("u_no"));
				bm.setStudy_no(rs.getInt("study_no"));
				bm.setBm_date(rs.getDate("bm_date"));
				
				bmList.add(bm);
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
		
		return bmList;
	}

	@Override
	public int selectCntBookmark() {
		String sql = "";
		sql +="SELECT COUNT(*) FROM bookmark";
		
		int cnt=0;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt(1);	
			
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
		
		// 전체 게시글 수 반환
		return cnt;
	}

	@Override
	public void deleteBookmark(Bookmark bm) {
		String sql="";
		sql += "DELETE FROM bookmark";
		sql += " WHERE bm_no=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bm.getBm_no());
			
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
