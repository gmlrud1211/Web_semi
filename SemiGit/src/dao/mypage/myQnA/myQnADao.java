package dao.mypage.myQnA;

import java.util.List;

import dto.FileUpload;
import dto.QnA;
import util.Paging;

public interface myQnADao {

//	public List selectQnAListByUno(int u_no);
	
	public QnA selectQnAByOneno(int one_no); 
	
	public void insertQnA(QnA qna);
	
	public void deleteQnA(int one_no);
	
	public void answerQnA(QnA qna);
	
	// �� �ۼ� �Խñ� �� ��ȯ
	public int cntMyQnA(int u_no);
		
	// ����ں� �ۼ� �Խñ� ����¡ ó�� ����Ʈ ��ȯ
	public List selectMyQnAPagingList(int u_no, Paging paging);
	
	//시퀀스에서 게시글 번호 얻기
	public int getQnA_no();
	
	public void updateFile(FileUpload fileupload);
	
	public FileUpload selectFileByFileno(int file_no);
	
}
