package com.example.demo.user.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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
	
	public User findByUserLogin(User user){
		
		SqlParameterSource param = new MapSqlParameterSource("user_email", user.getUser_email())
				.addValue("user_pwd", user.getUser_pwd());

		return namedParameterJdbcTemplate.queryForObject(Sql.USERLOGIN
				+ Sql.USER_EMAIL
				+ Sql.USER_PASSWORD, param, this.userRowMapper);
		
	}
	
	public List<User> findByUserPage(String user_email, String user_pwd){
		SqlParameterSource param = new MapSqlParameterSource("user_email", user_email)
				.addValue("user_pwd", user_pwd);
		
		List<User> user = namedParameterJdbcTemplate.query(Sql.USERLOGIN
				+ Sql.USER_EMAIL
				+ Sql.USER_PASSWORD, param, this.userRowMapper);
		System.out.println(user_email+ user_pwd+ user);
		
		return user;
	}//마이페이지 추가부분

	public User insert(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_nm", user.getUser_nm())
				.addValue("user_email", user.getUser_email())
				.addValue("user_pwd", user.getUser_pwd())
				.addValue("user_sex", user.getUser_sex())
				.addValue("user_age", user.getUser_age());
		
		
		namedParameterJdbcTemplate.update(Sql.USERINSERT, parameterSource, keyHolder);
		user.setUser_seq(keyHolder.getKey().intValue());
		
		SqlParameterSource parameterSource2 = new MapSqlParameterSource("user_seq", user.getUser_seq());
		namedParameterJdbcTemplate.update(Sql.USERREFRISEQINSERT, parameterSource2, keyHolder);
		
		return user;
	}
	
	public Integer updateById(User user) {
		String qry = Sql.USERINSERT + Sql.ID_CONDITION;
		
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_nm", user.getUser_nm())
				.addValue("user_email", user.getUser_email())
				.addValue("user_pwd", user.getUser_pwd())
				.addValue("user_sex", user.getUser_sex())
				.addValue("user_age", user.getUser_age()); 
		return namedParameterJdbcTemplate.update(qry, parameterSource);
	}
	
	public Integer deleteById(String email) {
		SqlParameterSource parameterSource = new MapSqlParameterSource("user_email", email); 
		return namedParameterJdbcTemplate.update(Sql.USERDELETE + Sql.ID_CONDITION, parameterSource);
	}
}