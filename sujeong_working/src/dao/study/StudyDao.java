package dao.study;

import java.util.List;

import dto.Study;
import dto.StudyCategory;

public interface StudyDao {

	public List<StudyCategory> getCategory();

	public List<Study> getStudyList();
	
	public List<Study> getMyStudy(int u_no);

	public List<Study> getHurryStudy();

	public List<Study> getCateStudyList(int category_code);

}
