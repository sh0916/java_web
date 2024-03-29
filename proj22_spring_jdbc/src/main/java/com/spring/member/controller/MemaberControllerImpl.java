package com.spring.member.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;

public class MemaberControllerImpl extends MultiActionController {

	MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	void test() {
		
		System.out.println("테스트");
	}
}
