package controller.schedule;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Schedule;
import service.schedule.ScheduleService;
import service.schedule.ScheduleServiceImpl;

@WebServlet("/schedule/list")
public class ScheduleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ScheduleService scheService = new ScheduleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      //게시글목록 MODEL로 추가
		
			req.setCharacterEncoding("utf-8");

			
			List<Schedule> schedulelist = scheService.selectAll();
			req.setAttribute("schedulelist", schedulelist);
			
			System.out.println(schedulelist);
			
			List list = new ArrayList();
			for( Schedule s : schedulelist ) {
				Map map = new HashMap();
				map.put("title", s.getS_title());
				map.put("start", s.getS_start().split(" ")[0]);
				map.put("end", s.getS_end().split(" ")[0]);
				map.put("no", String.valueOf(s.getS_no()));
				
				list.add(map);
			}
			Gson gson = new Gson();
			req.setAttribute("list", gson.toJson(list));
			
			System.out.println(list);
			
			//VIEW지정
			req.getRequestDispatcher("/view/team/fullcalendar.jsp")
				.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
	
}









