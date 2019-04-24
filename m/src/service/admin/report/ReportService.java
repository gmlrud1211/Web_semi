package service.admin.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public interface ReportService {

	//요청파라미터 데이터를 객체화하여 반환
	public Report getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//신고 전체 조회
	public List getList();
	
	//신고게시글 상세 조회
	public Report view(Report reportview);
	
    //신고 게시글 삭제 
	public int delete(Report reportup);
	
	//신고처리상태 업데이트
	public void update(Report reportup);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	//신고글 검색 
	public List<Report> getSearch(String type, String word);
	
}

















