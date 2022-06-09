package com.example.demo

class Sql{
	//public static final String SELECT = "SELECT ID, Name, CountryCode, District, Population FROM city LIMIT 1000;";
	public static final String SELECT = """
		SELECT user_seq, user_email, user_nm, user_sex, user_age FROM tb_user
	""";

	public static final String COUNTRY_CODE_CONDITION = """
		AND countryCode = :countryCode
	""";

	public static final String POPULATION_CONDITION = """
		AND population >= :population
	""";
	
	public static final String REFRISELECT = """
				SELECT refri_user_seq, cd_nm, irdnt_cpcty, irdnt_code
				FROM tb_refrigerator
					INNER JOIN tb_user ON tb_refrigerator.refri_user_seq = tb_user.user_seq
					INNER JOIN tb_irdnt_cd_grp ON tb_refrigerator.irdnt_grp_code = tb_irdnt_cd_grp.cd_grp_id AND tb_refrigerator.irdnt_code = tb_irdnt_cd_grp.cd_id
				
	""";
	
	public static final String FINDFOOD = """
				SELECT cd_id, cd_nm, refri_user_seq FROM tb_irdnt_cd_grp, tb_refrigerator WHERE cd_nm=:cdNm AND refri_user_seq=:refriUserSeq
	""";

	public static final String REFRICLEAR = """
				DELETE FROM tb_refrigerator WHERE refri_user_seq=:refriUserSeq
	""";
	
//	public static final String INSERT = """
//				INSERT INTO tb_refrigerator(refri_user_seq, irdnt_code, irdnt_cpcty, irdnt_grp_code) VALUES(:refriUserSeq, :foodCode, :refriFoodCpcty, 100)
//	""";
	
	public static final String INSERT = """
				INSERT INTO tb_refrigerator(refri_user_seq, irdnt_code, irdnt_grp_code) VALUES(:refriUserSeq, :foodCode, 100)
	""";
	
}