package com.example.demo.refri.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public Integer clear(Integer refriUserSeq) {
		
		System.out.println("냉장고 속 클리어 쿼리 = " + Sql.REFRICLEAR);
		SqlParameterSource parameterSource = new MapSqlParameterSource("refriUserSeq", refriUserSeq);
		return namedParameterJdbcTemplate.update(Sql.REFRICLEAR, parameterSource);
	}
	
	@Transactional
	public List<UserRefri> insert(List<UserRefri> userRefris) {
		List<UserRefri> added = new ArrayList<UserRefri>(userRefris);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		for(UserRefri userRefri : userRefris) {
			System.out.println("냉장고 식재료 추가 = " + Sql.INSERT);
			SqlParameterSource parameterSource = new MapSqlParameterSource("refriUserSeq", userRefri.getRefriUserSeq())
					.addValue("foodCode", userRefri.getFoodCode());
			namedParameterJdbcTemplate.update(Sql.INSERT, parameterSource, keyHolder);
			userRefri.setRefriUserSeq(keyHolder.getKey().intValue());
			added.add(userRefri);
		}
		return added;
		

	}
	
}
