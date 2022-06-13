package com.example.demo.recipe.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 레시피 데이터 모델 작성자 : 장윤석 
 * 최초작성일 : 2022.06.08 
 * 최종수정일 : 2022.06.09
 * 비         고 : 1) hibernate 작동이 안되서, 대문자 부분을 언더바로 인식하지 못해 DB와 매핑이 안 되어 변경
 *           2) Mapper.xml에서 Select문의 as가 제대로 작동하지 않음
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)   // <--JSON에 NULL값 들어가는 key는 출력X
public class Recipe {
    private int recipe_seq; // 레시피 관리 번호
    private String recipe_nm; // 레시피 이름
    private String recipe_sumry; // 레시피 간략 소개
    private String recipe_nation_nm; // 레피시 카테고리 분류명
    private Integer irdnt_grp_code; // 식재료 공통 코드 id
    private Integer irdnt_code; // 식재료 공통 분류 코드
    private Integer recipe_cooking_time; // 조리시간
    private Integer recipe_qnt; // 요리분량
    private String recipe_calorie; // 칼로리
    private String recipe_level; // 레시피 난이도
    private String recipe_img_url; // 레시피 대표 이미지 url
    private String use_yn; // 해당 레시피 이용 여부 (Y=이용, N= 이용중지)
    private String cretr_id; // 등록자 ID
    private String cret_dt; //등록일
    private String amdr_id; // 수정자ID
    private String amd_dt; // 수정일시
    
    //그....다른 테이블도 필요
    // 유저
    private Integer user_seq;//회원관리번호  //다른 조원은 integer인데 출력 테스트중
    private String user_nm;//회원이름
    private String user_email;//회원아이디
    private String user_password;
    private String user_sex;//회원성별
    private Integer user_age;//회원나이
    
    // 냉장고   (중복삭제)
    private int refri_user_seq;
    private int irdnt_cpcty;
    
    // 식재료 공통구분 코드 (중복삭제)
    private int cd_grp_id;
    private String cd_grp_nm;
    private int cd_id;
    private String cd_nm;
    
    // 요리법
    private int cooking_no;
    private String cooking_dc;
    private String step_image_url;
    private String step_tip;
    
