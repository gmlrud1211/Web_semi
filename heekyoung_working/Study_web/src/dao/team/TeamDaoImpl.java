package dao.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Achive;
import dto.AchivePeople;
import dto.FileUpload;
import dto.Study;
import dto.StudyBoard;
import dto.SubAchive;
import dto.UserStudy;
import util.DBConn;
import util.Paging;

public class TeamDaoImpl implements TeamDao{

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	@Override
	public int selectCntTeamBoard() {
		
		//sql작성
		String sql = "";
		sql+="select count(*) from studyboard";
					
		//쿼리 결과저장할 변수
		int cnt = 0;
				
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
					
			//결과처리
			rs.next();
			cnt = rs.getInt(1);
			
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
				
		//전체 게시글 수 반환
		return cnt;
	}

	@Override
	public List selectPagingList(Paging paging) {
		
		//sql작성
		String sql = "";
		sql+="select * from (";
		sql+=" select rownum rnum, B.* from(";
		sql+=" select * from studyboard ";
		sql+=" order by sb_no desc";
		sql+=" ) B";
		sql+=" order by rnum";
		sql+=" ) R";
		sql+=" where rnum between ? and ?";
		
		//쿼리 결과저장할 list
		List<StudyBoard> boardList = new ArrayList<>();
				
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
					
			//결과처리
			while(rs.next())
			{
				StudyBoard board = new StudyBoard();
				
				board.setStudy_no(rs.getInt("study_no"));
				board.setU_no(rs.getInt("u_no"));
				board.setSb_content(rs.getString("sb_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setSb_date(rs.getDate("sb_date"));
				board.setSb_no(rs.getInt("sb_no"));
					
				boardList.add(board);
			}
				
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
			return boardList;
		
	}

	@Override
	public int getSb_no() {
		String sql = "";
		sql += "SELECT STUDYBOARD_SEQ.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int sb_no = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			sb_no = rs.getInt(1);
			
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
		
		return sb_no;
	}

	@Override
	public void insertTeamBoard(StudyBoard board) {

		String sql = "";
		sql += "INSERT INTO studyboard ( study_no , u_no, sb_content, file_no, sb_date, sb_no)";
		sql += " VALUES ( 1, ?, ?, ?, sysdate, STUDYBOARD_SEQ.nextval  )";
		
		//INSERT INTO STUDYBOARD(STUDY_NO,U_NO,SB_CONTENT,FILE_NO,SB_DATE,SB_NO) VALUES (1,	1,'자료받아가세용~5',39,'2019/03/05',STUDYBOARD_SEQ.nextval);
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getU_no());
			ps.setString(2, board.getSb_content());
			ps.setInt(3, board.getFile_no());
			
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
	public void updateFile(FileUpload fileupload) {
		String sql = "";
		sql += "UPDATE fileUpload SET fut_code = 3";
		sql += " WHERE file_no = ?";

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, fileupload.getFut_code());
			ps.setInt(1, fileupload.getFile_no());
			
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
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		return fu;
	}

	@Override
	public Achive insertAchive(Achive achive) {
		String sql ="";
		sql+= "INSERT INTO ACHIVE(STUDY_NO,A_NO,A_TITLE,A_SDATE,A_DDATE)";
		sql+= " VALUES(1 ,Achive_seq.nextval, ? , sysdate, ? )";
		//세션 연결안해서 임의로 study_no='1' 집어넣음
		
		//INSERT INTO ACHIVE(STUDY_NO,A_NO,A_TITLE,A_SDATE,A_DDATE)
		//VALUES (1,Achive_seq.nextval	,'JAVA·JSP 기초 연습문제 2','2019/03/05',null);

		
		try {
			ps = conn.prepareStatement(sql);
			
			//ps.setInt(parameterIndex, achive.getStudy_no());
			
			ps.setString(1, achive.getA_title());
			ps.setString(2, achive.getA_ddate());
			
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
		
				
		return achive;
	}

	@Override
	public int getStudy_no(Study study) {
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
	public List userStudySelectAll(UserStudy userStudy) {
		//sql 작성
		String sql ="";
		sql +="select * from userstudy";
		sql +=" where study_no = 1 "; //아직 연결안되서 임의로 값 집어넣음
		
		List<UserStudy> userStudyList = new ArrayList<>();
		
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, userStudy.getStudy_no());
			
			rs = ps.executeQuery();
			
			//결과처리
			while(rs.next())
			{
				UserStudy user_Study = new UserStudy();
				//ResultSet의 결과 행이 DTO에 하나씩 저장됨
				user_Study.setU_no(rs.getInt("u_no"));;
				user_Study.setStudy_no(rs.getInt("study_no"));
				
				userStudyList.add(user_Study);
			}
		
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
		
		return userStudyList;
	}

	@Override
	public List achiveSelectAll(Achive achive) {
		//sql 작성
		String sql ="";
		sql +="select A.study_no, A.a_no, to_char(A.a_ddate, 'YYYY-MM-DD') a_ddate, A.a_title, S.suba_no, S.suba_name";
		sql +=" FROM achive A JOIN subAchive S ON A.study_no = S.study_no AND A.A_NO = S.A_NO";
		sql +=" WHERE A.study_no = 1"; //아직 study_no 연결처리 안되서 임의로 study_no=1 집어넣음
		sql +=" ORDER BY study_no, a_no, suba_no";
		
		
		List<Achive> achiveList  = new ArrayList<>();
		
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, achive.getStudy_no());
			
			rs = ps.executeQuery();
			
			//결과처리
			while(rs.next())
			{
				Achive achive_list = new Achive();
				//ResultSet의 결과 행이 DTO에 하나씩 저장됨
				achive_list.setA_no(rs.getInt("a_no"));
				achive_list.setA_title(rs.getString("a_title"));
				achive_list.setA_ddate(rs.getString("a_ddate"));
				achive_list.setSuba_no(rs.getInt("suba_no"));
				achive_list.setSuba_name(rs.getString("suba_name"));
				//achive_list.setA_adate(rs.getString("a_sdate"));
								
				achiveList.add(achive_list);
			}
		
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
		
		return achiveList;
	}

	@Override
	public void checkSubAchive(AchivePeople achivePeople) {
		String sql="";
		sql+= "INSERT INTO ACHIVEPEOPLE(SUBA_NO,SUB_CODE,U_NO)";
		sql+= " VALUES(?, ?, ?)";
		
		//INSERT INTO achivepeople VALUES ( 1,'yes', 1 );
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, achivePeople.getSuba_no());
			ps.setString(2, achivePeople.getSub_code());
			ps.setInt(3, achivePeople.getU_no());
			
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
	public void insertCheckSubAchive(AchivePeople achivePeople) {
		String sql="";
		sql+= "INSERT INTO ACHIVEPEOPLE(SUBA_NO,SUB_CODE,U_NO)";
		sql+= " VALUES(?, '0',?)";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, achivePeople.getSuba_no());
			ps.setInt(2, achivePeople.getU_no());
			
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
	public void deleteCheckSubAchive(AchivePeople achivePeople) {
		String sql="";
		sql+= "DELETE ACHIVEPEOPLE";
		sql+= " WHERE suba_no=?";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, achivePeople.getSuba_no());
			
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
	public void insertSubAchive(Achive achive) {
		String sql="";
		sql+= "insert into subachive(study_no, a_no, suba_no, suba_name, suba_sdate)";
		sql+= " values(1,?,subachive_seq.nextval, ?,sysdate)";
		
//		insert into subachive(study_no, a_no, suba_no, suba_name, suba_sdate, suba_ddate)
//		values(1,43,subachive_seq.nextval, 'ㅜㅜ', sysdate, '19/03/07');

		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, achive.setStudy_no());
			ps.setInt(1, achive.getA_no());
			System.out.println(achive.getA_no());
			ps.setString(2, achive.getSuba_name());
			
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
	public int getA_no(Achive achive) {
		String sql = "";
		sql += "SELECT ACHIVE_SEQ.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int a_no = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			a_no = rs.getInt(1);
			
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
		
		return a_no;
	}		

}
	
