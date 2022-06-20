package com.example.demo.user.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.user.model.User;

public class UserRowMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User city = new User();
		city.setUser_seq(rs.getInt("user_seq"));
		city.setUser_nm(rs.getString("user_nm"));
		city.setUser_email(rs.getString("user_email"));
		city.setUser_pwd(rs.getNString("user_pwd"));
		city.setUser_sex(rs.getString("user_sex"));
		city.setUser_age(rs.getInt("user_age"));
		
		return city;
	}
}
