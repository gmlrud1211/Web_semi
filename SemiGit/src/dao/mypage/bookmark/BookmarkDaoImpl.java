
package dao.mypage.bookmark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bookmark;
import dto.Message;
import dto.MyBoard;
import util.DBConn;
import util.Paging;

public class BookmarkDaoImpl implements BookmarkDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	

	@Override
	public int CntBookmark(int u_no) {
		String sql = "";
		sql +="SELECT COUNT(*) FROM bookmark";
		sql += " WHERE u_no=?";
		
		int cnt=0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			
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
		
		return cnt;
	}

	@Override
	public void deleteBookmark(int bm_no) {
		String sql="";
		sql += "DELETE FROM bookmark";
		sql += " WHERE bm_no=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bm_no);
			
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
	public List selectBookmarkPagingList(int u_no, Paging paging) {
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, A.* FROM(";
		sql += "		SELECT  B.bm_no, B.u_no, B.study_no, S.study_name, S.file_no, F.file_originname, ";
		sql += "				F.file_storedname, B.bm_date"; 
		sql += " 		FROM study S";
		sql += " 		JOIN bookmark B";
		sql += " 		ON S.study_no = B.study_no";
		sql += " 		JOIN fileupload F";
		sql += " 		ON S.file_no = F.file_no";
		sql += " 		WHERE B.u_no=?";
		sql += " 		ORDER BY b.bm_date";
		sql += "		) A";
		sql += "	ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";	
		
	
		List<Bookmark> bmList = new ArrayList<>();

		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Bookmark bm = new Bookmark();
				
				bm.setBm_no(rs.getInt("bm_no"));
				bm.setU_no(rs.getInt("u_no"));
				bm.setStudy_no(rs.getInt("study_no"));
				bm.setStudy_name(rs.getString("study_name"));
				bm.setFile_no(rs.getInt("file_no"));
				bm.setFile_originname(rs.getString("file_originname"));
				bm.setFile_storedname(rs.getString("file_storedname"));
				bm.setBm_date(rs.getDate("bm_date"));
				
				bmList.add(bm);
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
		
		return bmList;
	}
	

	
}
