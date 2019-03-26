package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Study;
import dto.StudyCategory;
import util.DBConn;

public class StudyDaoImpl implements StudyDao {
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<StudyCategory> getCategory() {
		String sql = "";
		sql += "SELECT * FROM STUDYCATEGORY";

		List<StudyCategory> cateList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				StudyCategory cate = new StudyCategory();

				cate.setSt_catecode(rs.getInt("st_catecode"));
				cate.setSt_catename(rs.getString("st_catename"));

				cateList.add(cate);
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
		return cateList;
	}
	
	@Override
	public List<Study> getStudyList() {

		String sql = "";
	
		sql += "SELECT * FROM STUDY STD ";
		sql += "INNER JOIN STUDYCATE CATE ";
		sql += "ON STD.st_code = CATE.st_code ";
		sql += "INNER JOIN FILEUPLOAD UPLOAD ";
		sql += "ON UPLOAD.FILE_NO = STD.FILE_NO ";
		sql += "ORDER BY (SYSDATE - STUDY_OPENDATE) DESC ";
		
		List<Study> studyList = new ArrayList<>();
	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				
				Study study = new Study();
	
				study.setStudy_no(rs.getInt("study_no"));
				study.setFile_storedname(rs.getString("file_storedname"));
				study.setFile_no(rs.getInt("file_no"));
				study.setStudy_region(rs.getString("study_region"));
				study.setStudy_name(rs.getString("study_name"));
				study.setSt_cate(rs.getString("st_cate"));
				study.setSt_subcate(rs.getString("st_subcate"));
				study.setStudy_name(rs.getString("study_name"));
				study.setStudy_time(rs.getString("study_time"));
				study.setStudy_freq(rs.getString("study_freq"));
				study.setStudy_opendate(rs.getDate("study_opendate"));
				study.setStudy_min(rs.getInt("study_min"));
				study.setStudy_max(rs.getInt("study_max"));
				study.setStudy_gender(rs.getString("study_gender"));
				study.setSt_catecode(rs.getInt("st_category_code"));

				studyList.add(study);
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
		return studyList;
	}
	
	@Override
	public List<Study> getMyStudy(int u_no) {

		String sql = "";

		sql += "SELECT * FROM USERFAVORITCATE FAV ";
		sql += "INNER JOIN STUDYCATE CATE ";
		sql += "ON FAV.st_code = CATE.st_category_code ";
		sql += "INNER JOIN STUDY STD ";
		sql += "ON STD.st_code = CATE.st_code ";
		sql += "INNER JOIN FILEUPLOAD UPLOAD ";
		sql += "ON UPLOAD.FILE_NO = STD.FILE_NO ";
		sql += "WHERE FAV.u_no = ? AND (STUDY_OPENDATE - SYSDATE) > 0";	

		List<Study> myCateList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_no);
			rs = ps.executeQuery();

			while (rs.next()) {

				Study study = new Study();

				study.setStudy_no(rs.getInt("study_no"));
				study.setFile_storedname(rs.getString("file_storedname"));
				study.setFile_no(rs.getInt("file_no"));
				study.setStudy_region(rs.getString("study_region"));
				study.setStudy_name(rs.getString("study_name"));
				study.setSt_cate(rs.getString("st_cate"));
				study.setSt_subcate(rs.getString("st_subcate"));
				study.setStudy_name(rs.getString("study_name"));
				study.setStudy_time(rs.getString("study_time"));
				study.setStudy_freq(rs.getString("study_freq"));
				study.setStudy_opendate(rs.getDate("study_opendate"));
				study.setStudy_min(rs.getInt("study_min"));
				study.setStudy_max(rs.getInt("study_max"));
				study.setStudy_gender(rs.getString("study_gender"));

				
				myCateList.add(study);
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
		return myCateList;
	}

	@Override
	public List<Study> getHurryStudy() {
		
		String sql = "";
	
		sql += "SELECT * FROM STUDY STD ";
		sql += "INNER JOIN STUDYCATE CATE ";
		sql += "ON STD.st_code = CATE.st_code ";
		sql += "INNER JOIN FILEUPLOAD UPLOAD ";
		sql += "ON UPLOAD.FILE_NO = STD.FILE_NO ";
		sql += "WHERE (STUDY_OPENDATE - SYSDATE) > 0 ";
		sql += "ORDER BY (SYSDATE - STUDY_OPENDATE) DESC ";
		
		List<Study> hurryStudy = new ArrayList<>();
	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				
				Study study = new Study();
	
				study.setStudy_no(rs.getInt("study_no"));
				study.setFile_storedname(rs.getString("file_storedname"));
				study.setFile_no(rs.getInt("file_no"));
				study.setStudy_region(rs.getString("study_region"));
				study.setStudy_name(rs.getString("study_name"));
				study.setSt_cate(rs.getString("st_cate"));
				study.setSt_subcate(rs.getString("st_subcate"));
				study.setStudy_name(rs.getString("study_name"));
				study.setStudy_time(rs.getString("study_time"));
				study.setStudy_freq(rs.getString("study_freq"));
				study.setStudy_opendate(rs.getDate("study_opendate"));
				study.setStudy_min(rs.getInt("study_min"));
				study.setStudy_max(rs.getInt("study_max"));
				study.setStudy_gender(rs.getString("study_gender"));
				
				hurryStudy.add(study);
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
		return hurryStudy;
	}

	@Override
	public List<Study> getCateStudyList(int category_code) {
	
		String sql = "";
		
		sql += "SELECT * FROM ( ";
		sql += "SELECT * FROM STUDY STD ";
		sql += "INNER JOIN STUDYCATE CATE ";
		sql += "ON STD.st_code = CATE.st_code ";
		sql += "INNER JOIN FILEUPLOAD UPLOAD ";
		sql += "ON UPLOAD.FILE_NO = STD.FILE_NO ";
		sql += "WHERE CATE.st_category_code = ? ";
		sql += "ORDER BY STD.STUDY_NO DESC ) ";
		sql += "WHERE ROWNUM < 10";
		
		List<Study> StudyList_cate = new ArrayList<>();
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_code);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				
				Study study = new Study();

				study.setStudy_no(rs.getInt("study_no"));
				study.setFile_storedname(rs.getString("file_storedname"));
				study.setFile_no(rs.getInt("file_no"));
				study.setStudy_region(rs.getString("study_region"));
				study.setStudy_name(rs.getString("study_name"));
				study.setSt_cate(rs.getString("st_cate"));
				study.setSt_subcate(rs.getString("st_subcate"));
				study.setStudy_name(rs.getString("study_name"));
				study.setStudy_time(rs.getString("study_time"));
				study.setStudy_freq(rs.getString("study_freq"));
				study.setStudy_opendate(rs.getDate("study_opendate"));
				study.setStudy_min(rs.getInt("study_min"));
				study.setStudy_max(rs.getInt("study_max"));
				study.setStudy_gender(rs.getString("study_gender"));
				study.setSt_catecode(rs.getInt("st_category_code"));

				StudyList_cate.add(study);
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
		return StudyList_cate;
	}
}
