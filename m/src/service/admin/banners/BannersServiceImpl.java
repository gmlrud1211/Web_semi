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
		
		//��û�Ķ���� ������ ������ DTO��ü
		Banners banners = new Banners();
		
		//��û�Ķ���� �ޱ�
		String bn_no= req.getParameter("bn_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( bn_no!= null && !"".equals(bn_no) ) {
			banners.setBn_no(Integer.parseInt(bn_no));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return banners;
	}

	
	
	//��� ���̺� ��ü ��ȸ��� ��ȯ
	@Override
	public List getList() {
		return bannersDao.selectAll();
	}

	
	
	
	//��û�Ķ���Ϳ��� curPage ��ȯ
	@Override
	public int getCurPage(HttpServletRequest req) {
		
		//��û�Ķ���� curPage �ޱ�
		String param = req.getParameter("curPage");
	
		//null�̳� ""�� �ƴϸ� int�� ����
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null�̳� ""�� 0���� ��ȯ�ϱ�
		return 0;
	}


	//�� �Խñ� �� ���
	@Override
	public int getTotalCount() {
		return bannersDao.selectCntBanner();
	}

	
	//����¡ ����Ʈ ���
	@Override
	public List getPagingList(Paging paging) {
		return bannersDao.selectPaginglist(paging);
	}


    //��ʻ���
	@Override
	public int delete(Banners bannerDel) {

		return bannersDao.deleteBannerByBannerno(bannerDel);
	}


	//��ʵ��
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

















