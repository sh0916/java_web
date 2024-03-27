package download;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import login.LoginDTO;
import register.RegisterDAO;
import register.RegisterDTO;

public class Upload {

	public RegisterDTO uploding(HttpServletRequest request) {
		
		String encoding = "utf-8";
		RegisterDTO registerDTO = new RegisterDTO();
		
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
					
					if(fileItem.getFieldName().equals("userId")) {
						registerDTO.setUserId(fileItem.getString());
					} else if(fileItem.getFieldName().equals("userPass")) {
						registerDTO.setUserPass(fileItem.getString());
					}		
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
						
						registerDTO.setImgName(fileName);
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						File uploadFile = new File(currentDirPath + File.separator + fileName);
//						File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return registerDTO;
	}
}
