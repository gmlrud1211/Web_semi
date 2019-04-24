package controller.mypage.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Message;
import dto.Users;
import service.mypage.message.MessageService;
import service.mypage.message.MessageServiceImpl;

@WebServlet("/mypage/message/send")
public class MessageSendController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   MessageService mServ = new MessageServiceImpl();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      Message msg = new Message();
      
      String type = request.getParameter("type");
//      System.out.println(type);
      
      if(type.equals("reply")) {
//         System.out.println("replyaa");
         // ´äÀåÇÒ ¶§
         int m_no = Integer.parseInt(request.getParameter("m_no"));
         msg = mServ.getMsgByMno(m_no);
         
         request.setAttribute("msg", msg);   

         request.getRequestDispatcher("/view/mypage/message/replyMsg.jsp").forward(request, response);

         
         
      } else if(type.equals("send")) {
         // Ã³À½ º¸³¾ ¶§
         HttpSession session = request.getSession(true);
         int sender_no = (int) session.getAttribute("u_no");
         int receiver_no = Integer.parseInt(request.getParameter("receiver_no"));
         Users sender = mServ.getUserName(sender_no);
         Users receiver = mServ.getUserName(receiver_no);
         
         msg.setSender_no(sender_no);
         msg.setSender_name(sender.getU_name());
         msg.setReceiver_no(receiver_no);
         msg.setReceiver_name(receiver.getU_name());
         
         request.setAttribute("msg", msg);   
         request.getRequestDispatcher("/view/mypage/message/sendMsg.jsp").forward(request, response);
      }
      
      

   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("utf-8");
      int sender_no = Integer.parseInt(request.getParameter("sender_no"));
      int receiver_no = Integer.parseInt(request.getParameter("receiver_no"));
      String m_comment = request.getParameter("m_comment");

//      System.out.println("s"+ sender_no);
//      System.out.println("r"+ receiver_no);
//      System.out.println(m_comment);
            
      Message msg = new Message();
      msg.setSender_no(sender_no);
      msg.setReceiver_no(receiver_no);
      msg.setM_comment(m_comment);
      
      mServ.sendMsg(msg);
      
   }

}