package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.model.User;

@RestController
@RequestMapping("/users")
public class UserContorller {
	@Autowired
	private UserService userService;
	
	@GetMapping("/userInfo")
	public User getUserInfo(@RequestBody User user){
		return userService.getUserInfo(user);
	}
	
//	@GetMapping("/login")
//	public Object MemberLogin(@RequestParam(value="user_email",required=false) String user_email
//			, @RequestParam(value="user_pwd",required=false) String user_pwd) {
//		System.out.println("------login------");
//		
//		List<User> user = userService.findByUserLogin(user_email, user_pwd);
//		return user;
//	}
	
	@GetMapping("/login")
	public ResponseEntity<String> MemberLogin(@RequestBody User user) {
		try {
			userService.findByUserLogin(user);
			return new ResponseEntity<>(String.format("로그인 성공"), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(String.format("로그인 실패"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/join")
	public ResponseEntity<String> MemberAdd(@RequestBody User user) {
		try {
			userService.insert(user);
			return new ResponseEntity<>(String.format("회원가입에 성공하셨습니다."), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(String.format("이미 가입된 이메일입니다."), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@PostMapping("/memberedit")
	public ResponseEntity<String> MemberEdit(@RequestBody User user) {
		try {
			Integer updatedCnt = userService.updateById(user);
			return new ResponseEntity<>(String.format("%d updated", updatedCnt), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@PostMapping("/memberdelete")
	public ResponseEntity<String> cityDelete(@RequestParam(value="user_email") String email) {
		try {
			Integer deletedCnt = userService.deleteById(email);
			return new ResponseEntity<>(String.format("%d deleted", deletedCnt), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
