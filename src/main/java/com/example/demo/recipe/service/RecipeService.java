package com.example.demo.recipe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.recipe.domain.Recipe;

public interface RecipeService {
    
	 //  레시피 목록 보기
    public List<Recipe> getRecipeList(Integer user_seq) throws Exception;
    
    //  레시피 목록 보기2 (현재 사용중인것)
    public List<Recipe> getRecipeList2(Recipe recipe) throws Exception;
    
    //  레시피 상세내용
    public List<Recipe> getRecipeDt(int recipe_seq) throws Exception;
    
    //  레시피 상세내용2 (현재 사용중인것)
    public List<Recipe> getRecipeDt2(Recipe recipe) throws Exception;
    
    // 레시피 작성3
    public void insertRecipe(Recipe recipe) throws Exception;
    
    //  레시피 수정
    public void updateRecipe(Recipe recipe) throws Exception;
    
    public int updateRecipe2(Recipe recipe) throws Exception;
    
    //  레시피 삭제
    public int deleteRecipe(int recipe_seq) throws Exception;
    
    //  레시피 요리법 작성
    public void insertCooking(Recipe recipe) throws Exception;
    
    //  레시피 요리법 수정(레시피 수정3에서 같이 실행)
    
    //  레시피 요리법 삭제
    public int deleteCooking(int recipe_seq) throws Exception;

    
}
