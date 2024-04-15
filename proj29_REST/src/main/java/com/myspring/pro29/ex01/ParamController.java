package com.myspring.pro29.ex01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// class 를 Controller Bean 으로 등록함
// @RestController // @Controller + @ResponseBody
@RequestMapping("/human/*")	// class 공통 접속 주소
public class ParamController {

	@Autowired	// 해당 변수 타입에 맞는 Bean 을 찾아서 new 해서 주입까지 해줌
	EmpDTO empDTO;
	
	@RequestMapping(
			value= {"/{name}/a/{addr}", "/b"},	// value 와 {}로 두개 이상 주소를 연결 가능
			method= {RequestMethod.GET}	// method 제한, 없으면 모두다 허용
//			method= {RequestMethod.POST}
			)
	@ResponseBody	// JSON 으로 돌려줌
	public EmpDTO paramTest(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			
			@RequestParam("id") String id,	// String id = request.getParameter("id")
											// 단 id 가 null 인 경우 400 Bad Request
			String pw,						// @RequestParam("pw") key 와 변수가 같다면 생략가능
			@RequestParam(value="id2", required=false) String id2,	// 전달값이 필수가 아니게됨
			@RequestParam Map map,	// 뭐든 map 에 key, value 로 담아줌
			
			@ModelAttribute EmpDTO dto1,	// getParameter 로 할수 있는걸 알아서 dto 에 넣어줌
			@ModelAttribute("dto3") EmpDTO dto2,	// model.addAttribute("dto3", dto2) 와 동일
			EmpDTO dto4,	// 바로 윗줄과 동일
			
			@PathVariable("name") String name,	// 주소의 중 key 에 해당하는 글씨의 값을 가져옴
			
			@RequestBody EmpDTO dto5	// post 로 넘어온 JSON 을 분석해서 dto5 에 넣어줌
			) {
		
		return null;
	}
}
