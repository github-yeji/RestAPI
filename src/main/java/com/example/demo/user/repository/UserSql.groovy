package com.example.demo.user.repository;

class UserSql{
	//public static final String SELECT = "SELECT ID, Name, CountryCode, District, Population FROM city LIMIT 1000;";
	public static final String SELECT = """
		SELECT user_seq, user_email, user_nm, user_sex, user_age FROM tb_user WHERE user_seq=1
	""";

public static final String COUNTRY_CODE_CONDITION = """
		AND countryCode = :countryCode
	""";

public static final String POPULATION_CONDITION = """
		AND population >= :population
	""";
}