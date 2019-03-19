package controller.mypage.myQnA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.FileUpload;
import dto.QnA;
import service.mypage.myQnA.myQnAService;
import service.mypage.myQnA.myQnAServiceImpl;


@WebServlet("/mypage/myqna/ask")
public class MyQnAAskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	myQnAService qnaServ = new myQnAServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		request.setAttribute("u_no", u_no);
		request.getRequestDispatcher("/view/mypage/myQnA/askQnA.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		String one_title= req.getParameter("qnaTitle");
		String one_content = req.getParameter("qnaContent");
		
//		System.out.println("제목"+one_title);
//		System.out.println("내용"+one_content);
		
		//파일번호 구하기
		String filenoParam = req.getParameter("file_no");
//		System.out.println(req.getParameter("file_no"));
		int file_no = -1;
				
		if(filenoParam!=null && !"".equals(filenoParam)) {
			file_no = Integer.parseInt(filenoParam);
//			System.out.println("file_no:"+file_no);

		}
//		System.out.println("구하기 : "+file_no);
		
		// qna 정보 입력
		QnA qna = new QnA();
		qna.setU_no(u_no);
		qna.setOne_title(one_title);
		qna.setOne_content(one_content);
		qna.setFile_no(file_no);
		
		// 게시글 삽입
		qnaServ.writeQnA(qna);
		
//		System.out.println("게시글 삽입 후 : "+file_no);
		
		 //파일첨부가 존재하면 처리
		if(file_no != -1) {
			FileUpload fileupload = new FileUpload();
			fileupload.setFile_no(file_no);

			//게시글과 파일을 연결
			qnaServ.updateFile(fileupload);
		}
		
//		System.out.println("파일첨부 존재할 경우 : "+file_no);
		
		resp.sendRedirect("/mypage/myqna");
		
	}

}
