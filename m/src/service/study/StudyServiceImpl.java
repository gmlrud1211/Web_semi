package service.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.study.SearchStudy;
import dao.study.SearchStudyImpl;
import dao.study.StudyDao;
import dao.study.StudyDaoImpl;
import dto.FileUpload;
import dto.Study;
import dto.StudyCate;
import dto.StudyCategory;

public class StudyServiceImpl implements StudyService {
	
	StudyDao stdDao = new StudyDaoImpl();
	
	// DAO객체
	 SearchStudy search = new SearchStudyImpl();

	// 대분류 정보 가져오기
	@Override
	public List<StudyCategory> getCategory() {
		 return stdDao.getCategory();
	}
	
	// 나의 맞춤 스터디 가져오기
	@Override
	public List<Study> getMyStudy(int u_no) {
		return stdDao.getMyStudy(u_no);
	}

	// 모집마감 임박 스터디 가져오기
	@Override
	public List<Study> getHurryStudy() {
		return stdDao.getHurryStudy();
	}

	@Override
	public List<Study> getCateStudyList(int category_code) {
		return stdDao.getCateStudyList(category_code);
	}
	
	@Override
	public List getList() {
		return search.selectAll();
	}

	// 조건검색
	@Override
	public Study getConditionedParam(HttpServletRequest request, HttpServletResponse response) {

		// 요청 파라미터 정보를 저장할 객체
		Study study = new Study();
//		String cateCode = request.getParameter("cateCode");
		// 카테고리코드, 지역, 시간, 성별 ( 요청 파라미터 받기 )
		
		
		//cateCode가  널이나  빈값으로  들어오면  -1로 ( 인티저  파스인트로  인트형으로  바꿔줄수있는  숫자형데이터로, -1은  아무  기능도  실행되지  않음) 변환  
//		if(cateCode.equals("") || cateCode == null) {	
//			cateCode="-1";		
//			study.setSt_code(Integer.parseInt(cateCode));
//			System.out.println("test" + cateCode);
//		}else {
//			study.setSt_code(Integer.parseInt(cateCode));
//			System.out.println("test" + cateCode);
//		}
		
		
		String selRegion = request.getParameter("selRegion");
		String time = request.getParameter("time");
		String gender = request.getParameter("gender");

		if("강남".equals(selRegion)) {
			System.out.println("강남을 선택할때만 출력");
		}	
		
		
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
//		search.selectDetail(study);
//		System.out.println("List view : " + search.selectDetail(study));
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
  
    	// 희경 start --------------------------
		
	@Override
	public Study getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		Study study = new Study();
	
		String study_name =(String)req.getParameter("study_name");
		int st_code = Integer.parseInt(req.getParameter("st_code"));
		//int file_no = Integer.parseInt(req.getParameter("file_no"));
		String study_region =(String)req.getParameter("study_region");
		String study_time =(String)req.getParameter("study_time");
		String study_freq =(String)req.getParameter("study_freq");
		int study_min = Integer.parseInt(req.getParameter("study_min"));
		int study_max = Integer.parseInt(req.getParameter("study_max"));
		String study_gender =(String)req.getParameter("study_gender");
		String study_opendate =(String)req.getParameter("study_opendate");
		String study_period = (String)req.getParameter("study_period");
		String study_detail =(String)req.getParameter("study_detail");
	
		HttpSession session = req.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); 
				
		
		study.setStudy_name(study_name);
		study.setSt_code(st_code);
		//study.setFile_no(file_no);
		study.setStudy_region(study_region);
		study.setStudy_time(study_time);
		study.setStudy_freq(study_freq);
		study.setStudy_min(study_min);
		study.setStudy_max(study_max);
		study.setStudy_gender(study_gender);
		study.setStudy_opendate(study_opendate);
		study.setStudy_period(study_period);
		study.setStudy_details(study_detail);
		study.setU_no(u_no);


		return study;
	}

	@Override
	public Study studyopen(Study study) {
		int study_no = stdDao.getStudy_no(); 
		System.out.println(study_no);
		stdDao.studyopen(study,study_no);
		stdDao.insertTeamState(study, study_no);
		return study;

	}

	@Override
	public void updateFile(FileUpload fileupload) {
		stdDao.updateFile(fileupload);
		
	}

	@Override
	public int getStudy_no() {
		return stdDao.getStudy_no();
	}

	//희경 end--------------------------
  
}

