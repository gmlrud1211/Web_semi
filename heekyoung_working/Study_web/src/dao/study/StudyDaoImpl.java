package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Study;
import util.DBConn;

public class StudyDaoImpl implements StudyDao {

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public void studyopen(Study study) {
		String sql ="";
		sql +="insert into study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO)";
		sql +="values(Study_seq.nextval, ?,?,null ,?,?,?,?,?,?,?,?,?,null,1)";
	/*
		INSERT INTO Study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO) 
		VALUES (Study_seq.nextval,205,'네이버 웹툰 작가 도전',11,'일산','주중 오후','주 3회',4,10,'무관','상세내용7',TO_DATE('20190413'),TO_DATE('20190629'),NULL,2);
	*/
		
		try {
			
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, study.getSt_code());
			ps.setString(2, study.getStudy_name());
			//ps.setInt(3, study.getFile_no());
			ps.setString(3,study.getStudy_region());
			ps.setString(4, study.getStudy_time());
			ps.setString(5, study.getStudy_freq());
			ps.setInt(6,study.getStudy_min());
			ps.setInt(7, study.getStudy_max());
			ps.setString(8, study.getStudy_gender());
			ps.setString(9,study.getStudy_details());
			ps.setString(10, study.getStudy_opendate());
			ps.setString(11, study.getStudy_period());
			//ps.setInt(12, study.getU_no()); //user와 연동안되있어서 일단 임의로 u_no는 1로 지정
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


}
