package controller.board;

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

import dao.File.FileDao;
import dao.File.FileDaoImpl;
import dto.FileUpload;
import dto.UploadFile;

@WebServlet("/board/fileupload")
public class BoardFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/board/filenewtab.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		//파일업로드 설정 정보
		String saveDirectory = context.getRealPath("/cos/upload");
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//파일업로드
		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy );

		FileDao dao = new FileDaoImpl(); 

		//파일번호얻기
		int fileno = dao.getFileno(); 
		
		//파일 정보
		FileUpload file = new FileUpload();
		file.setFile_no(fileno);
		file.setFile_originname(mul.getOriginalFileName("upfile"));
		file.setFile_storedname(mul.getFilesystemName("upfile"));
		file.setFut_code(1);
		
		//파일삽입
		dao.insertFile(file);

		//파일정보를 부모창에 전달하며 팝업닫기
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("<html><head><meta charset=\"UTF-8\"></head><script type='text/javascript'>window.onload = function() {opener.sendData("+file.getFile_no()+",'"+file.getFile_originname()+"');  window.close();}</script></html>");
	
	}
}
