package com.example.demo.food;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.refri.model.UserRefri;

public class FoodRowMapper implements RowMapper<Food>{

	@Override
	public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
		Food food = new Food();
		food.setCdId(rs.getInt("cd_id"));
		food.setCdNm(rs.getString("cd_nm"));
		food.setRefriUserSeq(rs.getInt("refri_user_seq"));
		return food;
	}

	
}
