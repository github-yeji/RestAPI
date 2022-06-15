package com.example.demo.recipe.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recipe.domain.Recipe;
import com.example.demo.recipe.mapper.RecipeMapper;

@Service
public class RecipeServiceImpl implements RecipeService{
    
	 @Autowired
	    private RecipeMapper recipeMapper;
	    
	    // 레시피 목록 보기
	    public List<Recipe> getRecipeList(Integer user_seq) throws Exception{
	        return recipeMapper.getRecipeList(user_seq);
	    }
	    
	    // 레시피 목록 보기2 (현재 사용중인것)
	    public List<Recipe> getRecipeList2(Recipe recipe) throws Exception {
	        return recipeMapper.getRecipeList2(recipe);
	    }
	    
	    //  레시피 상세내용
	    public List<Recipe> getRecipeDt(int recipe_seq) throws Exception{
	        return recipeMapper.getRecipeDt(recipe_seq);
	    }
	    
	    //  레세피 상세내용2 (현재 사용중인것)
	    public List<Recipe> getRecipeDt2(Recipe recipe) throws Exception {
	        return recipeMapper.getRecipeDt2(recipe);
	    }
	    
	    //레시피 작성3
	    @Override
	    public void insertRecipe(Recipe recipe) throws Exception {
	        // TODO Auto-generated method stub
	        recipeMapper.insertRecipe(recipe);
	    }
	    
	    //  레시피 수정
	    public void updateRecipe(Recipe recipe) throws Exception{
	        recipeMapper.updateRecipe(recipe);
	    }
	    
	    public int updateRecipe2(Recipe recipe) throws Exception{
	        return recipeMapper.updateRecipe2(recipe);
	    }
	    
	    //  레시피 삭제
	    public int deleteRecipe(int recipe_seq) throws Exception{
	        return recipeMapper.deleteRecipe(recipe_seq);
	    }
	    
	    //  레시피 요리법 작성
	    public void insertCooking(Recipe recipe) throws Exception {
	        recipeMapper.insertCooking(recipe);
	        
	    }
	    
	    // 레시피 요리법 수정(위의 레시피수정3에서 같이 실행)
	    
	    //  레시피 요리법 삭제
	    public int deleteCooking(int recipe_seq) throws Exception {
	        return recipeMapper.deleteCooking(recipe_seq);
	    }
    
}
