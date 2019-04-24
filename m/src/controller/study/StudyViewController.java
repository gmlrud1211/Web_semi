package controller.study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Study;
import dto.StudyCate;
import service.study.StudyService;
import service.study.StudyServiceImpl;

@WebServlet("/study/search")
public class StudyViewController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private StudyService studyService = new StudyServiceImpl();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Study study = new Study();
//      List studyView = studyService.view(study);
      
      int cate_no = Integer.parseInt(request.getParameter("cate"));
      StudyCate studycate = new StudyCate();
      List<StudyCate> studycate1 = studyService.selectCate(cate_no);
      
      
      //페이지 들어올때 카테넘버를 넘겨줌
      request.setAttribute("cate_no", cate_no);
      //페이지에 뿌려질 목록
      request.setAttribute("studycate1", studycate1);
      
      //view지정(카테고리 선택 페이지 시작)
      request.getRequestDispatcher("/view/study/searchStudy.jsp").forward(request, response);
   }

}