package dao.admin.banners;

import java.util.List;

import dto.Banners;
import dto.Board;
import dto.FileUpload;
import util.Paging;

public interface BannersDao {

	//배너 전체 조회
	public List selectAll();

	
	//배너 보기
	public Banners selectBannersByBannersno(Banners bannersview);
	
	//배너 삭제 반환
	public int deleteBannerByBannerno(Banners bannerdel);
	
	//총 배너 수 반환
	public int selectCntBanner();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
		
	//배너등록
	public void bannersInsert(Banners bannersInsert);
	
	//배너번호 가져오기
	public int getBanners_no();
	
	//파일 업데이트
	public void updateFile(FileUpload fileupload);
	
}
















