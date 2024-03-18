package sec03.ex01.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncoderFilter
 */
// 필터가 여러개 같은 주소로 바인딩 되어도 다 동작함
@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncoderFilter() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("필터 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("필터 소멸");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * 여기는 서블릿 실행전
		 */
		System.out.println("실행 전");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 입력 주소 : http://localhost:8080/proj10_filter/login?user_id=%ED%95%98%EC%9C%99&user_pw=1234
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse sesp = (HttpServletResponse)response;
		StringBuffer sb = req.getRequestURL();
		
		// .toString => 문자열로 바꿔줌
		String url = sb.toString();
		
		// http://localhost:8080/proj10_filter/login
		System.out.println("getRequestURL : " + url);
		
		// /proj10_filter/login
		String uri = req.getRequestURI();
		System.out.println("getRequestURI : " + uri);
		
		// /proj10_filter
		String ctxPath = req.getContextPath();
		System.out.println("getContextPath : " + ctxPath);
		
		// /login
		String sPath = req.getServletPath();
		System.out.println("getServletPath : " + sPath);
		
		// user_id=%ED%95%98%EC%9C%99&user_pw=1234
		String q = req.getQueryString();
		System.out.println("getQueryString : " + q);
		
		if(req.getServletPath().indexOf("login.html") != -1 || req.getServletPath().indexOf("/login") != -1) {
			
			// 서블릿 실행
			chain.doFilter(request, response);
		} else {
			
			// Boolean => null 이 들어갈수있다(형변환이 자유롭다)
			Boolean login = (Boolean)req.getSession().getAttribute("login");
			
			if(login == null || login != true) {
				
				System.out.println("로그인 정보가 없어서 로그인 페이지로 보냄");
				sesp.sendRedirect("login.html");
			} else {
				
				// 서블릿 실행
				chain.doFilter(request, response);
			}
		}
		
				
		/*
		 * 여기는 서블릿 실행 후
		 */
		System.out.println("실행 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 init 실행");
	}

}
