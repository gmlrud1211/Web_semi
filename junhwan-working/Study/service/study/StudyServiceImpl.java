package service.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.study.SearchStudy;
import dao.study.SearchStudyImpl;
import dto.Study;
import dto.StudyCate;

public class StudyServiceImpl implements StudyService {

	// DAO객체
	private SearchStudy search = new SearchStudyImpl();

	@Override
	public List getList() {
		return search.selectAll();
	}

	// 조건검색
	@Override
	public Study getParam(HttpServletRequest request, HttpServletResponse response) {

		// 요청 파라미터 정보를 저장할 객체
		Study study = new Study();

		// 카테고리코드, 지역, 시간, 성별 ( 요청 파라미터 받기 )
		String cateCode = request.getParameter("cateCode");
		String selRegion = request.getParameter("selRegion");
		String time = request.getParameter("time");
		String gender = request.getParameter("gender");

		if("강남".equals(selRegion)) {
			System.out.println("강남을 선택할때만 출력");
		}
		
		study.setSt_code(Integer.parseInt(cateCode));
		System.out.println("test" + cateCode);
		System.out.println("test" + selRegion);
		System.out.println("test" + time);
		System.out.println("test" + gender);

		study.setStudy_region(selRegion);
		study.setStudy_time(time);
		study.setStudy_gender(gender);

		System.out.println("study : "+study);
		return study;
	}

	// 조건검색해서 화면에 보여줄 내용
	@Override
	public List view(Study study) {
		search.selectDetail(study);
		System.out.println("List view : " + search.selectDetail(study));
		return search.selectDetail(study);
	}

	// 매개변수study_no보내서 상세페이지 띄어줄 역할수행
	@Override
	public Study getStudy(int study_no) {
		return search.selectStudy(study_no);
	}

	   @Override
	   public List<StudyCate> selectCate(int cate_no) {
	      List<StudyCate> L1 = null;
	      String s1 = "IT·프로그래밍";
	      String s2 = "디자인";
	      String s3 = "콘텐츠제작";
	      String s4 = "자격증";
	      String s5 = "취업";
	      String s6 = "외국어";
	      String s7 = "음악";
	      String s8 = "뷰티";
	      String s9 = "수능";

	      if(cate_no == 1) {
	         L1 = search.selectCate(cate_no,s1);
	      }else if(cate_no == 2) {
	         L1 = search.selectCate(cate_no,s2);
	      }
	      else if(cate_no == 3) {
	         L1 = search.selectCate(cate_no,s3);
	      }
	      else if(cate_no == 4) {
	         L1 = search.selectCate(cate_no,s4);
	      }
	      else if(cate_no == 5) {
	         L1 = search.selectCate(cate_no,s5);
	      }
	      else if(cate_no == 6) {
	         L1 = search.selectCate(cate_no,s6);
	      }
	      else if(cate_no == 7) {
	         L1 = search.selectCate(cate_no,s7);
	      }
	      else if(cate_no == 8) {
	         L1 = search.selectCate(cate_no,s8);
	      }
	      else if(cate_no == 9) {
	         L1 = search.selectCate(cate_no,s9);
	      }
	      return L1;
	   
	   }


	
}
