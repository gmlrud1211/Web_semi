package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Study;
import dto.StudyCate;
import util.DBConn;

public class SearchStudyImpl implements SearchStudy {

	private Connection conn = DBConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 전체 조회
	@Override
	public List selectAll() {
		String sql = "";
		sql += "SELECT * FROM study";
		sql += " order by study_opendate";

		List list = new ArrayList();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				Study studys = new Study();
				studys.setStudy_name(rs.getString("study_name"));
				studys.setStudy_region(rs.getString("study_region"));
				studys.setStudy_time(rs.getString("study_time"));
				studys.setStudy_freq(rs.getString("study_freq"));
				studys.setStudy_gender(rs.getString("study_gender"));
				studys.setStudy_opendate(rs.getDate("study_opendate"));

				list.add(studys);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// 조건검색 쿼리
	@Override
	public List selectDetail(Study study) {
		String sql = "";
		sql += "select std.*,us.u_name, sc.st_category_code, sc.st_cate from study std";
		sql += " inner join users us";
		sql += " on std.u_no = us.u_no";
		sql += " inner join studycate sc";
		sql += " on std.st_code = sc.st_code";
		sql += " where std.st_code=? and std.study_gender=? and std.study_time=? and std.study_region=?";

//		System.out.println("study" + study.getStudy_gender());
//		System.out.println("zzz : " + study);
//		System.out.println(study.getSt_code());
		List<Study> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			System.out.println("실행되기전 gender확인 : " + study.getStudy_gender());
			ps.setInt(1, study.getSt_code());
			ps.setString(2, study.getStudy_gender());
			ps.setString(3, study.getStudy_time());
			ps.setString(4, study.getStudy_region());

			rs = ps.executeQuery();

			while (rs.next()) {
				Study studys = new Study();
				// DB에서 가져와서 화면에 띄워줄 컬럼들 작성
				studys.setU_name(rs.getString("u_name"));
				studys.setStudy_no(rs.getInt("study_no"));
				studys.setSt_code(rs.getInt("st_code"));
				studys.setStudy_details(rs.getString("study_details"));
				studys.setStudy_name(rs.getString("study_name"));
				studys.setStudy_region(rs.getString("study_region"));
				studys.setStudy_time(rs.getString("study_time"));
				studys.setStudy_freq(rs.getString("study_freq"));
				studys.setStudy_opendate(rs.getDate("study_opendate"));
				studys.setStudy_period(rs.getDate("study_period"));
				studys.setStudy_gender(rs.getString("study_gender"));
				studys.setSt_category_code(rs.getString("st_category_code"));
				studys.setStudy_cate(rs.getString("st_cate"));

				list.add(studys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("selectDetail : " + list);
		return list;

	}

	// study_no 넘겨줄때 (detail.jsp)
	@Override
	public Study selectStudy(int study_no) {

		String sql = "";
		sql += "select std.*,us.u_name from study std";
		sql += " inner join users us";
		sql += " on std.u_no = us.u_no";
		sql += " where study_no=?";

		// study객체
		Study studys = new Study();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, study_no);

			rs = ps.executeQuery();

			while (rs.next()) {
				studys.setStudy_no(rs.getInt("study_no"));
				studys.setSt_code(rs.getInt("st_code"));
				studys.setStudy_name(rs.getString("study_name"));
				studys.setU_name(rs.getString("u_name"));
				studys.setStudy_region(rs.getString("study_region"));
				studys.setStudy_time(rs.getString("study_time"));
				studys.setStudy_freq(rs.getString("study_freq"));
				studys.setStudy_details(rs.getString("study_details"));
				studys.setStudy_gender(rs.getString("study_gender"));
				studys.setStudy_opendate(rs.getDate("study_opendate"));

			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
		}
		return studys;
	}

	@Override
	public List selectCate(int cate_no, String str) {
		String sql = "";
		sql += "SELECT * FROM StudyCate";
		sql += " WHERE st_cate LIKE ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<StudyCate> slist = new ArrayList();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				StudyCate s = new StudyCate();

				s.setSt_code(rs.getInt("st_code"));
				s.setSt_cate(rs.getString("st_cate"));
				s.setSt_subcate(rs.getString("st_subcate"));

				slist.add(s);
			}

		} catch (SQLException e) {
		}
		return slist;
	}

}
