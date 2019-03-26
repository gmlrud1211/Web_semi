package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.Study;
import dto.StudyCategory;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.study.StudyService;
import service.study.StudyServiceImpl;


@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudyService stdService = new StudyServiceImpl();
	BoardService boardService = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* 카테고리 별 최신 카테고리 */
		
		// 탭으로 사용할 대분류 가져오기
		List<StudyCategory> cateList = stdService.getCategory();
		request.setAttribute("cateList", cateList);
		
		// 초기 스터디 정보 가져오기 (1-it프로그래밍 카테고리)
		List<Study> studyList = stdService.getCateStudyList(1);
		request.setAttribute("StudyList_cate", studyList);
		
		/* 나의 맞춤 카테고리 */

		// 세션처리 추가 필요함
		// String u_no = request.getSession().getAttribute("u_no");
		List<Study> myStudy = stdService.getMyStudy(149);
		request.setAttribute("myStudy", myStudy);

		/* 모집마감 임박 스터디 */
		
		List<Study> hurryStudy = stdService.getHurryStudy();
		request.setAttribute("hurryStudy", hurryStudy);
		
		
		/* 베스트 게시글 */
		List<Board> bestBoard = boardService.getBestBoard();
		request.setAttribute("bestBoard", bestBoard);
		
		// 페이지 지정
		request.getRequestDispatcher("/view/main.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
