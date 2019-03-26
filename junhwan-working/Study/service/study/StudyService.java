package service.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Study;

public interface StudyService {

//	public Study getParam(HttpServletRequest req, HttpServletResponse resp);

	public List getList();

	// CHECK BOX, SELECT한 요청 파라미터 받기
	public Study getParam(HttpServletRequest request, HttpServletResponse response);

	// 조건검색해서 가져온 값 띄워줌
	public List view(Study study);

	public Study getStudy(int study_no);

	public List selectCate(int cate_no);

}
