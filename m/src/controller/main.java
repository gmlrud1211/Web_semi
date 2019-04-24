package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Banners;
import dto.Board;
import dto.Study;
import dto.StudyCategory;
import service.admin.banners.BannersService;
import service.admin.banners.BannersServiceImpl;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.study.StudyService;
import service.study.StudyServiceImpl;


@WebServlet("/main")
public class main extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	StudyService stdService = new StudyServiceImpl();
	BoardService boardService = new BoardServiceImpl();
	
	private BannersService banService = new BannersServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		boolean login = false;
		if(session.getAttribute("login") != null) {
			login = (boolean) session.getAttribute("login");
		} else {
			login = false;
		}
		
		request.setAttribute("login", login);
		
		/* 移댄뀒怨좊━ 蹂� 理쒖떊 移댄뀒怨좊━ */
		
		//배너 목록 MODEL로 추가
		List<Banners> bannerlist =  banService.getList();
		request.setAttribute("bannerlist", bannerlist);
		
		System.out.println(bannerlist);
				
		
		// �꺆�쑝濡� �궗�슜�븷 ��遺꾨쪟 媛��졇�삤湲�
		List<StudyCategory> cateList = stdService.getCategory();
		request.setAttribute("cateList", cateList);
		
		// 珥덇린 �뒪�꽣�뵒 �젙蹂� 媛��졇�삤湲� (1-it�봽濡쒓렇�옒諛� 移댄뀒怨좊━)
		List<Study> studyList = stdService.getCateStudyList(1);
		request.setAttribute("StudyList_cate", studyList);
		System.out.println("studyList : "  + studyList);
		
		/* �굹�쓽 留욎땄 移댄뀒怨좊━ */

		if(login) {
			int u_no = (int) session.getAttribute("u_no");		
			List<Study> myStudy = stdService.getMyStudy(u_no);
			request.setAttribute("myStudy", myStudy);
		}

		/* 紐⑥쭛留덇컧 �엫諛� �뒪�꽣�뵒 */
		List<Study> hurryStudy = stdService.getHurryStudy();
		request.setAttribute("hurryStudy", hurryStudy);
		
		/* 踰좎뒪�듃 寃뚯떆湲� */
		List<Board> bestBoard = boardService.getBestBoard();
		request.setAttribute("bestBoard", bestBoard);
		
		// �럹�씠吏� 吏��젙
		request.getRequestDispatcher("/view/main.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
