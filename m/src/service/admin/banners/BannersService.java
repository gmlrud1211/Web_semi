package service.admin.banners;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Banners;
import dto.FileUpload;
import util.Paging;

public interface BannersService {

	//요청파라미터 데이터를 객체화하여 반환
	public Banners getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//배너 전체 조회
	public List getList();

	
    //배너 삭제 
	public int delete(Banners bannerDel);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	//배너등록
	public void insert(Banners bannersInsert);
	
	//첨부파일이 있을경우 파일 업데이트
	public void updateFile(FileUpload fileupload);

	//스터디 번호 가져오기
	public int getBanners_no();
	
	
    //배너 보기
	public Banners view(Banners bannerview);
	
}

















