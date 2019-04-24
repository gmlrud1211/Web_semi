package dao.schedule;

import java.util.List;

import dto.Faq;
import dto.Schedule;

public interface ScheduleDao {

	// faq ��ü ��ȸ
	public List<Schedule> selectAll();


	// �������� ��ȯ
	public int scheDelect(Schedule schedel) ;


	// ���� ���
	public void scheInsert(Schedule scheinsert);


	
	// yn start ----------------------------------------
	public Schedule selectLatestSchedule(int study_no);
	
	public int getDday(int study_no);
	// -------------------------------------------------

}
