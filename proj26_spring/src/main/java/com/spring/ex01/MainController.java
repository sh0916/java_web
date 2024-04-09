package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// Controller Bean(즉 클래스) 으로 등록한다
@Controller
// 클래스에 적용한 RequestMapping 은 HandlerMapping 이 처리합니다
// 클래스에 적용한 주소는 메소드 공통으로 사용하는 앞에 붙어 있는 주소
// ip:port/context path/test/*
@RequestMapping("/test")
public class MainController {

	// 메소드에 적용한 RequestMapping 은 HandleAdapter 가 처리합니다
	// 실질적인 주소
//	@RequestMapping("/test/main1.do")
	@RequestMapping("/main1.do")
	public ModelAndView main1() {
		
		System.out.println("main 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1 입니다");
		// servlet-context.xml 에 있는 ViewResolver 에 지정한 주소로 보낸다
		mav.setViewName("main");
		
		return mav;
	}
	
//	@RequestMapping("/test/main2.do")
	@RequestMapping("/main2.do")
	public ModelAndView main2() {
		
		System.out.println("main 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2 입니다");
		mav.setViewName("main");
		
		return mav;
	}
	
	// 어노테이션에 두개 이상 적용시 {}
	@RequestMapping(value= {"/main3.do", "/main4.do"}, method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main3() {
		
		System.out.println("main 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main3 입니다");
		mav.setViewName("main");
		
		return mav;
	}
}
