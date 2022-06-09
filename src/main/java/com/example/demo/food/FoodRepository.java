package com.example.demo.food;


import com.example.demo.food.FoodRowMapper;
import com.example.demo.refri.model.UserRefri;

import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.demo.Sql;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FoodRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final FoodRowMapper foodRowMapper;
	
	public FoodRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.foodRowMapper = new FoodRowMapper();
	}

	public Food findfood(Food food) {
		
		SqlParameterSource parameterSource = new MapSqlParameterSource("cdNm", food.getCdNm())
				.addValue("refriUserSeq", food.getRefriUserSeq());
		food = namedParameterJdbcTemplate.queryForObject(Sql.FINDFOOD, parameterSource, foodRowMapper);

		return food;
	}

	
}
