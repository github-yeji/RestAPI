package com.example.demo.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recipe.domain.Recipe;
import com.example.demo.user.UserService;
import com.example.demo.user.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.demo.recipe.service.RecipeService;

@RequestMapping(value = "/recipe")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    
    //  레시피 목록 보기2 (앱)
    @GetMapping("/user/{user_seq}")
    public List<Recipe> getRecipeList2(@PathVariable("user_seq") Integer user_seq ) throws Exception{
        
        List<Recipe> result = recipeService.getRecipeList2(user_seq);
        System.out.println("유저 번호 ========================================  "+user_seq);
        System.out.println("유저 정보 : "+ result);
        
        return result;
    }
    
    
    // 레시피 상세 내용2(+레시피 요리법)--------------------------------------------------------------------------
    @GetMapping("/{recipe_seq}")
    public List<Recipe> getRecipeDt2(@PathVariable("recipe_seq") int recipe_seq ) throws Exception{
        List<Recipe> result = recipeService.getRecipeDt(recipe_seq);
        System.out.println("레시피 번호 ========================================  "+recipe_seq);
        System.out.println("레시피 정보 : "+ result);
        
        return result;
    }
    
    //  레시피 재료
    @GetMapping("/irdnt/{recipe_seq}")
    public List<Recipe> getIrdnt(@PathVariable("recipe_seq") int recipe_seq, Recipe recipe ) throws Exception{
        List<Recipe> result = recipeService.getIrdnt(recipe);
        System.out.println("레시피 번호 :"+recipe_seq);
        System.out.println("레시피 재료 정보 : "+ result);
        
        return result;
    }
    
    // 레시피 작성--------------------------------------------------------------------------------------------
    @PostMapping("/write")
    public Recipe insertRecipe(@RequestBody Recipe recipe) throws Exception{
        System.out.println("글 작성 중");
        
        int recipe_seq = recipe.getRecipe_seq();
        System.out.println("새로운 글 번호 : "+recipe_seq);
        System.out.println(recipe);
        
        //이클립스에선 recipe_seq도 정상적으로 나오나, postman에선 0으로 출력됨
        
        recipeService.insertRecipe(recipe);
        return recipe;
    }
    
    // 레시피 수정--------------------------------------------------------------------------------------------
    @PutMapping("/modify")
    public Recipe updateRecipe(@RequestBody Recipe recipe) throws Exception{
        //테스트할 때 전부 입력해야됨...
        int recipe_seq = recipe.getRecipe_seq();
        System.out.println("수정할 글 번호 : "+recipe_seq);
        System.out.println(recipe);
        recipeService.updateRecipe(recipe);
        return recipe;
    }
    
    // 레시피 삭제------------------------------------------------------------------------
    @PutMapping(value="/delete/{recipe_seq}", headers ="Accept=application/json")
    public Recipe deleteRecipe(@PathVariable("recipe_seq") int recipe_seq) throws Exception{
        
        //정상적으로 수정되나....json에서 use_yn가 null로 표기됨
        recipeService.deleteRecipe(recipe_seq);
        
        Recipe deleteRecipe =  new Recipe();
        deleteRecipe.setRecipe_seq(recipe_seq);
        
        System.out.println(deleteRecipe);
        
        return deleteRecipe;
    }
    
    // 레시피 요리법 작성(tb_cooking)
    @PostMapping("/writeCooking")
    public Recipe insertCooking(@RequestBody Recipe recipe) throws Exception{
        
        System.out.println("레시피의 요리법 작성 중-----");
        
        int recipe_seq = recipe.getRecipe_seq();
        System.out.println("작성할 레시피 번호 : "+recipe_seq);
        
        int cooking_seq = recipe.getCooking_no();
        System.out.println("작성할 레시피의 " + recipe + "번째 요리순서");
        
        System.out.println(recipe);
        
        recipeService.insertCooking(recipe);
        return recipe;
    }
    
    // 레시피 요리법 삭제(tb_cooking)
    @DeleteMapping("/deleteCooking")
    public Recipe deleteCooking(@PathVariable("recipe_seq") int recipe_seq) throws Exception{
        //해당 레시피번호의 조리법 전부 삭제(레시피 삭제와 다르게 수정X)
        recipeService.deleteCooking(recipe_seq);
        
        Recipe deleteCooking = new Recipe();
        deleteCooking.setRecipe_seq(recipe_seq);
        
        return deleteCooking;
        
    }
}
