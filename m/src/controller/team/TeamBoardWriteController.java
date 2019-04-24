package controller.team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.team.TeamDao;
import dao.team.TeamDaoImpl;
import dto.FileUpload;
import dto.StudyBoard;

@WebServlet("/team/board/write")
public class TeamBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamDao teamDao = new TeamDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/view/team/teamboardwrite.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(true);
		int u_no = (int)session.getAttribute("u_no");
		
		//요청파라미터
		String sb_content = req.getParameter("sb_content");
//		int study_no = Integer.parseInt(req.getParameter("study_no"));
				
		
		//파일번호 구하기
		String filenoParam = req.getParameter("file_no");
		System.out.println(req.getParameter("file_no"));
		int file_no = -1;
		
		if(filenoParam!=null && !"".equals(filenoParam)) {
			file_no = Integer.parseInt(filenoParam);
			System.out.println("file_no:"+file_no);

		}
		System.out.println("구하기 : "+file_no);
		
		//게시글 번호 얻기
		int sb_no = teamDao.getSb_no();
		
		//게시글 정보 입력
		StudyBoard studyboard = new StudyBoard();
		studyboard.setSb_no(sb_no);
		studyboard.setSb_content(sb_content);
		studyboard.setFile_no(file_no);
//		studyboard.setStudy_no(study_no);
		studyboard.setU_no(u_no);
		
		
		//게시글 삽입
		teamDao.insertTeamBoard(studyboard);
		
		
		System.out.println("게시글 삽입 후 : "+file_no);
		
		 //파일첨부가 존재하면 처리
		if(file_no != -1) {
			FileUpload fileupload = new FileUpload();
			fileupload.setFile_no(file_no);

			//게시글과 파일을 연결
			teamDao.updateFile(fileupload);
		}
		
		System.out.println("파일첨부 존재할 경우 : "+file_no);
		
		
		resp.sendRedirect("/team/board");
		
	}
	

}
