package service.admin.banners;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.banners.BannersDao;
import dao.admin.banners.BannersDaoImpl;
import dto.Banners;
import dto.FileUpload;
import dto.NoticeBoard;
import dto.Report;
import util.Paging;

public class BannersServiceImpl implements BannersService {

	private BannersDao bannersDao = new BannersDaoImpl();

	@Override
	public Banners getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Banners banners = new Banners();
		
		//요청파라미터 받기
		String bn_no= req.getParameter("bn_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( bn_no!= null && !"".equals(bn_no) ) {
			banners.setBn_no(Integer.parseInt(bn_no));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return banners;
	}

	
	
	//배너 테이블 전체 조회결과 반환
	@Override
	public List getList() {
		return bannersDao.selectAll();
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
		return bannersDao.selectCntBanner();
	}

	
	//페이징 리스트 얻기
	@Override
	public List getPagingList(Paging paging) {
		return bannersDao.selectPaginglist(paging);
	}


    //배너삭제
	@Override
	public int delete(Banners bannerDel) {

		return bannersDao.deleteBannerByBannerno(bannerDel);
	}


	//배너등록
	@Override
	public void insert(Banners bannersInsert) {
		
		bannersDao.bannersInsert(bannersInsert);
	}



	@Override
	public void updateFile(FileUpload fileupload) {
		bannersDao.updateFile(fileupload);
		
	}



	@Override
	public int getBanners_no() {
		
		 return bannersDao.getBanners_no();
	}



	@Override
	public Banners view(Banners bannersview) {
		
		return bannersDao.selectBannersByBannersno(bannersview);
	}
	
}

















