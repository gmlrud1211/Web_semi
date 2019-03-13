package dao.file;

import dto.FileUpload;

public interface FileDao {
		//시퀀스에서 파일 번호 얻기
		public int getFileno();
		
		//파일 삽입
		public void insertFile(FileUpload file);

}
