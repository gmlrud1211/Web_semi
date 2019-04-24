package controller.schedule;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Schedule;
import service.schedule.ScheduleService;
import service.schedule.ScheduleServiceImpl;

@WebServlet("/ajax/schedule")
public class AjaxScheduleController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private ScheduleService scheService = new ScheduleServiceImpl();
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");

       System.out.println(req.getParameter("title"));
      Schedule sche = new Schedule();
      
//      int no = Integer.parseInt(req.getParameter("calendar_no"));
      String title =(String) req.getParameter("title");
      String content =(String) req.getParameter("content");
      
      String start= (String) req.getParameter("start");
      String end= (String)req.getParameter("end");
      
      double lat = Double.parseDouble(req.getParameter("placeLat"));
      double lng = Double.parseDouble(req.getParameter("placeLng"));
      String place = (String)req.getParameter("placeTitle");
      String address = (String)req.getParameter("placeAddress");
      
      HttpSession httpsession = req.getSession(true);
      httpsession.getAttribute("u_name");
      System.out.println("세션 로그인 한 이름  : " + httpsession.getAttribute("u_name"));
      
      String s_cname = (String)(httpsession.getAttribute("u_name"));
      

//      System.out.println(no);
      System.out.println(title);
      System.out.println(content);
      System.out.println(start);
      System.out.println(end);
      System.out.println(place);
      System.out.println(address);
      System.out.println(lat);
      System.out.println(lng);
      
      System.out.println(s_cname);
      
      
      sche.setS_title(title);
      sche.setS_content(content);
      sche.setS_start(start);
      sche.setS_end(end);
      
      sche.setS_place(place);
      sche.setP_address(address);
      sche.setP_lat(lat);
      sche.setP_lng(lng);
      
      sche.setS_cname(s_cname);
      
      scheService.Insert(sche);
      
      
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("/ajax/schedule [GET] ?룞?옉");
       
       Schedule sche = new Schedule();
      
//       req.getSession().setAttribute("u_no", sche.get);

         
      
      doPost(req, resp);
      
   }
   
}











