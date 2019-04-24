package controller.mypage.mystudy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Study;
import dto.StudyTeamState;
import service.mypage.mystudy.MyStudyService;
import service.mypage.mystudy.MyStudyServiceImpl;

//�궡媛� 留뚮뱺 �뒪�꽣�뵒
@WebServlet("/mypage/mystudy/imade")
public class MadeStudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  MyStudyService mystudyService = new MyStudyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �떊泥� �긽�깭 �젙蹂� �떞�쓣 媛앹껜 �꽑�뼵
		StudyTeamState teamState = new StudyTeamState();
		// u_no �꽭�뀡�쑝濡� 諛쏄퀬(濡쒓렇�씤 �떆) , study_no getParameter濡� 諛쏄린
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		//u_no�쑝濡�  �궡媛�  ���옣�씤  �뒪�꽣�뵒媛�  �엳�뒗吏�  議고쉶!!
		//List<StudyTeamState> sivalList  = mystudyService.getListStudyInfo(u_no);
		List<StudyTeamState> mystudy  = mystudyService.getLeaderStudyInfo(u_no);
		
		request.setAttribute("mystudy", mystudy);
		
		/*
		 * for(int i=0; i<sivalList.size(); i++) { sendList =
		 * (mystudyService.getListStudymember(u_no,sivalList.get(i).getStudy_no()));
		 * //�떊泥��옄由ъ뒪�듃 ���옣媛앹껜 = �떊泥��옄由ъ뒪�듃議고쉶硫붿냼�뱶(u_no (�궗�떎�븘�슂�뾾�쓬 �옒紐삳꽔�쓬) ,
		 * sivalList.get(i).getStudy_no() ( ���옣�씤 �뒪�꽣�뵒媛� �뿬�윭媛� �씪�떆 洹� �뒪�꽣�뵒踰덊샇�뿉 留욌뒗 寃껊쭔 �꽔�뼱以� ) }
		 */
		request.getRequestDispatcher("/view/mypage/mystudy/madeStudyList.jsp").forward(request, response);
		
	}
	
	

}
