package dao.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbutil.DBConn;
import dto.study.Study;

public class StudyDaoImpl implements StudyDao {

private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public void studyopen(Study study) {
		String sql ="";
		sql +="insert into study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO)";
		sql +="values(Study_seq.nextval, ?,?,?,?,)";
	/*
		INSERT INTO Study(STUDY_NO, ST_CODE, STUDY_NAME, FILE_NO, STUDY_REGION, STUDY_TIME, STUDY_FREQ, STUDY_MIN, STUDY_MAX, STUDY_GENDER, STUDY_DETAILS, STUDY_OPENDATE, STUDY_PERIOD, STUDY_ADDRECRUIT, U_NO) 
		VALUES (Study_seq.nextval,205,'네이버 웹툰 작가 도전',11,'일산','주중 오후','주 3회',4,10,'무관','상세내용7',TO_DATE('20190413'),TO_DATE('20190629'),NULL,2);
	*/
	}

}
