package dao.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.file.FileUpload;
import util.DBConn;

public class FileDaoImpl implements FileDao{

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public int getFileno() {
		String sql = "";
		sql += "SELECT FILEUPLOAD_SEQ.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int fileno = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			fileno = rs.getInt(1);
			
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
		
		return fileno;
	}

	@Override
	public void insertFile(FileUpload file) {
		String sql = "";
		sql += "INSERT INTO fileupload ( file_no, file_originname, file_storedname, file_uploaddate, fut_code )";
		sql += " VALUES ( FILEUPLOAD_SEQ.nextval, ?, ?, sysdate, 5 )";
				
		//INSERT INTO fileUpload(file_no, file_originname, file_storedname, file_uploaddate, fut_code) 
		//VALUES(FILEUPLOAD_SEQ.nextval,'파일1','저장파일1',TO_DATE('20190201'),1);
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, file.getFile_originname());
			ps.setString(2, file.getFile_storedname());
			
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

}
