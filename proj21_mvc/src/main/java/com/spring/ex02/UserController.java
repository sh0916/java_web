package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userID = request.getParameter("userID");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");	// jsp 파일명만 지정
//		ModelAndView mav = new ModelAndView("result");	// 이것도 가능하다
		
		// view  로 보낼 값들을 담아줌
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
				
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = "memberInfo";
		ModelAndView mav = new ModelAndView(viewName);	// 생성자를 통해 setViewName 을 실행
		
		mav.addObject("id", request.getParameter("id"));
		mav.addObject("pw", request.getParameter("pw"));
		
		return mav;
	}
}
