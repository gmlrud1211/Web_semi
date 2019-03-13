package dao.team;

import java.util.List;

import dto.FileUpload;
import dto.StudyBoard;
import util.Paging;

public interface TeamDao {

	//총게시글 수 반환
	public int selectCntTeamBoard();

	//페이징처리된 게시글 목록 조회
	public List selectPagingList(Paging paging);

	//시퀀스에서 게시글 번호 얻기
	public int getSb_no();
	
	//게시글 삽입
	public void insertTeamBoard(StudyBoard board);
		
	//삽입된 파일에 게시글번호 입력하기
	public void updateFile(FileUpload fileupload);
	
	
	
}
