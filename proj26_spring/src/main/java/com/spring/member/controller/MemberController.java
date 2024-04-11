package com.spring.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.member.service.MemberService;

@Controller
public class MemberController {

	MemberController() {
		
		System.out.println("MemberController 생성자");
	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member/listMembers.do")
	public String listMembers(Model model) {
		
		System.out.println("MemberController > listMembers 실행");
		
		List list = memberService.listMembers();
		model.addAttribute("memberList", list);
		
		return "member/listMembers";
	}
}
