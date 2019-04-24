package dao.noticeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.NoticeBoard;
import util.DBConn;
import util.Paging;

public class NoticeBoardDaoImpl implements NoticeBoardDao {

	//DB���� ��ü
	private Connection conn = DBConn.getConnection(); 

	@Override
	public List selectAll() {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM noticeboard";
		sql += " ORDER BY nb_no DESC";
		
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
				NoticeBoard n = new NoticeBoard();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				n.setNb_no( rs.getInt("nb_no") );
				n.setNb_title( rs.getString("nb_title") );
				n.setNb_content( rs.getString("nb_content") );
				n.setFile_no( rs.getInt("file_no") );
				n.setNb_date( rs.getDate("nb_date") );
				n.setNb_count( rs.getInt("nb_count") );				

				//��ȸ����� List�� ����
				list.add(n);
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
	public void updateCount(NoticeBoard nboardview) {

		//��ü ��ȸ ����
		String sql = "";
		sql += "UPDATE noticeboard";
		sql += " SET nb_count = nb_count+1";
		sql += " WHERE nb_no = ?";
		
		//DB ��ü
		PreparedStatement ps = null;
		
		try {
			//AutoCommit ����
			conn.setAutoCommit(false);
			
			//DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nboardview.getNb_no());
			ps.executeUpdate();
			
			//���������� ����� ��� commit
			conn.commit();
			
		} catch (SQLException e) {
			//���ܹ߻� �� rollback
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			try {
				//DB��ü �ݱ�
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}		

	@Override
	public NoticeBoard selectBoardByBoardno(NoticeBoard nboardview) {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT * FROM noticeboard";
		sql += " WHERE nb_no= ?";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//��ȸ ��� ���� DTO
		NoticeBoard n = new NoticeBoard();
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nboardview.getNb_no());
			rs = ps.executeQuery();
			
			//��� ���
			while(rs.next()) {		
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				n.setNb_no( rs.getInt("nb_no") );
				n.setNb_title( rs.getString("nb_title") );
				n.setNb_content( rs.getString("nb_content") );
				n.setFile_no( rs.getInt("file_no") );
				n.setNb_date( rs.getDate("nb_date") );
				n.setNb_count( rs.getInt("nb_count") );		
		
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
		return n;
	}

	@Override
	public int selectCntBoard() {

		//��ü ��ȸ ����
		String sql = "";
		sql += "SELECT COUNT(*) FROM noticeboard";
		
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
		sql += "	SELECT * FROM noticeboard";
		sql += "	ORDER BY nb_no desc";
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
	            NoticeBoard n = new NoticeBoard();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				n.setNb_no( rs.getInt("nb_no") );
				n.setNb_title( rs.getString("nb_title") );
				n.setNb_content( rs.getString("nb_content") );
				n.setFile_no( rs.getInt("file_no") );
				n.setNb_date( rs.getDate("nb_date") );
				n.setNb_count( rs.getInt("nb_count") );				
				
				//��ȸ����� List�� ����
				list.add(n);
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
	public int delectNboardByNboardno(NoticeBoard nboarddel) {
		//��ü ��ȸ ����
		
		        int result = 0;
		
				String sql = "";
				sql += "DELETE FROM noticeboard";
				sql += " WHERE nb_no= ?";
				
				//DB ��ü
				PreparedStatement ps = null; 
				ResultSet rs = null;
				
				//��ȸ ��� ���� DTO
				NoticeBoard n = new NoticeBoard();
				
				try {
					//DB�۾�
					ps = conn.prepareStatement(sql);
					ps.setInt(1, nboarddel.getNb_no());
					result = ps.executeUpdate();
					
					
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
				
				return result;
				
	}


	@Override
	public void noticeBoardInsert(NoticeBoard nboardinsert) {
             
         PreparedStatement ps = null; 
              ResultSet rs = null;
              String sql = " ";
              sql+="INSERT INTO noticeboard";
              sql+=" (nb_no, nb_title, nb_content, file_no, nb_date, nb_count)";      
              sql+=" VALUES(NOTICEBOARD_SEQ.NEXTVAL, ?, ?, 1, sysdate, 0)";
              
        try {

            ps = conn.prepareStatement(sql);
            
            ps.setString(1, nboardinsert.getNb_title());
            ps.setString(2, nboardinsert.getNb_content());
//            ps.setInt(3, nboardinsert.getFile_no());
//            ps.setInt(4, 0);
//            ps.setInt(5, 0);
         
            
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

	
	
	//���� �Լ�

	public void update(NoticeBoard nboardUpdate) {

		 PreparedStatement ps = null; 
         ResultSet rs = null;
         
		String sql = " ";
				sql += "update noticeboard  ";
				sql += " SET nb_title = ?, nb_content = ?";
				sql += " WHERE nb_no = ?";
		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, nboardUpdate.getNb_title());

			ps.setString(2, nboardUpdate.getNb_content());

			ps.setInt(3, nboardUpdate.getNb_no());
			

			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	   

	}

	
	
	@Override
	public List<NoticeBoard> search(String type, String word) {

		// ��ü ��ȸ ����
		String sql = " ";
		sql += "SELECT * FROM noticeboard";
	

		if (type.equals("title")) {
			sql += " WHERE nb_title like ?";
		} else if (type.equals("content")) {
			sql += " WHERE nb_content like ?";
		} 

//		sql+= "ORDER BY nb_no ";
		
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
				NoticeBoard n = new NoticeBoard();

				// ResultSet�� ��� �� �ϳ��� DTO�� ����
				n.setNb_no(rs.getInt("nb_no"));
				n.setNb_title(rs.getString("nb_title"));
				n.setNb_content(rs.getString("nb_content"));
				n.setFile_no(rs.getInt("file_no"));
				n.setNb_date(rs.getDate("nb_date"));
				n.setNb_count(rs.getInt("nb_count"));

				// ��ȸ����� List�� ����
				list.add(n);
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















