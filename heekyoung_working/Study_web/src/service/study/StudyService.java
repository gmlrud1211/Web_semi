package service.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.study.StudyDaoImpl;
import dto.Study;
import dto.StudyCategory;

public interface StudyService{
	
	//요청파라미터 처리
	public Study getParam(HttpServletRequest req, HttpServletResponse resp);

	//스터디 개설(등록)
	public Study studyopen(Study study);

	//스터디 카테고리 가져옴
	//public int getCategory();
		
	//스터디 세부카테고리()
	//public List getList();
}