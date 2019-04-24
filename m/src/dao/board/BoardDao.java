package dao.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import dto.BoardComment;
import dto.FileUpload;
import util.Paging;

public interface BoardDao {

	//게시글 전체 조회
	public List selectAll();
	
	//게시글 조회수 증가
	public void updateHit(Board boardView);
	
	//게시글 상세조회 반환
	public Board selectBoardByBoardno(Board boardView);
	
	//총 게시글 수 반환
	public int selectCntBoard();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);

	public List<Board> boardSearch(String type, String keyword);

	public void boardWrite(int b_no, Board board);

	public void boardDelete(String b_no);

	public Board getBoard(String b_no);

	public void brdRecommend(String b_no);

	public void rcmdUpdate(String b_no, int u_no);

	public void brdRecommendCancel(String b_no);

	public void rcmdUpdateCancel(String b_no, int u_no);

	public int getRecommendCnt(String b_no);

	public void boardReport(String b_no, int u_no);

	public boolean isRcmd(Board board, int u_no);

	public int getUno(Board board);

	public void rcmdUpdateCancel(String b_no);

	public void boardUpdate(Board board);
	
	//시퀀스에서 게시글 번호 얻기
	public int getBoardno();
	
	//삽입된 파일에 게시글번호 입력하기
	//public void updateFile(UploadFile file);

	public String getFileName(int b_no);

	public void updateFileBNo(int b_no, int file_no);

	public List<BoardComment> getComment(int b_no);

	public void commentWrite(BoardComment boardcmt);

	public List<Board> getBestBoard();

	public void updateFile(FileUpload fileupload);

	public FileUpload selectByFileno(int file_no);

	public void deleteComment(int cmt_no);

	public void commentUpdate(int bc_no, String content);

}
