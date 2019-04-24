package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Study;
import util.DBConn;

public class StudyCateDaoImpl implements StudyCateDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Study> getCateStudyList(int st_code) {

		String sql = "";
		
		sql += "SELECT S.study_no, S.st_code, S.study_name, S.file_no, S.study_region, S.u_no, S.study_opendate, F.file_storedname, C.st_cate, U.u_name";
		sql += " FROM study S";
		sql += " JOIN fileupload F";
		sql += " ON S.file_no=F.file_no";
		sql += " JOIN studycate C";
		sql += " ON S.st_code=C.st_code";		
		sql += " JOIN users U";
		sql += " ON S.u_no=U.u_no";		
		sql += " WHERE S.st_code=?";
		sql += " ORDER BY S.study_no";
		
		
		List<Study> sList = new ArrayList<>();
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, st_code);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				
				Study study = new Study();

				study.setStudy_no(rs.getInt("study_no"));
				study.setSt_code(rs.getInt("st_code"));
				study.setStudy_name(rs.getString("study_name"));
				study.setFile_no(rs.getInt("file_no"));
				study.setFile_storedname(rs.getString("file_storedname"));
				study.setStudy_region(rs.getString("study_region"));
				study.setSt_cate(rs.getString("st_cate"));
				study.setStudy_opendate(rs.getString("study_opendate"));
				study.setU_name(rs.getString("u_name"));
				
				sList.add(study);
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
		return sList;
	}

}
