package com.example.demo.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

	
	@PostMapping("/login")
	public ResponseEntity<User> MemberLogin(@RequestBody User user, HttpSession session) {
		try {
			User result = userService.findByUserLogin(user);
			System.out.println(result+"=====login=====");
			session.setAttribute("user_seq", result.getUser_seq());
			System.out.println(session.getAttribute("user_seq"));
			return new ResponseEntity<>(result, HttpStatus.OK);
			
			
		}catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/login2")
	public ResponseEntity<User> MemberLogin2(User user,HttpSession session) {
		System.out.println("=======/users/login========");
		try {
			User result = userService.findByUserLogin(user);
			System.out.println(result+"=====login=====");
			session.setAttribute("user_seq", result.getUser_seq());
			session.setAttribute("user_email", result.getUser_email());
			session.setAttribute("user_pwd", result.getUser_pwd());
			session.setAttribute("user_nm", result.getUser_nm());
			session.setAttribute("user_age", result.getUser_age());
			session.setAttribute("user_sex", result.getUser_sex());
			System.out.println(session.getAttribute("user_seq"));
			System.out.println(result);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
			
		}catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@PostMapping("/join")
	public ResponseEntity<User> MemberAdd(@RequestBody User user) {
		try {
			System.out.println(user.toString()+"USER CONTROLLER");
			return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@PostMapping("/memberedit")
	public ResponseEntity<String> MemberEdit(@RequestBody User user, HttpSession session) {
		try {
			System.out.println(user+"================memedit=================");
			Integer updatedCnt = userService.updateById(user);
			session.setAttribute("user_seq", user.getUser_seq());
			session.setAttribute("user_email", user.getUser_email());
			session.setAttribute("user_pwd", user.getUser_pwd());
			session.setAttribute("user_nm", user.getUser_nm());
			session.setAttribute("user_age", user.getUser_age());
			session.setAttribute("user_sex", user.getUser_sex());
			return new ResponseEntity<>(String.format("%d updated", updatedCnt), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("===========Exception============="+e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@PostMapping("/memberdelete")
	public ResponseEntity<String> MemberDelete( @RequestParam(value="user_email", required=false) String email) {
		try {
			System.out.println(email);
			Integer deletedCnt = userService.deleteById(email);
			
			return new ResponseEntity<>(String.format("%d deleted", deletedCnt), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
