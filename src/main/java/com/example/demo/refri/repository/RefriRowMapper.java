package com.example.demo.refri.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.refri.model.UserRefri;

public class RefriRowMapper implements RowMapper<UserRefri>{

	@Override
	public UserRefri mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRefri userRefri = new UserRefri();
		userRefri.setRefriUserSeq(rs.getInt("refri_user_seq"));
		userRefri.setFoodCode(rs.getInt("irdnt_code"));
		userRefri.setRefriFoodCpcty(rs.getInt("irdnt_cpcty"));
		userRefri.setFoodNm(rs.getString("cd_nm"));
		return userRefri;
	}

	
}
