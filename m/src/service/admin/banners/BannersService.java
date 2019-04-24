package service.admin.banners;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Banners;
import dto.FileUpload;
import util.Paging;

public interface BannersService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Banners getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//��� ��ü ��ȸ
	public List getList();

	
    //��� ���� 
	public int delete(Banners bannerDel);

	//��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
	
	//�� �Խñ� �� ���
	public int getTotalCount();
	
	//����¡ ����Ʈ ���
	public List getPagingList(Paging paging);
	
	//��ʵ��
	public void insert(Banners bannersInsert);
	
	//÷�������� ������� ���� ������Ʈ
	public void updateFile(FileUpload fileupload);

	//���͵� ��ȣ ��������
	public int getBanners_no();
	
	
    //��� ����
	public Banners view(Banners bannerview);
	
}

















