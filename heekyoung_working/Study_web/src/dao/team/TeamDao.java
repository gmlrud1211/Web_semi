package dao.team;

import java.util.List;

import util.Paging;

public interface TeamDao {

	//총게시글 수 반환
	public int selectCntTeamBoard();

	//페이징처리된 게시글 목록 조회
	public List selectPagingList(Paging paging);

}
