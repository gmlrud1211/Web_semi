package dao.mypage.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bookmark;
import dto.Message;
import utill.DBConn;

public class MessageDaoImpl implements MessageDao {
	
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectReceivedListByUserno(int u_no) {
		
		String sql = "";
		
		sql += "SELECT M.m_no, M.m_comment, M.m_read, M.m_date, M.sender_no, M.accepter_no, U.u_name"; 
		sql += " FROM message M";
		sql += " JOIN users U";
		sql += " ON M.accepter_no = U.u_no";
		sql += " WHERE M.sender_no=?";
		sql += " ORDER BY M.m_date";
		
		List msgList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Message msg = new Message();
				
				msg.setM_no(rs.getInt("m_no"));
				msg.setM_comment(rs.getString("m_comment"));
				msg.setM_read(rs.getString("m_read"));
				msg.setM_date(rs.getDate("m_date"));
				msg.setSender_no(rs.getInt("sender_no"));
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setU_name(rs.getString("u_name"));
				
				msgList.add(msg);
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
		return msgList;
	}

	@Override
	public int selectCntMessage(int receiver_no) {
		String sql = "";
		sql +="SELECT COUNT(*) FROM message";
		sql +=" WHERE accepter_no=?"		;
		
		int cnt=0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, receiver_no);

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
	public void deleteMesssage(int m_no) {
		String sql="";
		sql += "DELETE FROM message";
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
	public Message selectReceivedMessageByMno(int m_no) {
		
		String sql = "";
		
		sql += "SELECT M.m_no, M.m_comment, M.m_read, M.m_date, "
				+ "M.sender_no, U.u_name, M.accepter_no "; 
		sql += " FROM message M";
		sql += " JOIN users U";
		sql += " ON M.sender_no = U.u_no";
		sql += " WHERE M.m_no=?";

		Message msg = new Message();

		
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
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setU_name(rs.getString("u_name"));
				

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
	public void updateRead(int m_no) {
		String sql="";
		sql += "UPDATE message";
		sql += " SET m_read=y AND m_rdate=sysdate";
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
	public List selectSentListByUserno(int u_no) {
		String sql = "";
		
		sql += "SELECT M.m_no, M.m_comment, M.m_read, M.m_date, "
				+ "M.sender_no, U.u_name, M.accepter_no "; 
		sql += " FROM message M";
		sql += " JOIN users U";
		sql += " ON M.accepter_no = U.u_no";
		sql += " WHERE M.sender_no=?";
		sql += " ORDER BY M.m_date";

		List<Message> msgList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Message msg = new Message();
				
				msg.setM_no(rs.getInt("m_no"));
				msg.setM_comment(rs.getString("m_comment"));
				msg.setM_read(rs.getString("m_read"));
				msg.setM_date(rs.getDate("m_date"));
				msg.setSender_no(rs.getInt("sender_no"));
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setU_name(rs.getString("u_name"));
				
				msgList.add(msg);
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
		return msgList;
	}

	@Override
	public Message selectSentMessageByMno(int m_no) {
		String sql = "";
		
		sql += "SELECT M.m_no, M.m_comment, M.m_read, M.m_date, "
				+ "M.sender_no, U.u_name, M.accepter_no "; 
		sql += " FROM message M";
		sql += " JOIN users U";
		sql += " ON M.accepter_no = U.u_no";
		sql += " WHERE M.m_no=?";

		Message msg = new Message();

		
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
				msg.setReceiver_no(rs.getInt("accepter_no"));
				msg.setU_name(rs.getString("u_name"));
				

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
	public void sendMessage(Message msg) {
		String sql = "";
		sql += "INSERT INTO message(m_no, m_comment, m_read, m_date, sender_no, receiver_no)";
		sql += " VALUES(Message_SEQ.nextval,?,n,sysdate,?,?)";
		
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
