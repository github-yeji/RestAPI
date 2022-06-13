package com.example.demo.user.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		return namedParameterJdbcTemplate.query(Sql.USERSELECT, EmptySqlParameterSource.INSTANCE, this.userRowMapper);
	}

	public User insert(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_nm", user.getUser_nm())
				.addValue("user_email", user.getUser_email())
				.addValue("user_password", user.getUser_password())
				.addValue("user_sex", user.getUser_sex())
				.addValue("user_age", user.getUser_age()); 
		int affectedRows = namedParameterJdbcTemplate.update(Sql.USERINSERT, parameterSource, keyHolder);
		return user;
	}
	
	public Integer updateById(User user) {
		String qry = Sql.USERINSERT + Sql.ID_CONDITION;
		
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_nm", user.getUser_nm())
				.addValue("user_email", user.getUser_email())
				.addValue("user_password", user.getUser_password())
				.addValue("user_sex", user.getUser_sex())
				.addValue("user_age", user.getUser_age()); 
		return namedParameterJdbcTemplate.update(qry, parameterSource);
	}
	
	public Integer deleteById(String email) {
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_email", email); 
		return namedParameterJdbcTemplate.update(Sql.USERDELETE + Sql.ID_CONDITION, parameterSource);
	}
}