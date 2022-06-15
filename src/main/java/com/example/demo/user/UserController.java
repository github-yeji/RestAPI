package com.example.demo.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.refri.model.UserRefri;
import com.example.demo.user.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/Allusers")
	public List<User>getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/mypage")//마이페이지 추가부분
	public Object MemberLogin(@RequestParam(value="user_email",required=false) String user_email
			, @RequestParam(value="user_pwd",required=false) String user_pwd) {
		
		List<User> user = userService.findByUserPage(user_email, user_pwd);
		return user;
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> MemberLogin(@RequestBody User user) {
		try {
			User result = userService.findByUserLogin(user);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/join")
	public ResponseEntity<User> MemberAdd(@RequestBody User user) {
		try {
			
			return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
