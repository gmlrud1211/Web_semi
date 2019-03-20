package dao.mypage.myBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Message;
import dto.MyBoard;
import util.DBConn;
import util.Paging;

public class myBoardDaoImpl implements myBoardDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	

	@Override
	public MyBoard selectBoardByBno(int b_no) {
		
		String sql = "";
		sql +="SELECT * FROM board";
		sql +=" WHERE b_no=?";

		MyBoard mb = new MyBoard();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, b_no);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				mb.setB_no(rs.getInt("b_no"));
				mb.setU_no(rs.getInt("u_no"));
				mb.setB_head(rs.getString("b_head"));
				mb.setB_title(rs.getString("b_title"));
				mb.setB_upcount(rs.getInt("b_upcount"));
				mb.setB_count(rs.getInt("b_count"));
				mb.setB_date(rs.getDate("b_date"));
				

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return mb;
	}

	@Override
	public int cntMyBoard(int u_no) {
		String sql = "";
		sql +="SELECT COUNT(*) FROM board";
		sql +=" WHERE u_no=?";
		
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
	public List selectMyBoardPagingList(int u_no, Paging paging) {
		
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM(";
		sql += "		SELECT * FROM board";
		sql += " 			WHERE u_no=?";
		sql += " 			ORDER BY b_no";
		sql += "		) B";
		sql += "	ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<MyBoard> mbList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				MyBoard mb = new MyBoard();
				
				mb.setB_no(rs.getInt("b_no"));
				mb.setU_no(rs.getInt("u_no"));
				mb.setB_head(rs.getString("b_head"));
				mb.setB_title(rs.getString("b_title"));
				mb.setB_upcount(rs.getInt("b_upcount"));
				mb.setB_count(rs.getInt("b_count"));
				mb.setB_date(rs.getDate("b_date"));
								
				mbList.add(mb);
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
		
		return mbList;
	}

}