    public int getRecipe_seq() {
        return recipe_seq;
    }
    public void setRecipe_seq(int recipe_seq) {
        this.recipe_seq = recipe_seq;
    }
    public String getRecipe_nm() {
        return recipe_nm;
    }
    public void setRecipe_nm(String recipe_nm) {
        this.recipe_nm = recipe_nm;
    }
    public String getRecipe_sumry() {
        return recipe_sumry;
    }
    public void setRecipe_sumry(String recipe_sumry) {
        this.recipe_sumry = recipe_sumry;
    }
    public String getRecipe_nation_nm() {
        return recipe_nation_nm;
    }
    public void setRecipe_nation_nm(String recipe_nation_nm) {
        this.recipe_nation_nm = recipe_nation_nm;
    }
    public Integer getIrdnt_grp_code() {
        return irdnt_grp_code;
    }
    public void setIrdnt_grp_code(Integer irdnt_grp_code) {
        this.irdnt_grp_code = irdnt_grp_code;
    }
    public Integer getIrdnt_code() {
        return irdnt_code;
    }
    public void setIrdnt_code(Integer irdnt_code) {
        this.irdnt_code = irdnt_code;
    }
    public Integer getRecipe_cooking_time() {
        return recipe_cooking_time;
    }
    public void setRecipe_cooking_time(Integer recipe_cooking_time) {
        this.recipe_cooking_time = recipe_cooking_time;
    }
    public Integer getRecipe_qnt() {
        return recipe_qnt;
    }
    public void setRecipe_qnt(Integer recipe_qnt) {
        this.recipe_qnt = recipe_qnt;
    }
    public String getRecipe_calorie() {
        return recipe_calorie;
    }
    public void setRecipe_calorie(String recipe_calorie) {
        this.recipe_calorie = recipe_calorie;
    }
    public String getRecipe_level() {
        return recipe_level;
    }
    public void setRecipe_level(String recipe_level) {
        this.recipe_level = recipe_level;
    }
    public String getRecipe_img_url() {
        return recipe_img_url;
    }
    public void setRecipe_img_url(String recipe_img_url) {
        this.recipe_img_url = recipe_img_url;
    }
    public String getUse_yn() {
        return use_yn;
    }
    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }
    public String getCretr_id() {
        return cretr_id;
    }
    public void setCretr_id(String cretr_id) {
        this.cretr_id = cretr_id;
    }
    public String getCret_dt() {
        return cret_dt;
    }
    public void setCret_dt(String cret_dt) {
        this.cret_dt = cret_dt;
    }
    public String getAmdr_id() {
        return amdr_id;
    }
    public void setAmdr_id(String amdr_id) {
        this.amdr_id = amdr_id;
    }
    public String getAmd_dt() {
        return amd_dt;
    }
    public void setAmd_dt(String amd_dt) {
        this.amd_dt = amd_dt;
    }
    
    //----------------------유저----------------------------
    public Integer getUser_seq() {
        return user_seq;
    }
    public void setUser_seq(Integer user_seq) {
        this.user_seq = user_seq;
    }
    public String getUser_nm() {
        return user_nm;
    }
    public void setUser_nm(String user_nm) {
        this.user_nm = user_nm;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    public String getUser_sex() {
        return user_sex;
    }
    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
    public Integer getUser_age() {
        return user_age;
    }
    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }
    //-------------냉장고--------------------------------
    public int getRefri_user_seq() {
        return refri_user_seq;
    }
    public void setRefri_user_seq(int refri_user_seq) {
        this.refri_user_seq = refri_user_seq;
    }
    
    public int getIrdnt_cpcty() {
        return irdnt_cpcty;
    }
    public void setIrdnt_cpcty(int irdnt_cpcty) {
        this.irdnt_cpcty = irdnt_cpcty;
    }
    //------------식품공동코드---------------------------
    public int getCd_grp_id() {
        return cd_grp_id;
    }
    public void setCd_grp_id(int cd_grp_id) {
        this.cd_grp_id = cd_grp_id;
    }
    public String getCd_grp_nm() {
        return cd_grp_nm;
    }
    public void setCd_grp_nm(String cd_grp_nm) {
        this.cd_grp_nm = cd_grp_nm;
    }
    public int getCd_id() {
        return cd_id;
    }
    public void setCd_id(int cd_id) {
        this.cd_id = cd_id;
    }
    public String getCd_nm() {
        return cd_nm;
    }
    public void setCd_nm(String cd_nm) {
        this.cd_nm = cd_nm;
    }
    //------------------요리법--------------------------------
    public int getCooking_no() {
        return cooking_no;
    }
    public void setCooking_no(int cooking_no) {
        this.cooking_no = cooking_no;
    }
    public String getCooking_dc() {
        return cooking_dc;
    }
    public void setCooking_dc(String cooking_dc) {
        this.cooking_dc = cooking_dc;
    }
    public String getStep_image_url() {
        return step_image_url;
    }
    public void setStep_image_url(String step_image_url) {
        this.step_image_url = step_image_url;
    }
    public String getStep_tip() {
        return step_tip;
    }
    public void setStep_tip(String step_tip) {
        this.step_tip = step_tip;
    }
    
    
    @Override
    public String toString() {
        return "Recipe [recipe_seq=" + recipe_seq + ", recipe_nm=" + recipe_nm + ", recipe_sumry=" + recipe_sumry
                + ", recipe_nation_nm=" + recipe_nation_nm + ", irdnt_grp_code=" + irdnt_grp_code + ", irdnt_code="
                + irdnt_code + ", recipe_cooking_time=" + recipe_cooking_time + ", recipe_qnt=" + recipe_qnt
                + ", recipe_calorie=" + recipe_calorie + ", recipe_level=" + recipe_level + ", recipe_img_url="
                + recipe_img_url + ", use_yn=" + use_yn + ", cretr_id=" + cretr_id + ", cret_dt=" + cret_dt
                + ", amdr_id=" + amdr_id + ", amd_dt=" + amd_dt + ", user_seq=" + user_seq + ", user_nm=" + user_nm
                + ", user_email=" + user_email + ", user_password=" + user_password + ", user_sex=" + user_sex
                + ", user_age=" + user_age + ", refri_user_seq=" + refri_user_seq + ", irdnt_cpcty=" + irdnt_cpcty
                + ", cd_grp_id=" + cd_grp_id + ", cd_grp_nm=" + cd_grp_nm + ", cd_id=" + cd_id + ", cd_nm=" + cd_nm
                + ", cooking_no=" + cooking_no + ", cooking_dc=" + cooking_dc + ", step_image_url=" + step_image_url
                + ", step_tip=" + step_tip + "]";
    }
    
}
