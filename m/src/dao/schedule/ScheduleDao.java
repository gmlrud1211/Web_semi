package dao.schedule;

import java.util.List;

import dto.Faq;
import dto.Schedule;

public interface ScheduleDao {

	// faq 전체 조회
	public List<Schedule> selectAll();


	// 일정삭제 반환
	public int scheDelect(Schedule schedel) ;


	// 일정 등록
	public void scheInsert(Schedule scheinsert);


	
	// yn start ----------------------------------------
	public Schedule selectLatestSchedule(int study_no);
	
	public int getDday(int study_no);
	// -------------------------------------------------

}
