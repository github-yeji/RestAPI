package com.example.demo.user.repository;
class UserSql{
	public static final String SELECT = """
		SELECT user_seq, user_email, user_nm, user_sex, user_age FROM tb_user
	""";
	public static final String INSERT = """
		INSERT INTO tb_user ( user_nm, user_email,user_pwd ,user_sex, user_age) values(:user_nm, :user_email,:user_password ,:user_sex,:user_age)
	""";
	public static final String UPDATE="""
		UPDATE tb_user SET user_nm = :user_nm, user_email=:user_email, user_pwd=:user_password,user_sex=:user_sex,user_age=:user_age WHERE 1=1
	""";
	public static final String ID_CONDITION = """
		AND user_email = :user_email
	""";
	public static final String DELETE = """
	DELETE FROM tb_user WHERE 1=1  
	""";
	
}