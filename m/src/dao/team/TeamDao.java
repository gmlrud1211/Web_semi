package dao.team;

import java.util.List;

import dto.Achive;
import dto.AchivePeople;
import dto.FileUpload;
import dto.Study;
import dto.StudyBoard;
import dto.StudyTeamState;
import dto.SubAchive;
import dto.UserStudy;
import util.Paging;

public interface TeamDao {

	// yn begin -----------------------------------
	
	//팀원 조회
	public List selectTeammate(int study_no);
	
	//스터디 정보 조회
	public Study selectStudy(int study_no);

	
	// yn end -----------------------------------
	
	// 희경 begin--------------------------------
	
	//총게시글 수 반환
		public int selectCntTeamBoard();

		//페이징처리된 게시글 목록 조회
		public List selectPagingList(Paging paging);

		//시퀀스에서 게시글 번호 얻기
		public int getSb_no();
		
		//게시글 삽입
		public void insertTeamBoard(StudyBoard board);
			
		//삽입된 파일에 게시글번호 입력하기
		public void updateFile(FileUpload fileupload);

		//다운받을 파일 선택
		public FileUpload selectByFileno(int file_no);
		
		//새 목표 등록
		public Achive insertAchive(Achive achive);
		
		//스터디 번호 조회
		public int getStudy_no(Study study);

		//유저가 참여중인 스터디 조회
		public List userStudySelectAll(StudyTeamState studyTeamState);

		//목표조회
		public List achiveSelectAll(Achive achive);

		//목표달성한 사람 체크
		public void checkSubAchive(AchivePeople achivePeople);

		//목표달성한 사람 체크 - jio
		public void insertCheckSubAchive(AchivePeople achivePeople);

		//목표달성한 사람 체크해제 - jio
		public void deleteCheckSubAchive(AchivePeople achivePeople);
		
		//세부목표 등록
		public void insertSubAchive(Achive achive);

		//목표번호 얻어오기
		public int getA_no(Achive achive);

		//원래 대목표에 각 세부목표 개수 얻어오기
		public int selectSubAchiveCnt();

		//유저가 달성한 세부목표 개수
		public int selectUserSubAchiveCnt(Achive achive);

		
		//성취인간들 조회
		public List<AchivePeople> selectAchivePeopleList(int u_no);

		
		//스터디원 삭제(방출)
		public boolean deleteUserStudyByUserno(StudyTeamState userDel);


		//스터디 정보 업데이트
		public void studyUpdate(Study study);
		
		//희경 end-----------------------------------------------
	
	
	
	
	
}

