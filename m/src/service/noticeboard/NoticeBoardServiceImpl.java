package service.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.noticeboard.NoticeBoardDao;
import dao.admin.noticeboard.NoticeBoardDaoImpl;
import dto.NoticeBoard;
import util.Paging;

public class NoticeBoardServiceImpl implements NoticeBoardService {

	private NoticeBoardDao nboardDao = new NoticeBoardDaoImpl();

	@Override
	public NoticeBoard getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		NoticeBoard nboard = new NoticeBoard();
		
		//요청파라미터 받기
		String nb_no= req.getParameter("nb_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( nb_no!= null && !"".equals(nb_no) ) {
			nboard.setNb_no(Integer.parseInt(nb_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return nboard;
	}

	
	
	//noticeboard 테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return nboardDao.selectAll();
	}

	
	
	//게시글 상세 조회
	//	조회된 게시글의 조회수도 증가시킨다
	@Override
	public NoticeBoard view(NoticeBoard nboardView) {
		//조회수 증가
		nboardDao.updateCount(nboardView);
		
		//상세글 반환
		return nboardDao.selectBoardByBoardno(nboardView);
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
		return nboardDao.selectCntBoard();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return nboardDao.selectPaginglist(paging);
	}



	@Override
	public int delete(NoticeBoard nboarddel) {
		
     return nboardDao.delectNboardByNboardno(nboarddel);
	}



	@Override
	public void insert(NoticeBoard nboard) {
		
		nboardDao.noticeBoardInsert(nboard);
	}



	@Override
	public void update(NoticeBoard nboardUpdate) {
		
		nboardDao.update(nboardUpdate);
		
	}



	@Override
	public List<NoticeBoard> getSearch(String type, String word) {
		
		return nboardDao.search(type,word);
	}

}

















