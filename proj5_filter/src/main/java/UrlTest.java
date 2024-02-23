

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/url/*")

// 어러개의 주소를 담을수있다
//@WebServlet(urlPatterns = {"/url/a", "/url/b"})
public class UrlTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/url/*");
		
		// 요청 url || http://localhost:8080/proj5_filter/url/abc
        StringBuffer url = request.getRequestURL();
        System.out.println("getRequestURL : "+ url);

        // 서버 주소를 제외한 주소 || /proj5_filter/url/abc
        String uri = request.getRequestURI();
        System.out.println("getRequestURI : "+ uri);

        // 어플리케이션(컨텍스트) 경로 || /proj5_filter
        String ctxPath = request.getContextPath();
        System.out.println("getContextPath : "+ ctxPath);

        // 서블릿 경로 || /url
        String srvParh = request.getServletPath();
        System.out.println("getServletPath : "+ srvParh);

        // 요청 파라메터(쿼리 스트링) || num=12&name=asdf
        String qs = request.getQueryString();
        System.out.println("getQueryString : "+ qs);
	}

	

}
