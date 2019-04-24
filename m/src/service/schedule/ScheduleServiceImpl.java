package service.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.schedule.ScheduleDao;
import dao.schedule.ScheduleDaoImpl;
import dto.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDao schedao = new ScheduleDaoImpl();
	
	
	@Override
	public Schedule getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//요청파라미터 정보를 저장할 DTO객체
		Schedule sche = new Schedule();
		
		//요청파라미터 받기
		String s_no= req.getParameter("s_no");
		
		//null이나 ""이 아니면 int로 변환하여 DTO에 저장
		if( s_no!= null && !"".equals(s_no) ) {
			sche.setS_no((Integer.parseInt(s_no)));
		}

		//요청파라미터가 객체로 변환된 DTO 반환
		return sche;
	}

	@Override
	public List<Schedule> selectAll() {
		
		return schedao.selectAll();
	}

	

	
	@Override
	public void Insert(Schedule scheinsert) {
		
		schedao.scheInsert(scheinsert);
	}

	@Override
	public int delete(Schedule schedel) {
	    
		return schedao.scheDelect(schedel);
	}

	// yn start -------------------------------------
		@Override
		public Schedule getLatestSchedule(int study_no) {
			
			return schedao.selectLatestSchedule(study_no);
		}

		@Override
		public int getDday(int study_no) {
			return schedao.getDday(study_no);
		}
		
		//--------------------------------------------------




}
