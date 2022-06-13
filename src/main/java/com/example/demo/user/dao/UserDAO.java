package com.example.demo.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.user.model.User;

@Repository
public class UserDAO {
	public static List<User> users;
	
	public List<User> getAllUsers(){
		return users;
	}
	
	
	
}
