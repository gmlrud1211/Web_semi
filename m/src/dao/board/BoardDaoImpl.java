package dao.board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.BoardComment;
import dto.FileUpload;
import util.DBConn;
import util.Paging;

public class BoardDaoImpl implements BoardDao {
private Connection conn = DBConn.getConnection(); 
private PreparedStatement ps = null;
private ResultSet rs = null;
	
	@Override
	public List<Board> selectAll() {
		
		String sql = "";
		sql += "SELECT * FROM BOARD, USERS";
		sql += " INNER JOIN REPORT ";
		sql += " ON REPORT.U_NO = USERS.U_NO";
		sql += " WHERE REPORT.RE_YESNO != 'Y'";
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setU_name(rs.getString("u_name"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public void updateHit(Board boardView) {
		String sql = "";
		sql += "UPDATE BOARD SET B_COUNT = B_COUNT+1 WHERE B_NO = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardView.getB_no());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Board selectBoardByBoardno(Board boardView) {
		
		String sql = "";
		sql += "SELECT BOARD.*, USERS.U_NAME FROM BOARD";
		sql += " INNER JOIN USERS";
		sql += " ON BOARD.U_NO = USERS.U_NO WHERE B_NO=?";
		
		Board board = new Board();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardView.getB_no());
			rs = ps.executeQuery();
		
			while (rs.next()) {
				board.setB_no(rs.getInt("b_no"));
				board.setU_name(rs.getString("u_name"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}

	
	@Override
	public int selectCntBoard() {

		//�쟾泥� 議고쉶 荑쇰━
		String sql = "";
		sql += "SELECT COUNT(*) FROM board";
		
		//理쒖쥌 議고쉶 寃곌낵 �떞�쓣 蹂��닔
		int cnt = 0;
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// �쟾泥� 寃뚯떆湲� �닔 諛섑솚
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {
		
		//�쟾泥� 議고쉶 荑쇰━
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, B.*, U.U_NAME FROM (";
		sql += "	SELECT * FROM BOARD";
		sql += "	ORDER BY b_no desc";
		sql += " ) B";
		sql += " INNER JOIN USERS U"; 
		sql += " ON B.U_NO = U.U_NO";
		sql += " ORDER BY rnum";
		sql += " ) R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//理쒖쥌 議고쉶 寃곌낵 �떞�쓣 List
		List list = new ArrayList<>();
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			//�쟾泥댁“�쉶 寃곌낵 �떞湲�
			while(rs.next()) {
				Board board = new Board();
				
				//ResultSet�쓽 寃곌낵 �뻾 �븯�굹�뵫 DTO�뿉 ���옣
				board.setB_no(rs.getInt("b_no"));
				board.setU_name(rs.getString("u_name"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
				//議고쉶寃곌낵瑜� List濡� �깮�꽦
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// �쟾泥댁“�쉶 寃곌낵 諛섑솚
		return list;
	}


	@Override
	public List<Board> boardSearch(String type, String keyword) {
		
		//�쟾泥� 議고쉶 荑쇰━
		String sql = "";
		
		sql += "SELECT B.*, U.U_NAME FROM BOARD B";
		sql += " INNER JOIN USERS U";
		sql += " ON B.U_NO = U.U_NO";
		
		if(type.equals("title")) {
			sql += " WHERE B.b_title like ?";
		} else if (type.equals("writer")) {
			sql += " WHERE U.u_name like ?";
		} else if (type.equals("content")) {
			sql += " WHERE B.b_content like ?";
		}
		
		sql += " ORDER BY B.b_no DESC";

		//理쒖쥌 議고쉶 寃곌낵 �떞�쓣 List
		List list = new ArrayList<>();
		
		try {
			//DB�옉�뾽
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs = ps.executeQuery();

			//�쟾泥댁“�쉶 寃곌낵 �떞湲�
			while(rs.next()) {
				Board board = new Board();
				
				//ResultSet�쓽 寃곌낵 �뻾 �븯�굹�뵫 DTO�뿉 ���옣
				board.setB_no(rs.getInt("b_no"));
				board.setU_name(rs.getString("u_name"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
				//議고쉶寃곌낵瑜� List濡� �깮�꽦
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// �쟾泥댁“�쉶 寃곌낵 諛섑솚
		return list;
	}

	@Override
	public void boardWrite(int b_no, Board board) {
		
		if(board.getFile_no()>0) {
			String sql = "";
			sql += "INSERT INTO BOARD (B_NO, U_NO, B_HEAD, B_TITLE, B_CONTENT, FILE_NO, B_DATE, B_UPCOUNT, B_COUNT)";
			sql += " VALUES(?, ?, ?, ?, ?, ?, SYSDATE, 0, 0)";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, b_no);
				ps.setInt(2, board.getU_no());
				ps.setString(3, board.getB_head());
				ps.setString(4, board.getB_title());
				ps.setString(5, board.getB_content());
				ps.setInt(6, board.getFile_no());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			String sql = "";
			sql += "INSERT INTO BOARD (B_NO, U_NO, B_HEAD, B_TITLE, B_CONTENT, FILE_NO, B_DATE, B_UPCOUNT, B_COUNT)";
			sql += " VALUES(?, ?, ?, ?, ?, NULL, SYSDATE, 0, 0)";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, b_no);
				ps.setInt(2, board.getU_no());
				ps.setString(3, board.getB_head());
				ps.setString(4, board.getB_title());
				ps.setString(5, board.getB_content());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}

	@Override
	public void boardDelete(String b_no) {
		String sql = "";
		sql += "DELETE FROM BOARD WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Board getBoard(String b_no) {
		String sql = "";
		sql += "SELECT * FROM BOARD";
		sql += " WHERE B_NO = ?";
		
		Board board = new Board();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			rs = ps.executeQuery();
		
			while (rs.next()) {
				board.setB_no(rs.getInt("b_no"));
				board.setU_no(rs.getInt("u_no"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}

	
	// 寃뚯떆湲� 異붿쿇 �닔 利앷�
	@Override
	public void brdRecommend(String b_no) {
		String sql = "";
		sql += "UPDATE BOARD SET B_UPCOUNT=B_UPCOUNT+1 WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 寃뚯떆�뙋 異붿쿇 �뀒�씠釉� insert
	@Override
	public void rcmdUpdate(String b_no, int u_no) {

		String sql = "";
		sql += "INSERT INTO BOARDRECOMMEND (RCMD_NO, B_NO, U_NO, RCMD_DATE) VALUES (BOARD_RECOMMEND_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.setInt(2, u_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void brdRecommendCancel(String b_no) {
		String sql = "";
		sql += "UPDATE BOARD SET B_UPCOUNT=B_UPCOUNT-1 WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void rcmdUpdateCancel(String b_no, int u_no) {
		
		String sql = "";
		sql += "DELETE FROM BOARDRECOMMEND WHERE B_NO = ? AND U_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.setInt(2, u_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void rcmdUpdateCancel(String b_no) {
		String sql = "";
		sql += "DELETE FROM BOARDRECOMMEND WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int getRecommendCnt(String b_no) {
		int rcmdCnt = 0;
		String sql = "";
		sql += "SELECT B_UPCOUNT FROM BOARD WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			rs = ps.executeQuery();
			
			rs.next();
			rcmdCnt = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rcmdCnt;
	}

	@Override
	public void boardReport(String b_no, int u_no) {
		String sql = "";
		sql += "INSERT INTO REPORT (RP_NO, B_NO, U_NO, RP_DATE, RP_STATUS, RE_YESNO, RE_DATE)";
		sql += " VALUES (REPORT_SEQ.NEXTVAL, ?, ?, SYSDATE, '처리중', 'N', null)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_no);
			ps.setInt(2, u_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isRcmd(Board board, int u_no) {
		boolean isRcmd = false;
		String sql = "";
		sql += "SELECT COUNT(*) FROM BOARDRECOMMEND WHERE B_NO = ? AND U_NO = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getB_no());
			ps.setInt(2, u_no);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				if(rs.getInt(1) > 0) {
					isRcmd = true;
				} else {
					isRcmd = false;
				}
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isRcmd;
	}

	@Override
	public int getUno(Board board) {
		int u_no = 0;
		String sql = "";
		sql += "SELECT u_no FROM BOARD WHERE B_NO = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getB_no());
			rs = ps.executeQuery();
			
			rs.next();
			u_no = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u_no;
	}

	@Override
	public void boardUpdate(Board board) {
		if(board.getFile_no() > 0 ) {
			String sql = "";
			sql += "UPDATE BOARD SET B_HEAD=?, B_TITLE=?, B_CONTENT=?, FILE_NO=?, B_DATE=SYSDATE";
			sql += " WHERE B_NO = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, board.getB_head());
				ps.setString(2, board.getB_title());
				ps.setString(3, board.getB_content());
				ps.setInt(4, board.getFile_no());
				ps.setInt(5, board.getB_no());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			String sql = "";
			sql += "UPDATE BOARD SET B_HEAD=?, B_TITLE=?, B_CONTENT=?, B_DATE=SYSDATE";
			sql += " WHERE B_NO = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, board.getB_head());
				ps.setString(2, board.getB_title());
				ps.setString(3, board.getB_content());
				ps.setInt(4, board.getB_no());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	
	
	@Override
	public int getBoardno() {
		String sql = "";
		sql += "SELECT board_seq.nextval FROM dual";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int boardno = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
		
			boardno = rs.getInt(1);
			
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
		
		return boardno;
	}
	
	
//�닔�젙�븘�슂
	@Override
	public String getFileName(int b_no) {
		
		String fileName = "";
		String sql = "";
		sql += "select f.FILE_ORIGINNAME from board B";
		sql += " inner join fileupload F ";
		sql += " on b.file_no = f.file_no ";
		sql += " where b.b_no = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				fileName = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileName;
	}


	
	@Override
	public List<BoardComment> getComment(int b_no) {
		
		//�쟾泥� 議고쉶 荑쇰━
		
		String sql = "";
		sql += "SELECT B.*, U.U_NAME FROM BOARDCOMMENT B";
		sql += " INNER JOIN USERS U ON B.U_NO = U.U_NO";
		sql += " WHERE B_NO = ? ORDER BY BC_NO ";
	
		//理쒖쥌 議고쉶 寃곌낵 �떞�쓣 List
		List<BoardComment> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b_no);
			rs = ps.executeQuery();
	
			//�쟾泥댁“�쉶 寃곌낵 �떞湲�
			while(rs.next()) {
				BoardComment boardcmt = new BoardComment();
				boardcmt.setB_no(rs.getInt("b_no"));
				boardcmt.setBc_no(rs.getInt("bc_no"));
				boardcmt.setBc_comment(rs.getString("bc_comment"));
				boardcmt.setU_no(rs.getInt("u_no"));
				boardcmt.setBc_date(rs.getDate("bc_date"));
				boardcmt.setBc_reno(rs.getInt("bc_reno"));
				boardcmt.setBc_idx(rs.getInt("bc_idx"));
				boardcmt.setU_name(rs.getString("u_name"));
				
				//ResultSet�쓽 寃곌낵 �뻾 �븯�굹�뵫 DTO�뿉 ���옣
				//議고쉶寃곌낵瑜� List濡� �깮�꽦
				
				list.add(boardcmt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB媛앹껜 �떕湲�
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// �쟾泥댁“�쉶 寃곌낵 諛섑솚
		return list;
	}

	@Override
	public void commentWrite(BoardComment boardcmt) {
		String sql = "";

		sql += "INSERT INTO BOARDCOMMENT ( B_NO, BC_NO, BC_COMMENT, U_NO, BC_DATE, BC_RENO, BC_IDX)";
		sql += " VALUES ( ?, BOARDCOMMENT_SEQ.NEXTVAL, ?, ?, sysdate, ?, BOARDCOMMENT_SEQ.NEXTVAL )";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, boardcmt.getB_no());
			ps.setString(2, boardcmt.getBc_comment());
			ps.setInt(3, boardcmt.getU_no());
			ps.setInt(4, boardcmt.getBc_reno());
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
	public List<Board> getBestBoard() {
		String sql = "";
		sql += "SELECT BOARD.*, USERS.U_NAME FROM BOARD";
		sql += " INNER JOIN USERS ON BOARD.U_NO = USERS.U_NO";
		sql += " WHERE B_DATE >= TO_CHAR(SYSDATE-7,'YYYY/MM/DD') AND ROWNUM <= 15";
		sql += " ORDER BY B_UPCOUNT DESC";

		List<Board> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while (rs.next()) {

				Board board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setU_name(rs.getString("u_name"));
				board.setB_head(rs.getString("b_head"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setFile_no(rs.getInt("file_no"));
				board.setB_date(rs.getDate("b_date"));
				board.setB_upcount(rs.getInt("b_upcount"));
				board.setB_count(rs.getInt("b_count"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void updateFileBNo(int b_no, int file_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FileUpload selectByFileno(int file_no) {
		String sql ="";
		sql += "select * from FileUpload";
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
				//--- �옄�썝 �빐�젣 ---
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
	public void updateFile(FileUpload fileupload) {
		String sql = "";
		sql += "UPDATE fileUpload SET fut_code = 1";
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
	public void deleteComment(int cmt_no) {
		
		String sql = "";
		sql += "DELETE FROM BOARDCOMMENT WHERE BC_NO = ?";

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cmt_no);
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
	public void commentUpdate(int bc_no, String content) {
		String sql = "";
		sql += "UPDATE BOARDCOMMENT SET BC_COMMENT = ? WHERE BC_NO = ? ";

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, bc_no);
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


