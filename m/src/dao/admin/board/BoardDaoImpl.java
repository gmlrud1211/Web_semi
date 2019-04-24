package dao.admin.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.BoardComment;
import util.DBConn;
import util.Paging;

public class BoardDaoImpl implements BoardDao {

	//DB연결 객체
	private Connection conn = DBConn.getConnection(); 

	@Override
	public List selectAll() {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT B.*, U.U_NAME FROM BOARD B";
		sql += " INNER JOIN USERS U";
		sql += " ON B.U_NO = U.U_NO";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 List
		List list = new ArrayList<>();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//전체조회 결과 담기
			while(rs.next()) {
				Board b = new Board();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				b.setB_no(rs.getInt("b_no"));
				b.setU_no(rs.getInt("u_no"));
				b.setU_name(rs.getString("u_name"));
				b.setB_head(rs.getString("b_head"));
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setFile_no(rs.getInt("File_no"));
				b.setB_date(rs.getDate("b_date"));
				b.setB_count(rs.getInt("b_upcount"));
				b.setB_count(rs.getInt("b_count"));
				//조회결과를 List로 생성
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return list;
	}



	@Override
	public Board selectBoardByBoardno(Board boardview) {

		//전체 조회 쿼리
		String sql = "";
	
		
		sql += "SELECT B.*, U.U_NAME FROM BOARD B";
		sql += " INNER JOIN USERS U";
		sql += " ON B.U_NO = U.U_NO";
		sql += " WHERE b_no= ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//조회 결과 담을 DTO
		Board b = new Board();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardview.getB_no());
			rs = ps.executeQuery();
			
			//결과 담기
			while(rs.next()) {		
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				b.setB_no( rs.getInt("b_no") );
				b.setU_no( rs.getInt("u_no") );
				b.setU_name(rs.getString("u_name"));
				b.setB_head( rs.getString("b_head") );
				b.setB_title( rs.getString("b_title") );
				b.setB_content( rs.getString("b_content") );
				b.setFile_no( rs.getInt("File_no") );
				b.setB_date( rs.getDate("b_date") );
				b.setB_count( rs.getInt("b_upcount") );				
				b.setB_count( rs.getInt("b_count") );				

			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return b;
	}

	@Override
	public int selectCntBoard() {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM board";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 변수
		int cnt = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체 게시글 수 반환
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += " SELECT bo.*, us.u_name FROM board bo, users us";
		sql += " WHERE bo.u_no = us.u_no";
		sql += "	ORDER BY b_no desc";
		sql += " ) B";
		sql += " ORDER BY rnum";
		sql += " ) R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
//		sql += "SELECT B.*, U.U_NAME FROM BOARD B";
//		sql += " INNER JOIN USERS U";
//		sql += " ON B.U_NO = U.U_NO";
//		
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 List
		List list = new ArrayList<>();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			//전체조회 결과 담기
			while(rs.next()) {
	            Board b = new Board();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				b.setB_no( rs.getInt("b_no") );
				b.setU_no( rs.getInt("u_no") );
				b.setU_name(rs.getString("u_name"));

				b.setB_head( rs.getString("b_head") );
				b.setB_title( rs.getString("b_title") );
				b.setB_content( rs.getString("b_content") );
				b.setFile_no( rs.getInt("File_no") );
				b.setB_date( rs.getDate("b_date") );
				b.setB_count( rs.getInt("b_upcount") );				
				b.setB_count( rs.getInt("b_count") );				

				//조회결과를 List로 생성
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return list;
	}
//
//	@Override
//	public List search(NoticeBoard boardSearch) {
//		
//		return null;
//	}
	@Override
	public void delectBoardCommentByBoardno(int b_no) {
		
				String sql = "";
				sql += "DELETE FROM boardcomment ";
				
				sql += " where b_no = ?";
			
				
				//DB 객체
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				int flag = 0;
				
				//반환값 변수 
				boolean result = false;
				
			
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, b_no);
				    rs = ps.executeQuery();
					
//					flag = ps.executeUpdate();
					conn.commit();
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						//DB객체 닫기
						if(rs!=null)	rs.close();
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(flag>0) {
					result = true;
				}
				
				// 전체조회 결과 반환
//				return result;
	}
	
	
	@Override
	public void delectBoardByBoardno(int b_no) {
		
				String sql = "";
				sql += "DELETE FROM board ";
				sql += " where b_no = ?";
			
				
				//DB 객체
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				int flag = 0;
				
				//반환값 변수 
				boolean result = false;
			 

			
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, b_no);
				    rs = ps.executeQuery();

					
//					flag = ps.executeUpdate();
					conn.commit();
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						//DB객체 닫기
						if(rs!=null)	rs.close();
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(flag>0) {
					result = true;
				}
				
				// 전체조회 결과 반환
	}
	

	@Override
	public List<Board> search(String type, String word) {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT B.*, U.U_NAME FROM BOARD B";
		sql += " INNER JOIN USERS U";
		sql += " ON B.U_NO = U.U_NO";

		if (type.equals("title")) {
			sql += " WHERE B.B_TITLE like ?";
		} else if (type.equals("writer")) {
			sql += " WHERE U.U_NAME like ?";
		} else if (type.equals("content")) {
			sql += " WHERE B.B_CONTENT like ?";
		}

		
		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List list = new ArrayList<>();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			rs = ps.executeQuery();
			
	
			// 전체조회 결과 담기
			while (rs.next()) {
				Board b = new Board();

				// ResultSet의 결과 행 하나씩 DTO에 저장
				b.setB_no(rs.getInt("b_no"));
				b.setU_no(rs.getInt("u_no"));
				b.setU_name(rs.getString("u_name"));
				b.setB_head(rs.getString("b_head"));
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setFile_no(rs.getInt("File_no"));
				b.setB_date(rs.getDate("b_date"));
				b.setB_count(rs.getInt("b_upcount"));
				b.setB_count(rs.getInt("b_count"));

				// 조회결과를 List로 생성
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

			// 전체조회 결과 반환
			return list;
		}
	
	
}















