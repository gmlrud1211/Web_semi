package service.admin.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.report.ReportDao;
import dao.admin.report.ReportDaoImpl;
import dto.Board;
import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public class ReportServiceImpl implements ReportService {

	private ReportDao reportDao = new ReportDaoImpl();

	@Override
	public Report getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Report report = new Report();
		
		//요청파라미터 받기
		String rp_no= req.getParameter("rp_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( rp_no!= null && !"".equals(rp_no) ) {
			report.setRp_no(Integer.parseInt(rp_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return report;
	}

	
	
	//noticeboard 테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return reportDao.selectAll();
	}

	
	
	//게시글 상세 조회
	@Override
	public Report view(Report reportview) {
		
		
		//상세글 반환
		return reportDao.selectReportByReportno(reportview);
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
		return reportDao.selectCntReport();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return reportDao.selectPaginglist(paging);
	}



	@Override
	public int delete(Report reportdel) {

		return reportDao.deleteReportByReportno(reportdel);
	}


	@Override
	public List<Report> getSearch(String type, String word) {
		
		return reportDao.search(type, word);
	}



	@Override
	public void update(Report reportup) {
	   reportDao.updateStatus(reportup);
		
	}

	
}

















