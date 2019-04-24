package controller.mypage.bookmark;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dto.Bookmark;
import service.mypage.bookmark.BookmarkService;
import service.mypage.bookmark.BookmarkServiceImpl;
import service.study.DetailStudyService;
import service.study.DetailStudyServiceImpl;

@WebServlet("/mypage/bookmark/insert")
public class BookmarkInsertController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private BookmarkService bServ = new BookmarkServiceImpl();
   private DetailStudyService detailStudy = new DetailStudyServiceImpl();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      Bookmark bmark = new Bookmark();   
      
      HttpSession session = req.getSession(true);
      int u_no = (int)session.getAttribute("u_no");
      int study_no = (Integer.parseInt(req.getParameter("study_no")));
      
      
      boolean isBookmark = detailStudy.getDuplicated(study_no, u_no);
      
      System.out.println("북마크 인서트 유저넘 "+u_no);
      System.out.println("북마크 인서트 스터디넘 "+study_no);
      
      
      bmark.setU_no(u_no);
      bmark.setStudy_no(study_no);
      //AJAX처리할 부분(삭제까지 한꺼번에 처리)
      if(isBookmark) {
         //찜안했을때
         //삽입
         bServ.insertBookmark(bmark);
         String alert1 = "찜완료!!";
         String comment = "취소하기";
         @SuppressWarnings("deprecation")
         JSONObject obj = new JSONObject();
          obj.put("like",alert1);
          obj.put("comment",comment);
           
           resp.setContentType("application/x-json; charset=UTF-8");
           resp.getWriter().print(obj);
      }else {
         //찜했을때
         //삭제
         bServ.deleteBookmark(bmark);
         String alert1 = "찜 취소!!";
         String comment = "찜하기";
         @SuppressWarnings("deprecation")
         JSONObject obj = new JSONObject();
          obj.put("like",alert1);
          obj.put("comment",comment);
           
          resp.setContentType("application/x-json; charset=UTF-8");
          resp.getWriter().print(obj);
         
      }
      System.out.println("BookmarkInsertController: "+isBookmark);
      
      
      

   }

}