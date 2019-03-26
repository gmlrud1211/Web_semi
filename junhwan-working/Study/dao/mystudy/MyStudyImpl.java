package dao.mypage.mystudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bookmark;
import dto.StudyTeamState;
import util.DBConn;

public class MyStudyImpl implements MyStudy {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 개인별 스터디 신청 상태 (appliedStudyList.jsp에뿌려질 내용들 조회)
	@Override
	public List selectMyStudyInfo(int u_no) {

		String sql = "";
		sql += "SELECT * FROM StudyTeamState sts, StudyState ss, ApplyState as1, Users u, Study s";
		sql += " WHERE sts.u_no = u.u_no";
		sql += " AND sts.study_no = s.study_no";
		sql += " AND sts.ss_stateCode = ss.ss_stateCode";
		sql += " AND sts.ts_stateCode = as1.ts_stateCode";
		sql += " AND sts.u_no = ?";
		

		// StudyTeamState정보 담을 객체 선언(list)
		List<StudyTeamState> stList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			
			// db작업
			rs = ps.executeQuery();
			while (rs.next()) {
				StudyTeamState sts = new StudyTeamState();

				sts.setU_no(rs.getInt("u_no"));
				sts.setStudy_no(rs.getInt("study_no"));
				sts.setSs_statecode(rs.getInt("ss_statecode"));
				sts.setTs_statecode((rs.getInt("ts_statecode")));
				sts.setSs_statename(rs.getString("ss_statename"));
				sts.setTs_statename(rs.getString("ts_statename"));
				sts.setU_name(rs.getString("u_name"));
				sts.setStudy_name(rs.getString("study_name"));
				sts.setSs_yesno(rs.getString("ss_yesno"));
				sts.setSs_applydate(rs.getDate("ss_applydate"));
				sts.setSs_decisiondate(rs.getDate("ss_decisiondate"));
				sts.setStudy_region(rs.getString("study_region"));
				sts.setStudy_details(rs.getString("study_details"));
				sts.setStudy_freq(rs.getString("study_freq"));
				sts.setStudy_opendate(rs.getDate("study_opendate"));
				stList.add(sts);
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
			}
		}

		return stList;
	}

	
	//study신청하기(db삽입)
	@Override
	public void insertMyStudy(StudyTeamState mystudy) {
		String sql = "";
		sql += "INSERT INTO studyteamstate (u_no, study_no, ss_statecode, ts_statecode, ss_applydate,ss_yesno)";
		sql += " VALUES(?,?,2,1,sysdate,'N')";

		try {
			conn.setAutoCommit(false);

			// db작업
			ps = conn.prepareStatement(sql);

			ps.setInt(1, mystudy.getU_no());
			ps.setInt(2, mystudy.getStudy_no());
			
			
			ps.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
		}

	}

	//study신청(db삭제)
	@Override
	public void deleteMyStudy(StudyTeamState mystudy) {
		String sql = "";
		sql += "DELETE FROM studyteamstate";
		sql += " WHERE u_no = ?";
		sql += " AND study_no = ?";

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mystudy.getU_no());
			ps.setInt(2, mystudy.getStudy_no());

			ps.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

	}
	
	

}
