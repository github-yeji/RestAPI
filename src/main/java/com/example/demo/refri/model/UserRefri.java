package com.example.demo.refri.model;

public class UserRefri {
	private Integer RefriUserSeq;
	private String FoodNm;
	private Integer RefriFoodCpcty;
	private Integer FoodCode;

	public String getFoodNm() {
		return FoodNm;
	}
	public void setFoodNm(String foodNm) {
		FoodNm = foodNm;
	}
	public Integer getFoodCode() {
		return FoodCode;
	}
	public void setFoodCode(Integer foodCode) {
		FoodCode = foodCode;
	}
	public Integer getRefriUserSeq() {
		return RefriUserSeq;
	}
	public void setRefriUserSeq(Integer refriUserSeq) {
		RefriUserSeq = refriUserSeq;
	}
	
	public Integer getRefriFoodCpcty() {
		return RefriFoodCpcty;
	}
	public void setRefriFoodCpcty(Integer refriFoodCpcty) {
		RefriFoodCpcty = refriFoodCpcty;
	}
	
	
}
