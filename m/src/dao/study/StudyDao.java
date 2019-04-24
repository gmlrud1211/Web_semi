
package dao.study;


import dto.FileUpload;
import java.util.List;
import dto.Study;
import dto.StudyCategory;

public interface StudyDao {

	public List<StudyCategory> getCategory();

	public List<Study> getStudyList();
	
	public List<Study> getMyStudy(int u_no);

	public List<Study> getHurryStudy();

	public List<Study> getCateStudyList(int category_code);
  
  
	// 희경 start --------------------------
	
	//스터디 정보 등록
	public void studyopen(Study study,int study_no);

	//스터디 번호 조회
	public int getStudy_no();

	//파일업로드
	public void updateFile(FileUpload fileupload);

	
	//모집중인 스터디 추가(내가팀장)
	public void insertTeamState(Study study,int study_no);
	
	//스터디 카테고리 번호 조회
	//public int selectCate();

	//희경 end------------------------------

}

