package service.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import dto.Report;
import dto.Schedule;

public interface ScheduleService {

	//요청파라미터 데이터를 객체화하여 반환
	public Schedule getParam(HttpServletRequest req, HttpServletResponse resp);
	
	// 일정 전체 조회
	public List<Schedule> selectAll();


	// 일정 삭제 반환
	public int delete(Schedule schedel);
	
	
	// 일정 등록
	public void Insert(Schedule scheinsert);

//	// 일정 수정
//	public void update(Schedule faqup);
	
	// yn start -------------------------------
	public Schedule getLatestSchedule(int study_no);

	public int getDday(int study_no);

	//-------------------------------------

}
