package com.myspring.pro27.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.pro27.emp.dto.EmpDTO;
import com.myspring.pro27.emp.service.EmpService;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/member/listMembers.do")
	public String listEmp(Model model) {
		
		List<EmpDTO> list = empService.listEmp();
		System.out.println("list : " + list);
		
		logger.info("list : " + list);
		
		if(list != null) {
			System.out.println("list.size : " + list.size());
			logger.error("list.size() : " + list.size());
		}
		
		model.addAttribute("list", list);
		return "listEmp";
	}
}
