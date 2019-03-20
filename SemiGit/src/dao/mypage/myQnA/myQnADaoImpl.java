package dao.mypage.myQnA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dto.FileUpload;
import dto.QnA;
import util.DBConn;
import util.Paging;

public class myQnADaoImpl implements myQnADao {
	
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public QnA selectQnAByOneno(int one_no) {
		String sql = "";
		sql +="SELECT O.u_no, O.one_no, O.one_title, O.one_content, O.one_status,";
		sql	+=" O.one_date, O.one_anscontent, O.one_ansdate, O.file_no, F.file_storedname";
		sql +=" FROM oneandboard O";
		sql +=" LEFT OUTER JOIN fileupload F";
		sql +=" ON O.file_no = F.file_no";
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
				qna.setFile_storedname(rs.getString("file_storedname"));

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
			sql +=" VALUES(?, oneandboard_SEQ.nextval, ?, ?, ?, sysdate, 'n')";	
			
			try {	
				ps = conn.prepareStatement(sql);
				ps.setInt(1, qna.getU_no());
				ps.setString(2, qna.getOne_title());
				ps.setString(3, qna.getOne_content());
				if(qna.getFile_no()!=-1) {
					ps.setInt(4, qna.getFile_no());
				} else {
					ps.setNull(4, Types.INTEGER);
				}
				
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

	@Override
	public int cntMyQnA(int u_no) {
		String sql = "";
		sql +="SELECT COUNT(*) FROM oneandboard";
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
	public List selectMyQnAPagingList(int u_no, Paging paging) {
		
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM(";
		sql += "		SELECT O.u_no, O.one_no, O.one_title, O.one_content, O.one_status,"; 
		sql	+= " 				O.one_date, O.one_anscontent, O.one_ansdate, O.file_no, F.file_storedname";
		sql	+= " 			FROM oneandboard O";
		sql += " 			LEFT OUTER JOIN fileupload F";
		sql += " 			ON O.file_no = F.file_no";
		sql += " 			WHERE O.u_no=?";
		sql += " 			ORDER BY O.one_no desc";
		sql += "		) B";
		sql += "	ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";		
		
		
		List<QnA> qnaList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
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
				qna.setFile_storedname(rs.getString("file_storedname"));
									
				qnaList.add(qna);
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
		
		return qnaList;

	}

	@Override
	public int getQnA_no() {
		String sql = "";
		sql += "SELECT oneandboard_SEQ.nextval FROM dual";
		
		int one_no = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			one_no = rs.getInt(1);
			
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
		
		return one_no;
	}

	@Override
	public void updateFile(FileUpload fileupload) {
		String sql = "";
		sql += "UPDATE fileUpload SET fut_code = 2";
		sql += " WHERE file_no = ?";

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, fileupload.getFile_no());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public FileUpload selectFileByFileno(int file_no) {
		String sql ="";
		sql += "select * from fileupload";
		sql += " where file_no = ?";
		
		FileUpload fu = new FileUpload();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, file_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				fu.setFile_no(rs.getInt("file_no"));
				fu.setFile_originname(rs.getString("file_originname"));
				fu.setFile_storedname(rs.getString("file_storedname"));
				fu.setFile_uploaddate(rs.getDate("file_uploaddate"));
				fu.setFut_code(rs.getInt("fut_code"));
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fu;
	}
}
