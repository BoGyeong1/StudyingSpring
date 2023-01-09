package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/add", method=RequestMethod.GET,RequestMethod.POST);
//	@RequestMapping("/register/add") // method 안 써주면 둘 다 허용 신규회원 가입
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//		
//	} //servlet-context.xml 에 들어가 한줄로 view-controller 로 입력가능

//	@RequestMapping(value="/register/save", method=RequestMethod.POST);
	@PostMapping("/register/save") // 4.3 부터
	public String save(User user, Model m) throws Exception{
		// 1. 유효성 검사
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg=" + msg; // url 재작성 (rewriting)
			//redirect :  재요청의 의미가 있음
		} 
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}

}
