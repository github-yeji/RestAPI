package com.example.demo.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.recipe.domain.Recipe;
import com.example.demo.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
    
    @Autowired
    RecipeService recipeService;
    
    private Recipe recipe;
    
    //setter 주입
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    //  메인 홈
    @RequestMapping(value="/board/intro", method=RequestMethod.GET)
    public String intro() throws Exception{
        return "/intro";
    }
    
    //  레시피 목록 보기--------------------------------------------------------------------------------------
    @RequestMapping(value="/board/list/{user_seq}", method = RequestMethod.GET)
    public String list(Model model, Recipe recipe, @PathVariable Integer user_seq) throws Exception{
        
        List<Recipe> list = recipeService.getRecipeList(recipe);
        model.addAttribute("list", list);
        
        model.addAttribute("user_seq", user_seq);
        
        return "/list";
        
    }
    
    //  레시피 상세 보기--------------------------------------------------------------------------------------
    @RequestMapping(value="/board/detail/{user_seq}/{recipe_seq}", method = RequestMethod.GET)
    public String detail(Model model, Model model1, Recipe recipe, @PathVariable Integer user_seq) throws Exception{
        
    	List<Recipe> list = recipeService.getRecipeDt2(recipe);
        model.addAttribute("list", list);
        
        int recipe_seq = recipe.getRecipe_seq();
        //String recipe_img_url = recipe.getRecipe_img_url();
        
        model.addAttribute("recipe_seq", recipe_seq); System.out.println(recipe_seq);
        model.addAttribute("user_seq", user_seq); System.out.println(user_seq);
            //레시피 재료
            List<Recipe> irdnt = recipeService.getIrdnt(recipe);
            model1.addAttribute("irdnt", irdnt);
            String cd_nm = recipe.getCd_nm();
            model1.addAttribute("cd_nm", cd_nm);
            
        return "/detail";
    }
    
 // 레시피 작성 페이지-------------------------------------------------------------------------------------
    @RequestMapping(value="/board/write/{user_seq}")
    public String writePage(Model model, Recipe recipe, @PathVariable Integer user_seq) throws Exception{
        
        model.addAttribute("user_seq", user_seq);
        
        System.out.println("유저 :"  + user_seq);
        
        return "/write";
    }
    // 레세피 작성 기능
    @RequestMapping(value="/board/writting", method=RequestMethod.POST)
    public String write(Model model, Recipe recipe) throws Exception{
        recipeService.insertRecipe(recipe);
        
        Integer user_seq = recipe.getUser_seq();
        model.addAttribute("user_seq", user_seq);
        System.out.println("유저번호 : " + user_seq);
        
        return "redirect:/board/list/" + user_seq;
    }
    
    
    //  레시피 수정 페이지------------------------------------------------------------------------------------
    @RequestMapping(value="/board/modify/{user_seq}/{recipe_seq}")
    public String modify(Model model, @PathVariable Integer user_seq, @PathVariable Integer recipe_seq) throws Exception{
        
        List<Recipe> list =recipeService.getRecipeDt(recipe_seq);
        Recipe recipe = list.get(0);
        recipeService.updateRecipe(recipe);
        
        model.addAttribute("recipe_seq", recipe_seq);
        model.addAttribute("recipe", recipe);
        model.addAttribute("user_seq", user_seq);
        
        
        return "/modify";
    }
    
    //  레시피 수정 기능
    @RequestMapping(value="/board/modify", method=RequestMethod.POST)
    public String modify(Recipe recipe, Model model) throws Exception{
        recipeService.updateRecipe(recipe);
        
        int recipe_seq = recipe.getRecipe_seq();
        Integer user_seq = recipe.getUser_seq();

        
        return "redirect:/board/detail/" + user_seq + "/" + recipe_seq;
    }
    
    //  레시피 삭제 ---------------------------------------------------------------------------안됨
    @RequestMapping(value="/board/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Integer recipe_seq, @PathVariable Integer user_seq, @PathVariable String use_yn, Recipe recipe, Model model) throws Exception{
        
        recipeService.deleteRecipe(recipe_seq);
        
        model.addAttribute("user_seq", user_seq);
        model.addAttribute("recipe_seq", recipe_seq);
        model.addAttribute("use_yn", use_yn);
        
        return "/board/detail/" + user_seq + "/" + recipe_seq;
    }
    
    
    //  요리법 상세 작성 페이지
    @RequestMapping(value="/board/cook/{user_seq}/{recipe_seq}")
    public String cookPage(Model model, Recipe recipe, @PathVariable Integer user_seq ,@PathVariable Integer recipe_seq) throws Exception{
       
        List<Recipe> list =recipeService.getRecipeDt(recipe_seq);
        
        int cooking_no = recipe.getCooking_no();
        
        model.addAttribute("cooking_no", cooking_no);
        
        return "/cook";
        
    }
    //  요리법 상세 작성 기능
    @RequestMapping(value="/board/cooking", method=RequestMethod.POST)
    public String cooking(Model model, Recipe recipe) throws Exception{
        recipeService.insertCooking(recipe);
        
        Integer user_seq = recipe.getUser_seq();
        Integer recipe_seq = recipe.getRecipe_seq();
        return "redirect:/board/list/"+user_seq;
        
    }
    
    //  요리법 삭제(DB에서 데이터 삭제)
}
