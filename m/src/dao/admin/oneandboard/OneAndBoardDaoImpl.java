package dao.admin.oneandboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.FileUpload;
import dto.NoticeBoard;
import dto.OneAndBoard;
import dto.Users;
import util.DBConn;
import util.Paging;

public class OneAndBoardDaoImpl implements OneAndBoardDao {

	// DB���� ��ü
	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List selectAll() {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT B.*, U.U_NAME FROM oneandboard O";
		sql += " INNER JOIN USERS U";
		sql += " ON O.U_NO = U.U_NO";
		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� List
		List list = new ArrayList<>();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// ��ü��ȸ ��� ���
			while (rs.next()) {
				OneAndBoard o = new OneAndBoard();

				// ResultSet�� ��� �� �ϳ��� DTO�� ����
				o.setU_no(rs.getInt("u_no"));
				o.setOne_no(rs.getInt("one_no"));
				o.setOne_title(rs.getString("one_title"));
				o.setOne_content(rs.getString("one_content"));
				o.setFile_no(rs.getInt("file_no"));
				o.setOne_date(rs.getDate("one_date"));
				o.setOne_status(rs.getString("one_status"));
				o.setOne_anscontent(rs.getString("one_anscontent"));
				o.setOne_ansdate(rs.getDate("one_ansdate"));

				o.setU_name(rs.getString("u_name"));
				// ��ȸ����� List�� ����
				list.add(o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü��ȸ ��� ��ȯ
		return list;
	}

	

	@Override
	public OneAndBoard selectOneBoardByOneno(OneAndBoard oboardview) {

		// ��ü ��ȸ ����
		String sql = "";
		
		sql += "SELECT O.*, U.U_NAME , U_ID, file_storedname FROM oneandboard O";
		sql += " INNER JOIN USERS U";
		sql += " ON O.U_NO = U.U_NO";
		sql += " INNER JOIN fileupload f";
		sql += " ON O.file_no = f.file_no";
		sql += " WHERE one_no= ?";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ��ȸ ��� ���� DTO
		OneAndBoard o = new OneAndBoard();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oboardview.getOne_no());
			rs = ps.executeQuery();

			// ��� ���
			while (rs.next()) {
				
				// ResultSet�� ��� �� �ϳ��� DTO�� ����
				o.setU_no(rs.getInt("u_no"));
				o.setOne_no(rs.getInt("one_no"));
				o.setOne_title(rs.getString("one_title"));
				o.setOne_content(rs.getString("one_content"));
				o.setFile_no(rs.getInt("file_no"));
				o.setOne_date(rs.getDate("one_date"));
				o.setOne_status(rs.getString("one_status"));
				o.setOne_anscontent(rs.getString("one_anscontent"));
				o.setOne_ansdate(rs.getDate("one_ansdate"));
				
				o.setU_name(rs.getString("u_name"));
				o.setU_id(rs.getString("u_id"));
				
				o.setFile_storedname(rs.getString("file_storedname"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ȸ ��� ��ȯ
		return o;
	}

	@Override
	public int selectCntOneBoard() {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT COUNT(*) FROM oneandboard";

		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� ����
		int cnt = 0;

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü �Խñ� �� ��ȯ
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += " SELECT o.*, u.u_name FROM oneandboard o, users u";
		sql += " WHERE o.u_no = u.u_no";
		sql += "	ORDER BY one_no desc";
		sql += " ) B";
		sql += " ORDER BY rnum";
		sql += " ) R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� List
		List list = new ArrayList<>();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();

			// ��ü��ȸ ��� ���
			while (rs.next()) {
				OneAndBoard o = new OneAndBoard();

				// ResultSet�� ��� �� �ϳ��� DTO�� ����
				o.setU_no(rs.getInt("u_no"));
				o.setOne_no(rs.getInt("one_no"));
				o.setOne_title(rs.getString("one_title"));
				o.setOne_content(rs.getString("one_content"));
				o.setFile_no(rs.getInt("file_no"));
				o.setOne_date(rs.getDate("one_date"));
				o.setOne_status(rs.getString("one_status"));
				o.setOne_anscontent(rs.getString("one_anscontent"));
				o.setOne_ansdate(rs.getDate("one_ansdate"));
				
				o.setU_name(rs.getString("u_name"));


				// ��ȸ����� List�� ����
				list.add(o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ü��ȸ ��� ��ȯ
		return list;
	}
	
	@Override
	public void oneAndBoardUpdate(OneAndBoard oboardUpdate) {
              PreparedStatement ps = null; 
              ResultSet rs = null;
        
              String sql = " ";
              sql+="UPDATE oneandboard";
              sql+=" SET one_status = 'y' , one_anscontent = ?, one_ansdate = sysdate ";      
              sql+=" WHERE one_no = ?";
              
        try {

            ps = conn.prepareStatement(sql);
            
            ps.setString(1, oboardUpdate.getOne_anscontent());
            ps.setInt(2, oboardUpdate.getOne_no( ));

            ps.executeUpdate();
            
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB��ü �ݱ�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
	
	@Override
	public List<OneAndBoard> search(String type, String word) {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT O.*, U.U_NAME FROM oneandboard O";
		sql += " INNER JOIN USERS U";
		sql += " ON O.U_NO = U.U_NO";

		if (type.equals("title")) {
			sql += " WHERE O.ONE_TITLE like ?";
		} else if (type.equals("writer")) {
			sql += " WHERE U.U_NAME like ?";
		} else if (type.equals("content")) {
			sql += " WHERE O.ONE_CONTENT like ?";
		}else if (type.equals("status")) {
			sql += " WHERE O.ONE_STATUS like ?";
		}

		
		// DB ��ü
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ���� ��ȸ ��� ���� List
		List list = new ArrayList<>();

		try {
			// DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			rs = ps.executeQuery();
			
	
			// ��ü��ȸ ��� ���
			while (rs.next()) {
                OneAndBoard o = new OneAndBoard();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
                o.setU_name( rs.getString("u_name") );

                o.setU_no( rs.getInt("u_no") );
                o.setOne_no(rs.getInt("one_no"));
				o.setOne_title(rs.getString("one_title"));
				o.setOne_content(rs.getString("one_content"));
				o.setFile_no(rs.getInt("file_no"));
				o.setOne_date(rs.getDate("one_date"));
				o.setOne_status(rs.getString("one_status"));
				o.setOne_anscontent(rs.getString("one_anscontent"));
				o.setOne_ansdate(rs.getDate("one_ansdate"));			

				//��ȸ����� List�� ����
				list.add(o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB��ü �ݱ�
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

			// ��ü��ȸ ��� ��ȯ
			return list;
		}



	@Override
	public FileUpload selectByFileno(int file_no) {
		
		String sql ="";
		sql += "select * from fileupload";
		sql += " where file_no = ?";
		sql += " order by file_no";
		
		FileUpload fu = new FileUpload();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, file_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				fu.setFile_no(rs.getInt("file_no"));
				fu.setFile_originname(rs.getString("file_originname"));
				fu.setFile_storedname(rs.getString("file_storedname"));
				fu.setFile_uploaddate(rs.getDate("file_uploaddate"));
				fu.setFut_code(rs.getInt("fut_code"));
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- �ڿ� ���� ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		return fu;
	}

	
	

}
