package service.admin.oneandboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.oneandboard.OneAndBoardDao;
import dao.admin.oneandboard.OneAndBoardDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.OneAndBoard;
import util.Paging;

public class OneAndBoardServiceImpl implements OneAndBoardService {

	private OneAndBoardDao oboardDao = new OneAndBoardDaoImpl();

	@Override
	public OneAndBoard getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		OneAndBoard oboard = new OneAndBoard();
		
		//요청파라미터 받기
		String one_no= req.getParameter("one_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( one_no!= null && !"".equals(one_no) ) {
			oboard.setOne_no(Integer.parseInt(one_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return oboard;
	}

	
	
	//noticeboard 테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return oboardDao.selectAll();
	}

	
	
	//게시글 상세 조회
	
	@Override
	public OneAndBoard view(OneAndBoard oboardView) {
	
		//상세글 반환
		return oboardDao.selectOneBoardByOneno(oboardView);
	}

	
	//요청파라미터에서 curPage 반환
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//요청파라미터 curPage 받기
		String param = req.getParameter("curPage");
	
		//null이나 ""이 아니면 int로 리턴
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null이나 ""면 0으로 반환하기
		return 0;
	}


	//총 게시글 수 얻기
	@Override
	public int getTotalCount() {
		return oboardDao.selectCntOneBoard();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return oboardDao.selectPaginglist(paging);
	}

	
	@Override
	public void update(OneAndBoard oboardupdate) {
		
		oboardDao.oneAndBoardUpdate(oboardupdate);
    }

	@Override
	public List<OneAndBoard> getSearch(String type, String word) {
		
		return oboardDao.search(type, word);
	}



}













