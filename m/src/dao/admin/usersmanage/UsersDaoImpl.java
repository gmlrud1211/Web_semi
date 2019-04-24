package dao.admin.usersmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.NoticeBoard;
import dto.Users;
import util.DBConn;
import util.Paging;

public class UsersDaoImpl implements UsersDao {

	//DB���� ��ü
	private Connection conn = DBConn.getConnection(); 

	@Override
	public List selectAll() {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM users";
		sql += " ORDER BY u_no DESC";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//���� ��ȸ ��� ���� List
		List list = new ArrayList<>();
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//��ü��ȸ ��� ���
			while(rs.next()) {
				Users u = new Users();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("nb_id") );
				u.setU_pw( rs.getString("nb_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getString("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );				

				//��ȸ����� List�� ����
				list.add(u);
			}
			
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
		
		// ��ü��ȸ ��� ��ȯ
		return list;
	}

	

	@Override
	public Users selectUsersByUsersno(Users usersview) {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM users";
		sql += " WHERE u_no= ?";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//��ȸ ��� ���� DTO
		Users u = new Users();
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, usersview.getU_no());
			rs = ps.executeQuery();
			
			//��� ���
			while(rs.next()) {		
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("u_id") );
				u.setU_pw( rs.getString("u_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getString("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );		
			}
			
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
		
		// ��ü��ȸ ��� ��ȯ
		return u;
	}

	@Override
	public int selectCntUsers() {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT COUNT(*) FROM users";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//���� ��ȸ ��� ���� ����
		int cnt = 0;
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
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
		
		// ��ü �Խñ� �� ��ȯ
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "	SELECT * FROM users";
		sql += "	ORDER BY u_no desc";
		sql += " ) B";
		sql += " ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//���� ��ȸ ��� ���� List
		List list = new ArrayList<>();
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			//��ü��ȸ ��� ���
			while(rs.next()) {
                Users u = new Users();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("u_id") );
				u.setU_pw( rs.getString("u_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getString("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );		
				//��ȸ����� List�� ����
				list.add(u);
			}
			
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
		
		// ��ü��ȸ ��� ��ȯ
		return list;
	}



	@Override
	public boolean deleteUsersByUsersno(Users usersdel) {
		//��ü ��ȸ ����
				String sql = "";
				sql += "DELETE FROM users";
				sql += " WHERE u_no= ?";
				
				
				int result = 0;
				boolean deleteresult = false;

				
				//DB ��ü
				PreparedStatement ps = null; 
				ResultSet rs = null;
	
				
				try {
					//DB�۾�
					ps = conn.prepareStatement(sql);
					ps.setInt(1, usersdel.getU_no());
					
					
					result = ps.executeUpdate();
					
//					Users u = new Users();
//					//��� ���
//					while(rs.next()) {		
//						
//						//ResultSet�� ��� �� �ϳ��� DTO�� ����
//						u.setU_no( rs.getInt("u_no") );
//						u.setU_id( rs.getString("u_id") );
//						u.setU_pw( rs.getString("u_pw") );
//						u.setU_name( rs.getString("u_name") );
//						u.setU_phone( rs.getString("u_phone") );
//						u.setU_email( rs.getString("u_email") );				
//						u.setU_birth( rs.getDate("u_birth") );				
//						u.setU_regdate( rs.getDate("u_regdate") );		
//					}  
					
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
				
				if (result > 0) {
					deleteresult = true;
				} else {
					deleteresult = false;
				}
				return deleteresult;

	}
	@Override
	public List<Users> search(String type, String word) {

		// ��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM users";

		if (type.equals("no")) {
			sql += " WHERE u_no like ?";
		} else if (type.equals("name")) {
			sql += " WHERE u_name like ?";
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
                Users u = new Users();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				u.setU_no( rs.getInt("u_no") );
			
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getString("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );				

				//��ȸ����� List�� ����
				list.add(u);
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


}















