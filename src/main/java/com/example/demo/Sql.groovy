package com.example.demo

class Sql{
	
	
	//REFRI -----------------------------------------------------------------------------------------------------------
	public static final String REFRISELECT = """
				SELECT refri_user_seq, cd_nm, irdnt_cpcty, irdnt_code
				FROM tb_refrigerator
					INNER JOIN tb_user ON tb_refrigerator.refri_user_seq = tb_user.user_seq
					INNER JOIN tb_irdnt_cd_grp ON tb_refrigerator.irdnt_grp_code = tb_irdnt_cd_grp.cd_grp_id AND tb_refrigerator.irdnt_code = tb_irdnt_cd_grp.cd_id
				
	""";
	
	public static final String FINDFOOD = """
				SELECT DISTINCT refri_user_seq, cd_id, cd_nm FROM tb_irdnt_cd_grp, tb_refrigerator WHERE cd_nm=:cdNm AND refri_user_seq=:refriUserSeq
	""";

	public static final String REFRICLEAR = """
				DELETE FROM tb_refrigerator WHERE refri_user_seq=:refriUserSeq
	""";
	
	public static final String REFRIINSERT = """
				INSERT INTO tb_refrigerator(refri_user_seq, irdnt_code, irdnt_grp_code) VALUES(:refriUserSeq, :foodCode, 100)
	""";
	
	//USER -----------------------------------------------------------------------------------------------------------
	
	public static final String USERSELECT = """
		SELECT user_seq, user_email, user_nm, user_sex, user_age FROM tb_user
	""";
	
	public static final String USERINSERT = """
		INSERT INTO tb_user ( user_nm, user_email,user_pwd ,user_sex, user_age) values(:user_nm, :user_email,:user_password ,:user_sex,:user_age)
	""";
	
	public static final String USERUPDATE="""
			UPDATE tb_user SET user_nm = :user_nm, user_email=:user_email, user_pwd=:user_password,user_sex=:user_sex,user_age=:user_age WHERE 1=1
		""";
	public static final String ID_CONDITION = """
			AND user_email = :user_email
		""";
	public static final String USERDELETE = """
		DELETE FROM tb_user WHERE 1=1  
		""";
	
}