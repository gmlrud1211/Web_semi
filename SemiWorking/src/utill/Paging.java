package utill;

public class Paging {

	private int curPage; // ���� ������ ��ȣ (������ ������)
	
	private int totalCount; // �� �Խñ� �� (DB ��ȸ ����� ����)
	private int listCount; // �� �������� ��µ� �Խñ� �� (���� ������)
	private int totalPage; // �� ������ �� (������� �˾Ƴ�)
	
	private int pageCount; // �� ȭ�鿡 ��µ� ������ �� (���� ������)
	private int startPage; // ȭ�鿡 ���̴� ���� ������ (������� �˾Ƴ�)
	private int endPage; // ȭ�鿡 ���̴� �� ������ (������� �˾Ƴ�)
	
	private int startNo; // �Խñ� ���۹�ȣ (������� �˾Ƴ�)
	private int endNo; // �Խñ� �� ��ȣ (������� �˾Ƴ�)
	
	// �� �Խñ� ���� �Է��ϴ� ������
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}
	
	// �� �Խñ� ��, ���� ������ �Է��ϴ� ������
	public Paging(int totalCount, int curPage) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}
	
	// �� �Խñ� ��, ���� ������, ������ �� �Խñ� �� �Է��ϴ� ������
	public Paging(int totalCount, int curPage, int listCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		
		makePaging();
	}
	
	// �� �Խñ� ��, ���� ������, ������ �� �Խñ� ��, ������ ī��Ʈ �Է��ϴ� ������
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		this.setPageCount(pageCount);
			
		makePaging();
	}
	
	
	private void makePaging() {
		if(totalCount == 0) return; // �Խñ��� ���� ��� �ߴ�
		
		// �⺻�� ����
		if(curPage == 0) setCurPage(1); // ù�������� ����
		if(listCount == 0) setListCount(10); // �Խñ� 10���� ����
		if(pageCount == 0) setPageCount(10); // ����¡ 10���� ����
		
		
		// �� ����¡ �� ���
		totalPage = totalCount / listCount;
		if( totalCount % listCount >0) totalPage++;
		
		// ���� �������� �� ���������� ũ�� �ԷµǸ� ������ ������ �������� ����
		if(totalPage < curPage) curPage = totalPage;
		
		// ȭ�鿡 ���̴� ���������� & �� ������ ��ȣ ���
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// ���������� ���� �������� totalPage���� Ŀ����� ������ ���������������� ���̵��� ����
		if(endPage>totalPage) endPage = totalPage;

		// ȭ�鿡 ���̴� ���� �Խñ� & �� �Խñ� ��ȣ ���
		startNo = (curPage-1)*listCount+1;
		endNo = curPage*listCount;


	}
	
	
	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
				+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startNo=" + startNo + ", endNo=" + endNo + "]";
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getStartNo() {
		return startNo;
	}


	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}


	public int getEndNo() {
		return endNo;
	}


	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
	
}
