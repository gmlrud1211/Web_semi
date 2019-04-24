package dao.study;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dto.Study;

public interface SearchStudy {
	public List selectAll();

	// 조건검색
	public List selectDetail(Study study);

	public Study selectStudy(int study_no);

	public List selectCate(int cate_no, String str);
	
	
}