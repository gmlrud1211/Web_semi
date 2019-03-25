package service.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.study.StudyDao;
import dao.study.StudyDaoImpl;
import dto.FileUpload;
import dto.Study;
import dto.StudyCate;

public class StudyServiceImpl implements StudyService {

	private StudyDao studyDao = new StudyDaoImpl();
	
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
		
		
		/*
			int cate_no = Integer.parseInt(req.getParameter("cate_no"));
			StudyCate studycate = new StudyCate();
			List<StudyCate> studycate1 = studyservice.selectCate(cate_no);
			
			req.setAttribute("cate_no", cate_no);
			req.setAttribute("studycate1", studycate1);
		 */
		
		return study;
	}

	@Override
	public Study studyopen(Study study) {
		studyDao.studyopen(study);
		
		
		return study;

	}

	@Override
	public void updateFile(FileUpload fileupload) {
		studyDao.updateFile(fileupload);
		
	}

	@Override
	public int getStudy_no() {
		return studyDao.getStudy_no();
	}

	@Override
	public List selectCate(int cate_no) {
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
	         L1 = studyDao.selectCate(cate_no,s1);
	         
	      }else if(cate_no == 2) {
	         L1 = studyDao.selectCate(cate_no,s2);
	      }
	      else if(cate_no == 3) {
	         L1 = studyDao.selectCate(cate_no,s3);
	      }
	      else if(cate_no == 4) {
	         L1 = studyDao.selectCate(cate_no,s4);
	      }
	      else if(cate_no == 5) {
	         L1 = studyDao.selectCate(cate_no,s5);
	      }
	      else if(cate_no == 6) {
	         L1 = studyDao.selectCate(cate_no,s6);
	      }
	      else if(cate_no == 7) {
	         L1 = studyDao.selectCate(cate_no,s7);
	      }
	      else if(cate_no == 8) {
	         L1 = studyDao.selectCate(cate_no,s8);
	      }
	      else if(cate_no == 9) {
	         L1 = studyDao.selectCate(cate_no,s9);
	      }
	      return L1;
	   
	   }

	
}
