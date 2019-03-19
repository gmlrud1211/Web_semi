package controller.mypage.myQnA;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.file.FileDao;
import dao.file.FileDaoImpl;
import dto.FileUpload;


@WebServlet("/mypage/myqna/fileupload")
public class MyQnAFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/mypage/myQnA/qnaFile.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		//파일업로드 설정 정보
		String saveDirectory = context.getRealPath("/cos/upload");
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//파일업로드
		MultipartRequest mul = new MultipartRequest(
				request,
				saveDirectory,
				maxPostSize,
				encoding,
				policy );
		
		 FileDao filedao = new FileDaoImpl(); 

		//파일번호얻기
		int fileno = filedao.getFileno(); 
		
		//파일 정보
		FileUpload file = new FileUpload();
		file.setFile_no(fileno);
		file.setFile_originname(mul.getOriginalFileName("upfile"));
		file.setFile_storedname(mul.getFilesystemName("upfile"));
//		System.out.println(request.getRequestURI());
		file.setFut_code(3);
		
		//파일삽입
		filedao.insertFile(file);

		//파일정보를 부모창에 전달하며 팝업닫기
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("<html><head><meta charset=\"UTF-8\"></head><script type='text/javascript'>window.onload = function() {opener.sendData("+file.getFile_no()+",'"+file.getFile_originname()+"');  window.close();}</script></html>");

	}

}
