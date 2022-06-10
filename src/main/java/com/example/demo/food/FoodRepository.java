package com.example.demo.food;


import com.example.demo.food.FoodRowMapper;
import com.example.demo.refri.model.UserRefri;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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


	@Transactional
	public List<Food> findfood(List<Food> foods) {
		
		List<Food> finded = new ArrayList<Food>(1);
		
		for(Food food : foods) {
			SqlParameterSource parameterSource = new MapSqlParameterSource("cdNm", food.getCdNm())
					.addValue("refriUserSeq", food.getRefriUserSeq());
			try {
				food = namedParameterJdbcTemplate.queryForObject(Sql.FINDFOOD, parameterSource, foodRowMapper);
			}catch(EmptyResultDataAccessException e) {
				return null;
			}
			finded.add(food);
		}
		return finded;
	}

	
}
