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

	// DB���� ��ü
	private Connection conn = DBConn.getConnection();

	@Override
	public List<Faq> selectAll() {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM faq";
		sql += " ORDER BY faq_no ";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� List
		List<Faq> list = new ArrayList<>();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// ��ü��ȸ ��� ���
			while (rs.next()) {
				Faq f = new Faq();

				// ResultSet�� ��� �� �ϳ��� DTO�� ����

				f.setFaq_no(rs.getInt("faq_no"));
				f.setFaq_cate(rs.getString("faq_cate"));
				f.setFaq_qusetion(rs.getString("faq_qusetion"));
				f.setFaq_answer(rs.getString("faq_answer"));
				f.setFaq_date(rs.getDate("faq_date"));

				// ��ȸ����� List�� ����
				list.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü��ȸ ��� ��ȯ
		return list;
	}

	@Override
	public Faq selectFaqByFaqno(Faq faqview) {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM faq";
		sql += " WHERE faq_no= ?";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ��ȸ ��� ���� DTO
		Faq f = new Faq();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, faqview.getFaq_no());
			rs = ps.executeQuery();

			// ��� ���
			while (rs.next()) {

				// ResultSet�� ��� �� �ϳ��� DTO�� ����

				// ResultSet�� ��� �� �ϳ��� DTO�� ����
				f.setFaq_no(rs.getInt("faq_no"));
				f.setFaq_cate(rs.getString("faq_cate"));
				f.setFaq_qusetion(rs.getString("faq_qusetion"));
				f.setFaq_answer(rs.getString("faq_answer"));
				f.setFaq_date(rs.getDate("faq_date"));

				// ��ȸ����� List�� ����

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü��ȸ ��� ��ȯ
		return f;
	}

	@Override
	public int selectCntFaq() {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT COUNT(*) FROM faq";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� ����
		int cnt = 0;

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü �Խñ� �� ��ȯ
		return cnt;
	}

	@Override
	public int delectFaqByFaqno(Faq faqdel) {
		// ��ü ��ȸ ����
		int result = 0;

		String sql = "";
		sql += "DELETE FROM faq";
		sql += " WHERE faq_no= ?";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ��ȸ ��� ���� DTO

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, faqdel.getFaq_no());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü��ȸ ��� ��ȯ
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
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// ���� �Լ�
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
		//��ü ��ȸ ����
		
		        int result = 0;
		
				String sql = "";
				sql += "DELETE FROM faq";
				sql += " WHERE faq_no= ?";
				
				//DB ��ü
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				//��ȸ ��� ���� DTO
				Faq f = new Faq();
				
				try {
					//DB�۾�
					ps = conn.prepareStatement(sql);
					ps.setInt(1, faqdel.getFaq_no());
					result = ps.executeUpdate();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						//DB��ü �ݱ�
						if(rs!=null)	rs.close();
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return result;
				
	}

}
