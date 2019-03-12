package dao.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.study.StudyBoard;
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

}
