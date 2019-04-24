package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Achive;
import dto.AchivePeople;
import dto.Study;
import dto.StudyTeamState;
import dto.UserStudy;
import util.Paging;

public interface TeamService {

	// yn begin -----------------------------------
	
	// 팀원정보 가져오기
	public List getTeammate(int study_no);
	
	// 스터디 정보 가져오기
	public Study getStudy(int study_no);
	

	// yn end -----------------------------------
	
	
	//희경 start ---------------------------------
	//curPage 반환
		public int getCurPage(HttpServletRequest req);
		
		//총 게시글 수 얻기
		public int getTotalCount();
			
		//페이징 리스트 얻기
		public List getPagingList(Paging paging);

		
		//Achive에대한 요청 파라미터 처리
		public Achive getParam(HttpServletRequest req, HttpServletResponse resp);

		//목표 등록
		public void InsertAchive(Achive achive);

		
		//스터디 참여중인 회원 리스트 가져오기
		public List getUserStudyList(StudyTeamState studyTeamState);

		
		//목표 리스트 가져오기
		public List getAchiveList(Achive achive);

		//성취달성 인원에 대한 요청파라미터 처리
		public AchivePeople getAchivePeopleParam(HttpServletRequest req, HttpServletResponse resp);

		//성취 체크
		public AchivePeople checkSubAchive(AchivePeople achivePeople);

		//성취 체크 - jio
		public void checkSubAchive2(AchivePeople achivePeople);

		//대목표-세부목표개수 카운트
		public int getSubAchiveCnt();

		//각 유저가 달성한 세부목표개수
		public int getUserSubAchiveCnt(Achive achive);

		
		//성취맨들 리스트 가져오기 
		public List<AchivePeople> getAchivePeopleList(int u_no);

		
		//스터디원 삭제
		public boolean delete(StudyTeamState userDel);

		//팀원관리 - (스터디당 팀원 조회 필요하여 만듬)
		public StudyTeamState getUserStudyParam(HttpServletRequest request, HttpServletResponse response);
		

		//스터디 정보 수정시에 필요
		public Study getStudyParam(HttpServletRequest req, HttpServletResponse resp);
		
		//스터디 정보 업데이트
		public Study studyUpdate(Study study);

		//희경 end--------------------------------------------------
	
	
	
	
	
	
}
