package dao.mypage.mystudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Study;
import dto.StudyTeamState;
import util.DBConn;

public class MyStudyImpl implements MyStudy {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 媛쒖씤蹂� �뒪�꽣�뵒 �떊泥� �긽�깭 (appliedStudyList.jsp�뿉肉뚮젮吏� �궡�슜�뱾 議고쉶)
	@Override
	public List<StudyTeamState> selectMyStudyInfo(int u_no) {

		String sql = "";
		sql+="SELECT * FROM studyteamstate sts";
		sql+=" inner join Users u";
		sql+=" on sts.u_no = u.u_no";
		sql+=" inner join Study s";
		sql+=" on s.study_no = sts.study_no";
		sql+=" inner join applystate ap";
		sql+=" on ap.ts_statecode = sts.ts_statecode";
		sql+=" inner join studystate st";
		sql+=" on st.ss_statecode = sts.ss_statecode";
		sql+=" inner join fileupload upload";
		sql+=" on s.file_no = upload.file_no";
		sql+=" WHERE u.u_no=? and sts.ss_statecode = 2";
		
		
		// StudyTeamState�젙蹂� �떞�쓣 媛앹껜 �꽑�뼵(list)
		List<StudyTeamState> stList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
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
				sts.setSs_applydate(rs.getString("ss_applydate"));
				sts.setSs_decisiondate(rs.getString("ss_decisiondate"));
				sts.setStudy_region(rs.getString("study_region"));
				sts.setStudy_details(rs.getString("study_details"));
				sts.setStudy_freq(rs.getString("study_freq"));
				sts.setStudy_opendate(rs.getDate("study_opendate"));
				sts.setFile_storedname(rs.getString("file_storedname"));
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

		System.out.println(stList);
		return stList;
	}

	
	//study�떊泥��븯湲�(db�궫�엯)
	@Override
	public void insertMyStudy(StudyTeamState mystudy) {
		String sql = "";
		sql += "INSERT INTO studyteamstate (u_no, study_no, ss_statecode, ts_statecode, ss_applydate,ss_yesno)";
		sql += " VALUES(?,?,2,1,sysdate,'N')";

		try {
			conn.setAutoCommit(false);

			// db�옉�뾽
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

	//study�떊泥�(db�궘�젣)
	@Override
	public void deleteMyStudy(int study_no,int u_no) {
		String sql = "";
		sql += "DELETE FROM studyteamstate";
		sql += " WHERE study_no = ? AND u_no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,study_no);
			ps.setInt(2, u_no);

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

	// 내가 만든 스터디의 신청자 리스트 조회
	//�떊泥��옄 由ъ뒪�듃 (appliedStudyList.jsp)
	@Override
	public List<StudyTeamState> getListStudymember(int u_no, int study_no) {
		String sql = "";
		sql+="select * from users u, studyteamstate sts";
		sql+=" where u.u_no = sts.u_no";
		sql+=" and sts.study_no = ?  and sts.ss_yesno != 'Y'";
		
		List<StudyTeamState> uList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, study_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				StudyTeamState u = new StudyTeamState();
				u.setU_no(rs.getInt("u_no"));
				u.setStudy_no(rs.getInt("study_no"));
				u.setU_name(rs.getString("u_name"));
				u.setU_phone(rs.getString("u_phone"));
				u.setU_birth(rs.getString("u_birth"));
				u.setTs_statecode(rs.getInt("ts_statecode"));
				
				uList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return uList;
	}

	// 내가만든 스터디
	//�궡媛� ���옣�씤 �뒪�꽣�뵒(紐⑥쭛以묒씤 寃껊쭔)
	@Override
	public List<StudyTeamState> selectMyStudybyUserNo(int u_no) {
		
		String sql="";
		sql+="select * From studyteamstate team";
		sql+=" inner join study std";
		sql+=" on team.study_no = std.study_no";
		sql+=" inner join STUDYSTATE ss";
		sql+=" on team.ss_statecode = ss.ss_statecode";
		sql+=" inner join fileupload upload";
		sql+=" on std.file_no = upload.file_no";
		sql+=" where team.u_no = ? and team.ss_yesno = 'Y' and team.ss_statecode = 2 ";
		
		List<StudyTeamState> myStudyList = new ArrayList();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, u_no );
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				StudyTeamState study = new StudyTeamState();
				
				study.setStudy_name(rs.getString("study_name"));
				study.setStudy_region(rs.getString("study_region"));
				study.setStudy_details(rs.getString("study_details"));
				study.setStudy_freq(rs.getString("study_freq"));
				study.setStudy_opendate(rs.getDate("study_opendate"));
				study.setStudy_no(rs.getInt("study_no"));
				study.setSs_statename(rs.getString("ss_statename"));
				study.setFile_storedname(rs.getString("file_storedname"));
				
				myStudyList.add(study);
			}
			
		} catch (SQLException e) {
		}
		
		return myStudyList;
	}


	// 내가 팀장인 스터디 신청자 -> 멤버로 수락
	@Override
	public void memberAccept(int u_no, int study_no) {
		
		String sql = "";
		sql += "update studyteamstate set ts_statecode = 2 , ss_applydate= sysdate";
		sql += " where study_no = ? and u_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,study_no);
			ps.setInt(2, u_no);
	
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


	@Override
	public void memberDecline(int u_no, int study_no) {
		String sql = "";
		sql += "update studyteamstate set ts_statecode = 3 , ss_applydate= sysdate";
		sql += " where study_no = ? and u_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,study_no);
			ps.setInt(2, u_no);
	
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


	@Override
	public void recruitEnd(int study_no) {
		
		System.out.println("recruitEnd : "  + study_no);
		String sql = "";
		sql += "update studyteamstate set ss_statecode = 3 ";
		sql += " where study_no = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,study_no);
	
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

	// 나의 스터디룸에 노출될 진행중인 스터디 조회
	@Override
	public List<Study> progressStudy(int u_no) {
		
		String sql = "";
		
//		sql += "select team.*, F.file_no From studyteamstate team";
//		sql += " inner join study std";
//		sql += " on team.study_no = std.study_no";
//		sql += " inner join fileupload upload";
//		sql += " on std.file_no = upload.file_no";
//		sql += " inner join studycate cate";
//		sql += " on std.st_code = cate.st_code";
//		sql += " join fileupload F";
//		sql += " on std.file_no=F.file_no";
//		sql += " where team.ss_statecode = 3 and team.u_no= ? ";
		
		
		sql += "select * From studyteamstate team";
		sql += " inner join study std";
		sql += " on team.study_no = std.study_no";
		sql += " inner join fileupload upload";
		sql += " on std.file_no = upload.file_no";
		sql += " inner join studycate cate";
		sql += " on std.st_code = cate.st_code";
		sql += " where team.ss_statecode = 3 and team.u_no= ? ";

		List<Study> progressList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Study u = new Study();

				u.setSt_cate(rs.getString("st_cate"));
				u.setSt_subcate(rs.getString("st_subcate"));
				u.setFile_storedname(rs.getString("file_storedname"));
				u.setStudy_name(rs.getString("study_name"));
				u.setStudy_no(rs.getInt("study_no"));
				
				progressList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return progressList;
	}
}
