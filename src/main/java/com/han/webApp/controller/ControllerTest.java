package com.han.webApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller		//컨트롤러 이노테이션(이 .java가 컨트롤러라는 표시)
public class ControllerTest {
	@RequestMapping("/formData")
	public String formData(@RequestParam("name")String name,
			@RequestParam("num")int num,
			@RequestParam("tel")String tel, Model model){
		//@RequestParam("name"),==req.getParameter("name")

		model.addAttribute("name",name);
		model.addAttribute("num",num);
		model.addAttribute("tel",tel);
		return "formView";
	}
/*	
	//폼으로 접속, post로 접속
	@RequestMapping("/formData")
	public String formData(HttpServletRequest req, Model model){
		String name = req.getParameter("name");
		String num	= req.getParameter("num");
		String tel = req.getParameter("tel");
		
		model.addAttribute("name",name);
		model.addAttribute("num",num);
		model.addAttribute("tel",tel);
		return "formView";
	}*/
	//a태그로 접속
	@RequestMapping(value="/aLink",method=RequestMethod.GET) ///aLink로 접속하면~밑에써 실행
	//,method=RequestMethod.GET==반드시 get방식이여야한다  //저게 없으면 방식을 구분하지 않는다
	public String aLinkTest(HttpServletRequest req, Model model){//aLinkTest아무거나가능
	//HttpServletRequest req==클라이언트에서 보낸걸 받는다	
		//클라이언트 측에서 보낸 데이터
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		
		//뷰로 데이터 보내기
		model.addAttribute("num",num);
		model.addAttribute("name",name);
		return "aLink";//jsp파일명 -뷰파일명
		
	}
	@RequestMapping("/view1")//get,post방식 상관 무
	public String viewTest(Model model){  //밑 코드는view1 다음에 실행
		//이름, 연락처
		model.addAttribute("name","홍길동");
		model.addAttribute("tel","010-1234-5678");
		return "view1";//jsp파일명
	}
}
