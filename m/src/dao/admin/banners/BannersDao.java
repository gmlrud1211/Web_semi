package dao.admin.banners;

import java.util.List;

import dto.Banners;
import dto.Board;
import dto.FileUpload;
import util.Paging;

public interface BannersDao {

	//��� ��ü ��ȸ
	public List selectAll();

	
	//��� ����
	public Banners selectBannersByBannersno(Banners bannersview);
	
	//��� ���� ��ȯ
	public int deleteBannerByBannerno(Banners bannerdel);
	
	//�� ��� �� ��ȯ
	public int selectCntBanner();
	
	//����¡ ó�� �Խñ� ��ȯ
	public List selectPaginglist(Paging paging);
		
	//��ʵ��
	public void bannersInsert(Banners bannersInsert);
	
	//��ʹ�ȣ ��������
	public int getBanners_no();
	
	//���� ������Ʈ
	public void updateFile(FileUpload fileupload);
	
}
















