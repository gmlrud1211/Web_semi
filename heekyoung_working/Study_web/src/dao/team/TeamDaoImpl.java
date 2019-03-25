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
import dto.StudyTeamState;
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
	public List userStudySelectAll(StudyTeamState studyTeamState) {
		//sql 작성
		String sql ="";
		sql +="select u.u_no, u.u_name";
		sql +=" from studyteamstate s, users u";
		sql +=" where s.u_no = u.u_no(+)";
		sql +=" and s.study_no=1"; //아직 study_no 연결안되서 임의로 값 집어넣음
		sql +=" order by u_no asc";
				
	
		List<StudyTeamState> userStudyList = new ArrayList<>();
		
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, userStudy.getStudy_no());
			
			rs = ps.executeQuery();
			
			//결과처리
			while(rs.next())
			{
				StudyTeamState user_Study = new StudyTeamState();
				//ResultSet의 결과 행이 DTO에 하나씩 저장됨
		
				user_Study.setU_no(rs.getInt("u_no"));
				user_Study.setU_name(rs.getString("u_name"));
				//user_Study.setStudy_no(rs.getInt("study_no"));
				
				userStudyList.add(user_Study);
			}
			System.out.println(userStudyList);
		
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
		
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, achive.setStudy_no());
			ps.setInt(1, achive.getA_no()-1);
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

	@Override
	public int selectSubAchiveCnt() {
		//sql작성
		String sql = "";
		sql +="SELECT count(S.suba_no)";
		sql +=" FROM achive A JOIN subAchive S ON A.study_no = S.study_no AND A.A_NO = S.A_NO";
		sql +=" WHERE A.study_no = 1 and A.a_no =1";//목표번호 임의로 삽입
		//sql +=" group by A.study_no, A.a_no";
		//sql +=" ORDER BY study_no, a_no";
		
		/*
			sql +="SELECT A.study_no, A.a_no,count(S.suba_no) cnt";
			sql +=" FROM achive A JOIN subAchive S ON A.study_no = S.study_no AND A.A_NO = S.A_NO";
			sql +=" WHERE A.study_no = 1 and A.a_no =1";//목표번호 임의로 삽입
			sql +=" group by A.study_no, A.a_no";
			sql +=" ORDER BY study_no, a_no";
		*/
		
		
							
		//쿼리 결과(세부목표 갯수)저장할 변수
		int cnt = 0;
						
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
							
			//결과처리
			rs.next();
			cnt = rs.getInt(1);
			System.out.println(cnt+"개");
					
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
						
		//개수 반환
		return cnt;
		}

	@Override
	public int selectUserSubAchiveCnt(Achive achive) {
		//sql작성
		String sql = "";
		sql +="select * from";
		sql +=" (SELECT A.a_no, count(*) cnt, P.u_no";
		sql +=" FROM achivepeople P, subachive A";
		sql +=" WHERE P.suba_no = A.suba_no";
		sql +=" GROUP BY a_no, u_no )";
		sql +=" where u_no=?";
		
		
	/*	sql +="SELECT A.a_no, P.u_no, S.suba_no";
		sql +=" FROM achive A JOIN subAchive S ON A.study_no = S.study_no AND A.A_NO = S.A_NO";
		sql +=" JOIN achivepeople P ON S.suba_no=P.suba_no";
		sql +=" WHERE A.study_no = 1 and A.a_no = 1 and P.u_no= ?"; //스터디번호 목표번호 임의로 삽입
		sql +=" GROUP BY A.a_no, P.u_no, S.suba_no";
		sql +=" order by a_no";
	 */

		  
		//쿼리 결과 저장할 변수
		int cnt = 0;

		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, achive.getA_no());
			ps.setInt(1, achive.getU_no());	
			
			
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
								
		//개수 반환
		return cnt;
		}

	@Override
	public List<AchivePeople> selectAchivePeopleList(int u_no) {
		
		String sql="";
		sql +="SELECT RES.*, round(people_cnt/tot_cnt, 3)*100 ||'%' 달성률 FROM (";
		sql +=" SELECT PCNT.*";
		sql +=" , ( SELECT COUNT(*) FROM subachive SA WHERE SA.study_no = PCNT.study_no AND SA.a_no = PCNT.a_no ) TOT_CNT";
		sql +=" FROM (";
		sql +=" SELECT S.study_no, S.a_no, NVL(P.u_no, -1) u_no, count(P.u_no) people_cnt";
		sql +=" FROM subachive S, achivepeople P";
		sql +=" WHERE S.suba_no = P.suba_no(+)";
		sql +=" AND u_no=?";
		sql +=" GROUP BY study_no, a_no, u_no";
		sql +=" ) PCNT";
		sql +=" ) RES";
		sql +=" ORDER BY study_no, a_no, u_no";
				

		//쿼리 결과저장할 list
		List<AchivePeople> achivePeopleList = new ArrayList<>();
				
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u_no);
					
			rs = ps.executeQuery();
					
			
			
			//결과처리
			while(rs.next())
			{
				AchivePeople achive = new AchivePeople();
				
				achive.setStudy_no(rs.getInt("study_no"));
				achive.setA_no(rs.getInt("a_no"));
				achive.setU_no(rs.getInt("u_no"));
				//achive.setSuba_no(rs.getInt("suba_no"));
				//achive.setSub_code(rs.getString("sub_code"));
				//achive.setChecked(rs.getBoolean("checked"));
				
					
				achivePeopleList.add(achive);
				System.out.println(achivePeopleList);
				System.out.println();
			
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
			return achivePeopleList;
			
	}

	@Override
	public boolean deleteUserStudyByUserno(StudyTeamState userStudy) {
		String sql ="";
		sql +="delete from studyteamstate";
		sql +=" where u_no = ? and study_no=1"; //study_no = 1 임의로 설정
		
		int result = 0;
		boolean deleteresult = false;
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;

		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userStudy.getU_no());
			System.out.println("u_no : "+userStudy.getU_no());
			
			result = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
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
	public void studyUpdate(Study study) {
		String sql ="";
		sql +="update study set study_region= ?, study_time= ?, study_freq= ?, study_min=?, study_max=?, study_gender=?, study_details=?, study_addrecruit=?";
		sql +=" where study_no = 1"; //임의로 study_no=1 지정

		/*
			sql +="update study set study_region='역삼', study_time='주말 오후', study_freq='주 2회', study_min=5, study_max=9, study_details='우리함게 잘해봅시다~', study_addrecruit='19/02/20'";
			sql +=" where study_no = 1 Limit 1 "; //임의로 study_no=1 지정
		*/
		
		
		try {
			
			ps= conn.prepareStatement(sql);
			
//			ps.setInt(1, study.getSt_code());
//			ps.setString(2, study.getStudy_name());
//			ps.setInt(1, study.getFile_no());
			ps.setString(1, study.getStudy_region());
			ps.setString(2, study.getStudy_time());
			ps.setString(3, study.getStudy_freq());
			ps.setInt(4,study.getStudy_min());
			ps.setInt(5, study.getStudy_max());
			ps.setString(6, study.getStudy_gender());
			ps.setString(7,study.getStudy_details());
			ps.setString(8, study.getStudy_addrecruit());

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
	
