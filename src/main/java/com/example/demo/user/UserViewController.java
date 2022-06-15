package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.user.model.User;




@Controller
public class UserViewController {
	@Autowired
	private UserController usercontroller;
	@GetMapping("/join.do")
	public String MemberAdd(User user) {
		
		usercontroller.MemberAdd(user);
		System.out.println(user.toString());
		return "user/JoinForm";
		}
	@GetMapping("/mypage.do")
	public String MyPage(User user) {
		
		
		return"user/Mypage";
	}
}


