package dao.admin.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.NoticeBoard;
import dto.Report;
import util.DBConn;
import util.Paging;

public class ReportDaoImpl implements ReportDao {

	// DB연결 객체
	private Connection conn = DBConn.getConnection();

	@Override
	public List selectAll() {

		// 전체 조회 쿼리
		String sql = "";
		sql += "select * from report r, board b, users u";
		sql += " where r.b_no = b.b_no";
		sql += " and   b.u_no = u.u_no";
		sql += " order by r.rp_no";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List list = new ArrayList<>();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 전체조회 결과 담기
			while (rs.next()) {
				Report r = new Report();

				// ResultSet의 결과 행 하나씩 DTO에 저장
				r.setRp_no(rs.getInt("rp_no"));
				r.setB_no(rs.getInt("b_no"));
				r.setU_no(rs.getInt("u_no"));
				r.setRp_date(rs.getDate("rp_date"));
				r.setRp_status(rs.getString("rp_status"));
				r.setRe_yesno(rs.getString("re_yesno"));
				r.setRe_date(rs.getDate("re_date"));

				r.setU_name(rs.getString("u_name")); // 작성자
				r.setB_title(rs.getString("b_title")); //

				// 조회결과를 List로 생성
				list.add(r);
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

	@Override
	public Report selectReportByReportno(Report reportview) {

		// 전체 조회 쿼리
		String sql = "";
		sql += "select * from report r, board b, users u";
		sql += " where r.b_no = b.b_no";
		sql += " and   b.u_no = u.u_no";
		sql += " AND rp_no= ?";
		sql += " order by r.rp_no";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 조회 결과 담을 DTO
		Report r = new Report();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reportview.getRp_no());
			rs = ps.executeQuery();

			// 결과 담기
			while (rs.next()) {

				// ResultSet의 결과 행 하나씩 DTO에 저장
				r.setRp_no(rs.getInt("rp_no"));
				r.setB_no(rs.getInt("b_no"));
				r.setU_no(rs.getInt("u_no"));
				r.setRp_date(rs.getDate("rp_date"));
				r.setRp_status(rs.getString("rp_status"));
				r.setRe_yesno(rs.getString("re_yesno"));
				r.setRe_date(rs.getDate("re_date"));

				r.setU_name(rs.getString("u_name")); // 작성자
				r.setB_title(rs.getString("b_title")); //
//			
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
		return r;
	}

	@Override
	public int selectCntReport() {

		// 전체 조회 쿼리
		String sql = "";

		sql += "select COUNT(*) from report r, board b, users u";
		sql += " where r.b_no = b.b_no";
		sql += " and   b.u_no = u.u_no";
		sql += " order by r.rp_no";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 변수
		int cnt = 0;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

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

		// 전체 게시글 수 반환
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {

		//전체 조회 쿼리
	
		
	      String sql = "";
	     sql += "SELECT * FROM (";
	     sql += " SELECT rownum rnum, B.* , u.u_name, d.b_title FROM (";
	     sql += " SELECT * FROM report";
         sql += " ORDER BY rp_no desc";
         sql += " ) B"  ;    
	     sql +=	" INNER JOIN board d ";
	     sql +=	" ON B.b_no = d.b_no ";  
	     sql +=	" INNER JOIN users u ";
	     sql +=  "  ON d.u_no = u.u_no "    ;
	     sql +=	"  ORDER BY rnum desc ";
	     sql +=	 " ) R";
         sql +=	"  WHERE rnum BETWEEN ? AND ?";
		
		
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
	            Report r = new Report();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				r.setRp_no( rs.getInt("rp_no") );
				r.setB_no( rs.getInt("b_no") );
				r.setU_no( rs.getInt("u_no") );
				r.setRp_date( rs.getDate("rp_date") );
				r.setRp_status( rs.getString("rp_status") );
				r.setRe_yesno( rs.getString("re_yesno") );				
				r.setRe_date( rs.getDate("re_date") );				
				r.setU_name(rs.getString("u_name"));      // 작성자
				r.setB_title(rs.getString("b_title"));    //
				//조회결과를 List로 생성
				list.add(r);				
				
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
	public int deleteReportByReportno(Report reportdel) {
		// 전체 조회 쿼리			

		String sql = " ";
		sql += "UPDATE report";
		sql += " SET re_yesno = 'y' ";
		sql += " WHERE rp_no = ?";

		int result = 0;
		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// AutoCommit 끄기
			conn.setAutoCommit(false);

			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reportdel.getRp_no());

			result = ps.executeUpdate();

			// 정상적으로 진행될 경우 commit
			conn.commit();

		} catch (SQLException e) {
			try {
				// 예외발생 시 rollback
				conn.rollback();

			} catch (SQLException e1) {
				e.printStackTrace();
			}

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
		return result;

	}
	
	@Override
	public List<Report> search(String type, String word) {

		// 전체 조회 쿼리
		String sql = "";
		sql += "select * from report r";
         sql +=	" INNER JOIN board d ";
	     sql +=	" ON r.b_no = d.b_no ";  
	     sql +=	" INNER JOIN users u ";
	     sql +=  "  ON u.u_no = r.u_no "    ;
	
		if (type.equals("title")) {
			sql += " WHERE d.b_TITLE like ?";
		} else if (type.equals("writer")) {
			sql += " WHERE u.u_name like ?";
		} else if (type.equals("content")) {
			sql += " WHERE d.b_CONTENT like ?";
		}else if (type.equals("reporter")) {
			sql += " WHERE u.u_name like ?";
		}else if (type.equals("status")) {
			sql += " WHERE r.re_yesno like ?";
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
				Report r = new Report();

				// ResultSet의 결과 행 하나씩 DTO에 저장
				r.setRp_no(rs.getInt("rp_no"));
				r.setB_no(rs.getInt("b_no"));
				r.setU_no(rs.getInt("u_no"));
				r.setRp_date(rs.getDate("rp_date"));
				r.setRp_status(rs.getString("rp_status"));
				r.setRe_yesno(rs.getString("re_yesno"));
				r.setRe_date(rs.getDate("re_date"));

				r.setU_name(rs.getString("u_name")); // 작성자
				r.setB_title(rs.getString("b_title")); //
				// 조회결과를 List로 생성
				list.add(r);
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

	@Override
	public void updateStatus(Report reportup) {
		// 전체 조회 쿼리			

		String sql = " ";
		sql += "UPDATE report";
		sql += " SET rp_status = '처리완료' ";
		sql += " WHERE rp_no = ?";

		int result = 0;
		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// AutoCommit 끄기
			conn.setAutoCommit(false);

			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reportup.getRp_no());

			rs = ps.executeQuery();
			// 정상적으로 진행될 경우 commit
			conn.commit();

		} catch (SQLException e) {
			try {
				// 예외발생 시 rollback
				conn.rollback();

			} catch (SQLException e1) {
				e.printStackTrace();
			}

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
	

	}

}
