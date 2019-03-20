package dao.mypage.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bookmark;
import dto.Message;
import util.DBConn;
import util.Paging;

public class MessageDaoImpl implements MessageDao {
	
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;


//	@Override
//	public void deleteMesssage(int m_no) {
//		String sql="";
//		sql += "DELETE FROM message";
//		sql += " WHERE m_no=?";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, m_no);
//			
//			ps.executeUpdate();
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(ps!=null) ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}	
//		
//		
//	}

	@Override
	public void updateRead(int m_no) {
		String sql="";
		sql += "UPDATE message";
		sql += " SET m_read='y', m_rdate=sysdate";
		sql += " WHERE m_no=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m_no);
			
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
	public List selectMsgPagingList(int side, int u_no, Paging paging) {

		List<Message> msgList = new ArrayList<>();
		String sql = "";
		
		if(side==1) {
				
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM(";
		sql += "		SELECT M.m_no, M.m_comment, M.m_read, M.m_date, M.sender_no, ";
		sql += "			( SELECT u_name FROM users U WHERE M.sender_no = U.u_no ) sender_name";
		sql += "			, M.accepter_no, ( SELECT u_name FROM users U WHERE M.accepter_no = U.u_no ) receiver_name";
		sql += " 		FROM message M";
		sql += " 		WHERE M.accepter_no=?";
		sql += " 		ORDER BY M.m_date";
		sql += "		) B";
		sql += "	ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";	
		
		
		} else if(side==2) {
			
			sql += "SELECT * FROM (";
			sql += "	SELECT rownum rnum, B.* FROM(";
			sql += "		SELECT M.m_no, M.m_comment, M.m_read, M.m_date, M.sender_no, ";
			sql += "			( SELECT u_name FROM users U WHERE M.sender_no = U.u_no ) sender_name";
			sql += "			, M.accepter_no, ( SELECT u_name FROM users U WHERE M.accepter_no = U.u_no ) receiver_name";
			sql += " 		FROM message M";
			sql += " 		WHERE M.sender_no=?";
			sql += " 		ORDER BY M.m_date";
			sql += "		) B";
			sql += "	ORDER BY rnum";
			sql += ") R";
			sql += " WHERE rnum BETWEEN ? AND ?";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Message msg = new Message();
				
				msg.setM_no(rs.getInt("m_no"));
				msg.setM_comment(rs.getString("m_comment"));
				msg.setM_read(rs.getString("m_read"));
				msg.setM_date(rs.getDate("m_date"));
				msg.setSender_no(rs.getInt("sender_no"));
				msg.setSender_name(rs.getString("sender_name"));
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setReceiver_name(rs.getString("receiver_name"));
				
				msgList.add(msg);
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

		return msgList;
	}

	@Override
	public int cntMsg(int side, int u_no) {
		
		String sql = "";
		int cnt=0;
		
		if(side==1) {
			
			sql +="SELECT COUNT(*) FROM message";
			sql +=" WHERE accepter_no=?"		;
			
		} else if(side==2) {
							
				sql +="SELECT COUNT(*) FROM message";
				sql +=" WHERE sender_no=?"		;
		}
			

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
	public Message selectMsgByMno(int m_no) {

		String sql = "";
		Message msg = new Message();
		
			
		sql += "SELECT M.m_no, M.m_comment, M.m_read, M.m_date, M.sender_no, ";
		sql += "		( SELECT u_name FROM users U WHERE M.sender_no = U.u_no ) sender_name";
		sql += "		, M.accepter_no, ( SELECT u_name FROM users U WHERE M.accepter_no = U.u_no ) receiver_name";
		sql += " 	FROM message M";
		sql += " 	WHERE M.m_no=?";
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, m_no);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				msg.setM_no(rs.getInt("m_no"));
				msg.setM_comment(rs.getString("m_comment"));
				msg.setM_read(rs.getString("m_read"));
				msg.setM_date(rs.getDate("m_date"));
				msg.setSender_no(rs.getInt("sender_no"));
				msg.setSender_name(rs.getString("sender_name"));
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setReceiver_name(rs.getString("receiver_name"));

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
		return msg;
	}


	@Override
	public void insertMsg(Message msg) {
		
		String sql = "";
		sql += "INSERT INTO message(m_no, m_comment, m_read, m_date, sender_no, accepter_no)";
		sql += " VALUES(Message_SEQ.nextval,?,'n',sysdate,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, msg.getM_comment());
			ps.setInt(2, msg.getSender_no());
			ps.setInt(3, msg.getReceiver_no());
			
			
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
