package com.example.demo.recipe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.recipe.domain.Recipe;

public interface RecipeService {
	//  레시피 목록 보기(앱)
    public List<Recipe> getRecipeList2(int recipe_seq) throws Exception;
	
	//  레시피 목록 보기(웹)
    public List<Recipe> getRecipeList(Recipe recipe) throws Exception;
    
    //  레시피 상세내용
    public List<Recipe> getRecipeDt(int recipe_seq) throws Exception;
    
    //  레시피 상세내용2
    public List<Recipe> getRecipeDt2(Recipe recipe) throws Exception;
    
    //  레시피 재료
    public List<Recipe> getIrdnt(Recipe recipe) throws Exception;
    
    // 레시피 작성
    public void insertRecipe(Recipe recipe) throws Exception;
    
    //  레시피 수정
    public void updateRecipe(Recipe recipe) throws Exception;
    
    //  레시피 삭제
    public int deleteRecipe(int recipe_seq) throws Exception;
    
    //  레시피 요리법 작성
    public void insertCooking(Recipe recipe) throws Exception;
    
    //  레시피 요리법 삭제
    public int deleteCooking(int recipe_seq) throws Exception;

    
}
