package controller.schedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dto.Schedule;
import service.schedule.ScheduleService;
import service.schedule.ScheduleServiceImpl;

@WebServlet("/schedule/delete")
public class AcheduleDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ScheduleService scheService = new ScheduleServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

//		Schedule sche = scheService.getParam(req, resp);
		Schedule sche = new Schedule();
		sche.setS_no(Integer.parseInt(req.getParameter("c_id")));
		
//		int s_no = Integer.parseInt(req.getParameter("s_no"));
//		
//		sche.setS_no(s_no);
	
//		HttpSession httpsession = req.getSession(true);
//		httpsession.getAttribute("s_no");
//		
//		System.out.println("sadsaddsdas" + httpsession.getAttribute("s_no"));
		
		
		
		int result = scheService.delete(sche);
		
		Gson gson = new Gson();
		req.setAttribute("list", gson.toJson(result));
		
		System.out.println(result);
		
		//VIEWÁöÁ¤
		req.getRequestDispatcher("/view/team/fullcalendar.jsp")
			.forward(req, resp);
		
		
	
		
		

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/ajax/schedule [GET] ");
		 
		

		
		
		
		doPost(req, resp);
		
	
		
	}

}






