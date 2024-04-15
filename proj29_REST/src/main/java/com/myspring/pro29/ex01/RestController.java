package com.myspring.pro29.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

	@RequestMapping("/rest/ajax.do")
	public String ajax1() {
		
		return "ajax";
	}
	
	// @RequestBody => post 방식으로 JSON 을 처리
	// @ResponseBody => String 또는 JSON 으로 리턴해줌
	// @RestController => @Controller + @ResponseBody
	@RequestMapping("/rest/ajax")
	@ResponseBody
	public EmpDTO ajax2(@RequestBody EmpDTO dto) {
		
		System.out.println(dto);
		return dto;
	}
	
	// redirect: => return 값으로 주소를 적으면 그주소로 redirect 된다
	@RequestMapping("/rest/redirect")
	public String redirect() {
		
		return "redirect:/rest/ajax.do";
	}
	
	// forward: => return 값으로 주소를 적으면 그주소로 forward 된다
	@RequestMapping("/rest/forward")
	public String forward() {
		
		return "forward:/rest/ajax.do";
	}
}
