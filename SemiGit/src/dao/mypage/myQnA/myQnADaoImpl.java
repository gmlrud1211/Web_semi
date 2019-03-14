package dao.mypage.myQnA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MyBoard;
import dto.QnA;
import utill.DBConn;

public class myQnADaoImpl implements myQnADao {
	
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectQnAListByUno(int u_no) {
		
		String sql = "";
		sql +="SELECT * FROM oneandboard";
		sql +=" WHERE u_no=?";

		List<QnA> qnaList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				QnA qna = new QnA();
				
				qna.setU_no(rs.getInt("u_no"));
				qna.setOne_no(rs.getInt("one_no"));
				qna.setOne_title(rs.getString("one_title"));
				qna.setOne_content(rs.getString("one_content"));
				qna.setOne_status(rs.getString("one_status"));
				qna.setOne_date(rs.getDate("one_date"));
				qna.setOne_anscontent(rs.getString("one_anscontent"));
				qna.setOne_ansdate(rs.getDate("one_ansdate"));
				qna.setFile_no(rs.getInt("file_no"));
									
				qnaList.add(qna);
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
	
		return qnaList;
	}

	@Override
	public QnA selectQnAByOneno(int one_no) {
		String sql = "";
		sql +="SELECT * FROM oneandboard";
		sql +=" WHERE u_no=?";

		QnA qna = new QnA();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, one_no);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				qna.setU_no(rs.getInt("u_no"));
				qna.setOne_no(rs.getInt("one_no"));
				qna.setOne_title(rs.getString("one_title"));
				qna.setOne_content(rs.getString("one_content"));
				qna.setOne_status(rs.getString("one_status"));
				qna.setOne_date(rs.getDate("one_date"));
				qna.setOne_anscontent(rs.getString("one_anscontent"));
				qna.setOne_ansdate(rs.getDate("one_ansdate"));
				qna.setFile_no(rs.getInt("file_no"));
				

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
		return qna;
	}

	@Override
	public void insertQnA(QnA qna) {
		String sql = "";
		sql +="INSERT INTO oneandboard(u_no, one_no, one_title, one_content, file_no, one_date, one_status)";
		sql +=" VALUES(u_no=?, Oneandboard_SEQ.nextval, ?, ?, Fileupload.SEQ.nextval, sysdate, 'n')";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qna.getU_no());
			ps.setString(2, qna.getOne_title());
			ps.setString(3, qna.getOne_content());
				
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
	public void deleteQnA(int one_no) {
		String sql="";
		sql += "DELETE FROM oneandboard";
		sql += " WHERE one_no=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, one_no);
			
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
	public void answerQnA(QnA qna) {
		String sql = "";
		sql +="UPDATE oneandboard(u_no, one_no, one_title, one_content, file_no, one_date, one_status)";
		sql +=" SET one_status='y', one_anscontent=?, one_ansdate=sysdate";
		sql +=" WHERE one_no=?";
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, qna.getOne_anscontent());
			ps.setInt(2, qna.getOne_no());
				
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
