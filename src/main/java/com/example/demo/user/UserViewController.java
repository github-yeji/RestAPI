package com.example.demo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.user.model.User;




@Controller
public class UserViewController {
	@Autowired
	private UserController usercontroller;
	
	@RequestMapping("/join.do")
	public String MemberAdd(User user) {
		usercontroller.MemberAdd(user);
		System.out.println(user.toString());
		return "/JoinForm";
	}

	@RequestMapping(value = "/mypage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String MyPage(User user, HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session.getAttribute("user_email") == null) {
			return "/intro";
		}
		// System.out.println(session.getAttribute("user_seq")+"=============ViewController======================");
		// session.getAttribute("user_email");
		else {
			// usercontroller.MemberEdit(user);
			return "/Mypage";
		}

	}

	@GetMapping("/login2.do")
	public String MemberLogin(User user, HttpServletRequest request, RedirectAttributes rttr) throws Exception {

		System.out.println("=======login do========");
		HttpSession session = request.getSession();
		// ResponseEntity<User> result =usercontroller.MemberLogin(user);
		usercontroller.MemberLogin(user, session);
//		  //if(user==null) { System.out.println("====usernull======");
//		  session.setAttribute("user_seq", null); rttr.addFlashAttribute("msg",false);
//		  
//		  } else { // session.setAttribute("user_email",user.getUser_email()); //
//		  session.setAttribute("user_seq",user.getUser_seq());
//		  System.out.println("==user_seq====:"+session.getAttribute("user_seq"));}

		System.out.println(user.toString() + "=========login2===========");
		return "/intro";
	}

	@GetMapping("/login.do")
	public String MemberLogin2(User user, HttpServletRequest request, RedirectAttributes rttr) throws Exception {

		System.out.println("check!");
		return "/intro";
	}

	@GetMapping("/logout.do")
	public String MemberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
//		session.setAttribute("user_email",null);
//		session.setAttribute("user_nm",null);
//		session.setAttribute("user_age",null);
//		session.setAttribute("user_sex",null);
		session.invalidate();
		return "/intro";
	}

	@GetMapping("/delete.do")
	public String MemberDelete(String email, HttpServletRequest request) {
		HttpSession session = request.getSession();
		email = (String) session.getAttribute("user_email");
		System.out.println("=======viewcondelete========" + email);
		usercontroller.MemberDelete(email);
		return "/intro";
	}
}


