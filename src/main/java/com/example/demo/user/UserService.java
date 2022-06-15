package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.dao.UserDAO;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		 this.userRepository = userRepository;
	}
	
	public List<User>getAllUsers(){
		return this.userRepository.findList();
	}
	
	public List<User> findByUserPage(String user_email, String user_pwd) {
		return this.userRepository.findByUserPage(user_email, user_pwd);
	}//마이페이지 추가부분
	public User findByUserLogin(User user) {
		return this.userRepository.findByUserLogin(user);
	}


	public User insert(User user) {
		return this.userRepository.insert(user);
	}
	public Integer updateById(User user) {
		return userRepository.updateById(user);
	}
	public Integer deleteById(String email) {
		return userRepository.deleteById(email);
	}
}
