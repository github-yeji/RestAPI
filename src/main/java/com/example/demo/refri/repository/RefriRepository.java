package com.example.demo.refri.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.example.demo.Sql;
import com.example.demo.food.FoodRepository;
import com.example.demo.refri.model.UserRefri;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RefriRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RefriRowMapper refriRowMapper;
	
	public RefriRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.refriRowMapper = new RefriRowMapper();
	}

	public List<UserRefri> findUserRefrigerator(){
		System.out.println("냉장고 속 식재료 출력 쿼리 = " + Sql.REFRISELECT);

		return namedParameterJdbcTemplate.query(Sql.REFRISELECT
				, EmptySqlParameterSource.INSTANCE
				, this.refriRowMapper); 
		
		//EmptySqlParameterSource.INSTANCE: 쿼리에 파라메터를 넘길 필요가 없을 때
		//this.refriRowMapper: 조회된 데이터의 한줄한줄을 매핑
	}
	
	public Integer clear(UserRefri userRefri) {
		System.out.println("냉장고 속 클리어 쿼리 = " + Sql.REFRICLEAR);
		SqlParameterSource parameterSource = new MapSqlParameterSource("refriUserSeq", userRefri.getRefriUserSeq());
		return namedParameterJdbcTemplate.update(Sql.REFRICLEAR, parameterSource);

	}
	
	public UserRefri insert(UserRefri userRefri) {
		System.out.println("냉장고 식재료 추가 = " + Sql.INSERT);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource("refriUserSeq", userRefri.getRefriUserSeq())
				.addValue("foodCode", userRefri.getFoodCode());
//				.addValue("refriFoodCpcty", userRefri.getRefriFoodCpcty());
		namedParameterJdbcTemplate.update(Sql.INSERT, parameterSource, keyHolder);
		userRefri.setRefriUserSeq(keyHolder.getKey().intValue());
		return userRefri;
	}
	
}
