package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/test/loginForm.do")
	public ModelAndView loginForm() {

		System.out.println("loginForm 실행");
		
		return new ModelAndView("loginForm");
	}
	
	@RequestMapping("/test/login.do")
	public ModelAndView login(HttpServletRequest request) {
		
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		System.out.println("userID : " + userID);
		System.out.println("userName : " + userName);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login2.do")
	public ModelAndView login2( 
//			String userID = request.getParameter("userID")
			// 위의 것과 동일한 동작
			// 변수명이 key 와 같다면 @RequestParam("userID") 생략도 가능
			// 기본값은 필수, 없다면 400 Bad Request 에러 발생
			@RequestParam("userID") String userID, 
			@RequestParam("userName") String userName
	) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login2_1.do")
	public ModelAndView login2_1( 
			@RequestParam("userID") String userID, // required 의 기본값 : true
			@RequestParam(value="userName", required=false) String userName
	) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login3.do")
	public ModelAndView login3( 
			@RequestParam
			Map<String, Integer> info
	) {
		
		System.out.println("userName : " + info.get("userName"));
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("info", info);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login4.do")
	public ModelAndView login4( 
			// @ModelAttribute : DTO 에 알아서 넣어줌
//			@ModelAttribute MemberDTO memberDTO
			
			// request scope 에 info 라는 key 로 DTO 를 넣어 주는 것 까지 해줌
			// @ModelAttribute("info") 안에 넣어주면 ModelAndView 에 내가 넣어준 이름으로 addObject 해준다
//			@ModelAttribute("info") MemberDTO memberDTO
			
			// @ModelAttribute 를 생략하고 DTO 만 적은 경우
			// @ModelAttribute("memberDTO") 클래스 앞글자를 소문자로 바꾼 변수에 넣어 줌
			MemberDTO memberDTO
	) {
		
		ModelAndView mav = new ModelAndView();
		
//		mav.addObject("info", memberDTO);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login5.do")
	public String login5( 
			@RequestParam("userID") String userID, 
			@RequestParam("userName") String userName,
			Model model
	) {
		
		model.addAttribute("userID", userID);
		model.addAttribute("userName", userName);
		
		return "result";
	}
	
	@RequestMapping("result")
//	@RequestMapping("result.do")
	public void login5_1() {
		
		// return type 이 void
		// return null
		// 위의 경우 들어온 주소의 마지막 . 이후를 제거하고
		// viewResolver 로 보냄
		// 즉, 들어온 주소 jsp 가 호출됨
		
		// 그래도 써주는게 읽기 쉽다
//		return "result";
	}
}
