package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test/hello")
	public String hello() {
		
		return "Hello";
	}
	
	@RequestMapping("/test/member")
	public List<EmpDTO> member() {
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		for(int i = 0; i < 3; i++) {			
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(i * 1000);
			empDTO.setEname("이성현");
			empDTO.setSal((i + 1000) * 2);
			list.add(empDTO);
		}
		
		return list;
	}
	
	@RequestMapping("/test/memberMap")
	public Map<String, Object> memberMap() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		for(int i = 0; i < 3; i++) {			
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(i * 1000);
			empDTO.setEname("이성현");
			empDTO.setSal((i + 1000) * 2);
			list.add(empDTO);
		}
		
		map.put("total", 140);
		map.put("list", list);
		
		return map;
	}
	
	@RequestMapping("test/notice/{num}")
	public int notice(@PathVariable int num) {
		
		return num;
	}
	
	// @PathVariable => 주소값에 들어온 정보를 변수에 저장할수있음
	@RequestMapping("test/notice/{num}/{str}")
	public Map<String, Object> notice2(@PathVariable int num, @PathVariable String str) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("str", str);
		map.put("num", num);
		
		return map;
	}
	
	// @ModelAttribute => getParameter 로 받을수있는것을 dto 에 넣어준다
	// @RequestBody => JSON 으로 넘어온 데이터를 파싱해서 dto 에 넣어준다
	@RequestMapping("/test/info")
	public EmpDTO info(
//			@ModelAttribute EmpDTO dto
			@RequestBody EmpDTO dto
			) {
		
		System.out.println(dto);
		
		return dto;
	}
}
