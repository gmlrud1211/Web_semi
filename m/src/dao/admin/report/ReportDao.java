package dao.admin.report;

import java.util.List;

import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public interface ReportDao {

	//신고 전체 조회
	public List selectAll();

	
	//신고상세조회 반환
	public Report selectReportByReportno(Report reportview);
	
	//신고 게시글 삭제 반환
	public int deleteReportByReportno(Report reportdel);
	
	//신고글 클릭시 상태 업데이트 
	public void updateStatus(Report reportup);
	
	//총 게시글 수 반환
	public int selectCntReport();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
	
	//신고글 검색
	public List<Report> search(String type, String word);
		
	
}
















