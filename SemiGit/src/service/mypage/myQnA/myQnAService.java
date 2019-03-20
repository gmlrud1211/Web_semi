package service.mypage.myQnA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.FileUpload;
import dto.QnA;
import util.Paging;

public interface myQnAService {
	
//public List getQnAListByUno(int u_no);
	
	public QnA getQnAByOneno(int one_no); 
	
	public void writeQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);
	
	// ��û�Ķ���Ϳ��� curPage ��ȯ
	public int getCurPage(HttpServletRequest req);
				
	// �� ���Ǳ� �� ���
	public int getTotalMyQnACount(int u_no);
		
	// ����ں� ���Ǳ� ����¡ ����Ʈ ���
	public List getMyQnAPagingList(int u_no, Paging paging);
	
	//시퀀스에서 게시글 번호 얻기
	public int getQnA_no();

	//삽입된 파일에 게시글번호 입력하기
	public void updateFile(FileUpload fileupload);
	
	//첨부파일 반환
	public FileUpload getFileByFileno(int file_no);
	
}
