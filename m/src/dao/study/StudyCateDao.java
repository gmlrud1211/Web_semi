package dao.study;

import java.util.List;

import dto.Study;

public interface StudyCateDao {

	public List<Study> getCateStudyList(int st_code);
	
}
