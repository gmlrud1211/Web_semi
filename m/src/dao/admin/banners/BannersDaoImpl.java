package dao.admin.banners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Banners;
import dto.Board;
import dto.FileUpload;
import util.DBConn;
import util.Paging;

public class BannersDaoImpl implements BannersDao {

	//DB���� ��ü
	private Connection conn = DBConn.getConnection(); 

	@Override
	public List selectAll() {

		//��ü ��ȸ ����
		String sql = "";
		sql += "select * from banners b, fileupload f";
		sql += " where b.file_no = f.file_no";
		
		sql += " order by b.bn_no";
		
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
				Banners b = new Banners();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				b.setBn_no( rs.getInt("bn_no") );
				b.setBn_title( rs.getString("bn_title") );
				b.setBn_date( rs.getDate("bn_date") );
				b.setFile_no( rs.getInt("file_no") );
				b.setFile_storedname(rs.getString("file_storedname"));
			 

				
				//��ȸ����� List�� ����
				list.add(b);
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
	public Banners selectBannersByBannersno(Banners bannersview) {

		//��ü ��ȸ ����
		String sql = "";
	
		
		sql += "SELECT * FROM banners";
		sql += " WHERE bn_no= ?";
		
		//DB ��ü
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//��ȸ ��� ���� DTO
		Banners b = new Banners();
		
		try {
			//DB�۾�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bannersview.getBn_no());
			rs = ps.executeQuery();
			
			//��� ���
			while(rs.next()) {		
	
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				b.setBn_no( rs.getInt("bn_no") );
				b.setBn_title( rs.getString("bn_title") );
				b.setBn_date( rs.getDate("bn_date") );
				b.setFile_no( rs.getInt("file_no") );
			 
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
		return b;
	}	
	
	
	
	

	@Override
	public int selectCntBanner() {

		//��ü ��ȸ ����
		String sql = "";
		
		sql += "select count(*) from banners b, fileupload f";
		sql += " where b.file_no = f.file_no";
		
		sql += " order by b.bn_no";
		
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
//	      sql += "SELECT * FROM (";
//	      sql += " SELECT rownum rnum, B.* FROM (";
//	      sql += "   SELECT * FROM banners bn , fileupload f";
//	      sql += " INNER JOIN board d "; 
//	      sql += " ON bn.file_no = f.file_no";
//	      
//	      sql += "   ORDER BY bn_no desc";
//	      sql += " ) B";
//	         
//	      sql += " ORDER BY rnum";
//	      sql += " ) R";
//	      sql += " WHERE rnum BETWEEN ? AND ?";
//		
	      
	      sql += "SELECT * FROM (";
	      sql += " SELECT rownum rnum, B.* , f.file_storedname FROM (";
	      sql += "   SELECT * FROM banners ";
	      sql += "   ORDER BY bn_no desc";
	      sql += " ) B";
	      
	      sql += " INNER JOIN fileupload f  "; 
	      sql += " ON B.file_no = f.file_no";
	      
	      sql += " ORDER BY rnum";
	      sql += " ) R";
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
                Banners b = new Banners();
				
				//ResultSet�� ��� �� �ϳ��� DTO�� ����
				b.setBn_no( rs.getInt("bn_no") );
				b.setBn_title( rs.getString("bn_title") );
				b.setBn_date( rs.getDate("bn_date") );
				b.setFile_no( rs.getInt("file_no") );
				b.setFile_storedname(rs.getString("file_storedname") );
			    

				
				//��ȸ����� List�� ����
				list.add(b);		
				
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
	public int deleteBannerByBannerno(Banners bannerdel) {
		//��ü ��ȸ ����
//				String sql = "";
//				sql += "DELETE FROM report";
//				sql += " WHERE rp_no= ?";
				
			    String sql =" ";
			    sql+= "DELETE from banners";
			    sql+= " WHERE bn_no = ?";
				
			
			    int result = 0;
				//DB ��ü
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				
				try {
					
					//AutoCommit ����
					conn.setAutoCommit(false);
					
					//DB�۾�
					ps = conn.prepareStatement(sql);
					ps.setInt(1, bannerdel.getBn_no());

					result = ps.executeUpdate();
					
					//���������� ����� ��� commit
					conn.commit();
					
				} catch (SQLException e) {
					try {
						//���ܹ߻� �� rollback
						conn.rollback();
						
					} catch (SQLException e1) {
						e.printStackTrace();
					}
					
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
	public int getBanners_no() {
		String sql = "";
		sql += "SELECT banners_SEQ.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int bn_no = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			bn_no = rs.getInt(1);
			
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
		
		return bn_no;
	
	}
	
	@Override
	public void bannersInsert(Banners bannersInsert) {
             
         PreparedStatement ps = null; 
              ResultSet rs = null;
              String sql = " ";
              sql+="INSERT INTO banners";
              sql+=" (bn_no, bn_title, file_no, bn_date)";      
              sql+=" VALUES(banners_seq.nextval,?, ?, sysdate)";
              
        try {

            ps = conn.prepareStatement(sql);
            
            ps.setString(1, bannersInsert.getBn_title());
            ps.setInt(2, bannersInsert.getFile_no());
         
            
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
	public void updateFile(FileUpload fileupload) {
		String sql = "";
		sql += "UPDATE fileUpload SET fut_code = 4";
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


}















