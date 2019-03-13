package controller.team;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//요청파라미터
		String sb_content = req.getParameter("sb_content");
		String user_no = req.getParameter("u_no");
		
		//파일번호 구하기
		String filenoParam = req.getParameter("fileno");
		int fileno = -1;
		
		if(filenoParam!=null && !"".equals(filenoParam)) {
			fileno = Integer.parseInt(filenoParam);
		}
		
		//게시글 번호 얻기
		int sb_no = teamDao.getSb_no();
		
		//게시글 정보 입력
		StudyBoard studyboard = new StudyBoard();
		studyboard.setSb_no(sb_no);
		studyboard.setSb_content(sb_content);

		//게시글 삽입
		teamDao.insertTeamBoard(studyboard);
		
		/*//파일첨부가 존재하면 처리
		if(fileno != -1) {
			FileUpload fileupload = new FileUpload();
			fileupload.setFile_no(fileno);

			//게시글과 파일을 연결
			teamDao.updateFile(fileupload);
		}*/
	}

}
