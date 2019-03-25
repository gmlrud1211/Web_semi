package dao.study;

import java.util.List;

import dto.FileUpload;
import dto.Study;

public interface StudyDao {

	//스터디 정보 등록
	public void studyopen(Study study);

	//스터디 번호 조회
	public int getStudy_no();

	//파일업로드
	public void updateFile(FileUpload fileupload);
	
	//스터디 카테고리 세부 번호 조회
	public List selectCate(int cate_no, String str);

	
}
