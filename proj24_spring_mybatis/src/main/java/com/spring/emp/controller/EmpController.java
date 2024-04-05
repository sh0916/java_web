package com.spring.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.emp.dto.EmpDTO;
import com.spring.emp.service.EmpService;

public class EmpController extends MultiActionController {

	private EmpService empService;
	
	EmpController() {
		
		System.out.println("EmpController 생성");
	}
	
	public void setEmpService(EmpService empService) {
		
		System.out.println("EmpController > setEmpService 실행");
		this.empService = empService;
	}
	
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("EmpController > listMembers 실행");
		
		ModelAndView mav = new ModelAndView();
		List<EmpDTO> list = empService.getEmpList();
		
		mav.addObject("msg", "hello spring");
		mav.addObject("list", list);
		mav.setViewName("emp/listEmp");
		
		return mav;
	}
}
