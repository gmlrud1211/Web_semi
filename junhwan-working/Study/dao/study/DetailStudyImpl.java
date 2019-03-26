package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConn;

public class DetailStudyImpl implements DetailStudy {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 찜하기 중복검사
	@Override
	public boolean checkDupl(int study_no, int u_no) {
		String sql = "";
		sql += "SELECT COUNT(*) FROM bookmark";
		sql += " WHERE study_no=? and u_no=?";

		// 숫자 담을 변수
		int cnt = 0;
		boolean isChecked = false;// 찜 되있는지 여부 판단

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, study_no);
			ps.setInt(2, u_no);

			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {

		}
		if (cnt > 0) {
			isChecked = false;
			return isChecked;
		} else {
			isChecked = true;
			return isChecked;
		}

	}
	//신청하기 중복검사(detail에서 버튼 누르기용)
	@Override
	public boolean StudyAppDupl(int u_no, int study_no) {
		String sql = "";
		sql += "SELECT COUNT(*) FROM studyteamstate";
		sql += " WHERE u_no=? AND study_no=?";
		// cnt변수
		int cnt = 0;
		boolean isApply = false;// 신청 되었는지 여부 판단

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			ps.setInt(2, study_no);

			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			System.out.println("count"+cnt);
			System.out.println(u_no);
			System.out.println(study_no);
		} catch (SQLException e) {
			
		}

		if (cnt > 0) {
			isApply = false;
			return isApply;
		} else {
			isApply = true;
			return isApply;
		}
	}
}
