
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
import dto.FileUpload;


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
				study.setStudy_opendate(rs.getString("study_opendate"));
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
				study.setStudy_opendate(rs.getString("study_opendate"));
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
				study.setStudy_opendate(rs.getString("study_opendate"));
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
				study.setStudy_opendate(rs.getString("study_opendate"));
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
		System.out.println(StudyList_cate);
		return StudyList_cate;
	}
  
  //�씗寃� start ---------------------

	@Override
	public void studyopen(Study study,int study_no) {
		String sql ="";
		sql +="insert into study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO)";
		sql +=" values(?, ?,?, ?,?,?,?,?,?,?,?,?,?,null, ?)";
	/*
		INSERT INTO Study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO) 
		VALUES (Study_seq.nextval,205,'�꽕�씠踰� �쎒�댆 �옉媛� �룄�쟾',11,'�씪�궛','二쇱쨷 �삤�썑','二� 3�쉶',4,10,'臾닿�','�긽�꽭�궡�슜7',TO_DATE('20190413'),TO_DATE('20190629'),NULL,2);
	*/
		
		try {
			
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, study_no);
			ps.setInt(2, study.getSt_code());
			ps.setString(3, study.getStudy_name());
			ps.setInt(4, study.getFile_no());
			ps.setString(5, study.getStudy_region());
			ps.setString(6, study.getStudy_time());
			ps.setString(7, study.getStudy_freq());
			ps.setInt(8,study.getStudy_min());
			ps.setInt(9, study.getStudy_max());
			ps.setString(10, study.getStudy_gender());
			ps.setString(11,study.getStudy_details());
			ps.setString(12, study.getStudy_opendate());
			ps.setString(13, study.getStudy_period());
			ps.setInt(14, study.getU_no()); 

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public int getStudy_no() {
		String sql = "";
		sql += "SELECT STUDY_SEQ.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int study_no = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			study_no = rs.getInt(1);
			
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
		
		return study_no;
	
	}


	@Override
	public void updateFile(FileUpload fileupload) {
		String sql = "";
		sql += "UPDATE fileUpload SET fut_code = 5";
		sql += " WHERE file_no = ?";

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, fileupload.getFile_no());
			System.out.println(fileupload.getFile_no());
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
	public void insertTeamState(Study study, int study_no) {
		String sql="";
		sql+= "insert into studyteamstate (u_no, study_no, ss_statecode, ts_statecode, ss_applydate, ss_decisiondate, ss_yesno )";
		sql+= " values(?,?,2,null, null,null, 'Y') ";

		try {
			
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, study.getU_no());
			ps.setInt(2, study_no);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- �옄�썝 �빐�젣 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//�씗寃� end---------------------------------
}

