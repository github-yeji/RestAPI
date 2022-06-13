package com.example.demo.user.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.user.model.User;

public class UserRowMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUser_seq(rs.getInt("user_seq"));
		user.setUser_nm(rs.getString("user_nm"));
		user.setUser_password(rs.getString("user_password"));
		user.setUser_sex(rs.getString("user_sex"));
		user.setUser_email(rs.getString("user_email"));
		user.setUser_age(rs.getInt("user_age"));
		return user;
	}
}
