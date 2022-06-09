package com.example.demo.user.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.demo.user.model.User;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.Sql;

@Slf4j
@Repository
public class UserRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final UserRowMapper userRowMapper;

	public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.userRowMapper = new UserRowMapper();
	}

	public List<User> findList() {
		return namedParameterJdbcTemplate.query(Sql.SELECT, EmptySqlParameterSource.INSTANCE, this.userRowMapper);
	}

	public List<User> findByCountryCodeAndPopulation(String countryCode, int population){
		
		String qry = Sql.SELECT+ Sql.COUNTRY_CODE_CONDITION+ Sql.POPULATION_CONDITION;

		SqlParameterSource param = new MapSqlParameterSource("countryCode", countryCode)
				.addValue("population", population);
		
		return namedParameterJdbcTemplate.query(qry, param, this.userRowMapper);
	}
}