package sec01.ex01.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		
		try {
			// File ; 파일 또는 디렉토리(폴더)를 관리하는 class
			File currentDirPath = new File("C:\\file_repo");
			
			// 세팅
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			// 처리하는 메모리 용량
			factory.setSizeThreshold(1024 * 1024);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 파일의 최대 크기 지정
			upload.setFileSizeMax(1024*1024*100);
			
			// request를 분석하라
			List items = upload.parseRequest(request);
			
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
				// form 요소인지 판별
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
//					// 기존처럼 사용 가능
//					String param1 = request.getParameter("param1");
				} else {
				// file 영역
					System.out.println("param:" + fileItem.getFieldName());
					System.out.println("file name:" + fileItem.getName());
					System.out.println("file size:" + fileItem.getSize() + "Bytes");

					if (fileItem.getSize() > 0) {
						// 아이디어 1 : 파일명을 추출하는 
						int idx = fileItem.getName().lastIndexOf("\\");
						System.out.println("idx : 1 : "+ idx);
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						System.out.println("idx : 2 : "+ idx);
						String fileName = fileItem.getName().substring(idx + 1);
						
						// 아이디어 2 : 파일명 중복 방지
						long timestamp = System.currentTimeMillis();
						fileName = timestamp +"_"+ fileName;
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						File uploadFile = new File(currentDirPath + File.separator + fileName);
//						File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
			
			// 위쪽 for문 안에서 DTO(VO)를 완성하고
			// DB에 저장할 수 있겠다
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
