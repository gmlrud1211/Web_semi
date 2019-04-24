package dao.admin.faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Faq;
import dto.NoticeBoard;
import util.DBConn;
import util.Paging;

public class FaqDaoImpl implements FaqDao {

	// DB연결 객체
	private Connection conn = DBConn.getConnection();

	@Override
	public List<Faq> selectAll() {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM faq";
		sql += " ORDER BY faq_no ";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List<Faq> list = new ArrayList<>();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 전체조회 결과 담기
			while (rs.next()) {
				Faq f = new Faq();

				// ResultSet의 결과 행 하나씩 DTO에 저장

				f.setFaq_no(rs.getInt("faq_no"));
				f.setFaq_cate(rs.getString("faq_cate"));
				f.setFaq_qusetion(rs.getString("faq_qusetion"));
				f.setFaq_answer(rs.getString("faq_answer"));
				f.setFaq_date(rs.getDate("faq_date"));

				// 조회결과를 List로 생성
				list.add(f);
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
	public Faq selectFaqByFaqno(Faq faqview) {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM faq";
		sql += " WHERE faq_no= ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 조회 결과 담을 DTO
		Faq f = new Faq();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, faqview.getFaq_no());
			rs = ps.executeQuery();

			// 결과 담기
			while (rs.next()) {

				// ResultSet의 결과 행 하나씩 DTO에 저장

				// ResultSet의 결과 행 하나씩 DTO에 저장
				f.setFaq_no(rs.getInt("faq_no"));
				f.setFaq_cate(rs.getString("faq_cate"));
				f.setFaq_qusetion(rs.getString("faq_qusetion"));
				f.setFaq_answer(rs.getString("faq_answer"));
				f.setFaq_date(rs.getDate("faq_date"));

				// 조회결과를 List로 생성

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
		return f;
	}

	@Override
	public int selectCntFaq() {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM faq";

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
	public int delectFaqByFaqno(Faq faqdel) {
		// 전체 조회 쿼리
		int result = 0;

		String sql = "";
		sql += "DELETE FROM faq";
		sql += " WHERE faq_no= ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 조회 결과 담을 DTO

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, faqdel.getFaq_no());
			result = ps.executeUpdate();

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
		return result;
	}

	@Override
	public void faqInsert(Faq faqinsert) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " ";
		sql += "INSERT INTO faq";
		sql += " (faq_cate, faq_qusetion, faq_answer, faq_date, faq_no)";
		sql += " VALUES( ?, ?, ?, sysdate, faq_no_SEQ.NEXTVAL)";

		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, faqinsert.getFaq_cate());
			ps.setString(2, faqinsert.getFaq_qusetion());
			ps.setString(3, faqinsert.getFaq_answer());

			ps.executeUpdate();

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

	}

	// 수정 함수
	public void update(Faq faqup) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " ";
		sql += "update faq ";
		sql += " SET faq_cate = ?, faq_qusetion = ? , faq_answer= ?";
		sql += " WHERE faq_no = ?";
		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, faqup.getFaq_cate());

			ps.setString(2, faqup.getFaq_qusetion());

			ps.setString(3, faqup.getFaq_answer());

			ps.setInt(4, faqup.getFaq_no());



			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	@Override
	public int delectFaqByFaqdno(Faq faqdel) {
		//전체 조회 쿼리
		
		        int result = 0;
		
				String sql = "";
				sql += "DELETE FROM faq";
				sql += " WHERE faq_no= ?";
				
				//DB 객체
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				//조회 결과 담을 DTO
				Faq f = new Faq();
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, faqdel.getFaq_no());
					result = ps.executeUpdate();
					
					
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
				
				return result;
				
	}

}
