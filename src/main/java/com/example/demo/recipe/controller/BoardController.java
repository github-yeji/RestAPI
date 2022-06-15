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
        return "/board/intro";
    }
    
    //  레시피 목록 보기--------------------------------------------------------------------------------------
    @RequestMapping(value="/board/list/{user_seq}", method = RequestMethod.GET)
    public String list(Model model, Recipe recipe, @PathVariable Integer user_seq) throws Exception{
        //model.addAttribute("user_seq",recipeService.getRecipeList(user_seq));
        
        //model.addAttribute("recipe_seq",user_seq);
        
        List<Recipe> list = recipeService.getRecipeList2(recipe);
        model.addAttribute("list", list);
        
        model.addAttribute("user_seq", user_seq);
        
        return "/board/list";
        
    }
    
    //  레시피 상세 보기--------------------------------------------------------------------------------------
    @RequestMapping(value="/board/detail/{user_seq}/{recipe_seq}", method = RequestMethod.GET)
    public String detail(Model model, Model model1, Recipe recipe, @PathVariable Integer user_seq) throws Exception{
        
        List<Recipe> list = recipeService.getRecipeDt2(recipe);
        model.addAttribute("list", list);
        
        int recipe_seq = recipe.getRecipe_seq();
        model.addAttribute("recipe_seq", recipe_seq);
        model.addAttribute("user_seq", user_seq);
        
            //레시피 재료
//            List<Recipe> irdnt = recipeService.getIrdnt(recipe);
//            model1.addAttribute("irdnt", irdnt);
//            String cd_nm = recipe.getCd_nm();
//            model1.addAttribute("cd_nm", cd_nm);
        
        return "/board/detail";
    }
    
    // 레시피 작성 페이지-------------------------------------------------------------------------------------
    @RequestMapping(value="/board/write/{user_seq}")
    public String writePage(Recipe recipe) throws Exception{
        //많이 이상하게도 밑의 작성 기능과 중복되는 소스를 주석처리하고 실행하니 매우 느리게 반영됨
        //recipeService.insertRecipe(recipe);
        return "/board/write";
    }
    // 레세피 작성 기능
    @RequestMapping(value="/board/writting", method=RequestMethod.POST)
    public String write(Model model, Recipe recipe) throws Exception{
        //ModelAndView mav = new ModelAndView("redirect:/board/list/{user_seq}");
        recipeService.insertRecipe(recipe);
        
        
        //return mav;
        return "redirect:/board/write";
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
        
        return "/board/modify";
    }
    
    //  레시피 수정 기능
    @RequestMapping(value="/board/modify", method=RequestMethod.POST)
    public String modify(Recipe recipe, Model model) throws Exception{
        //ModelAndView mav = new ModelAndView("redirect:/board/list/{user_seq}");  //설마 로그인해야되나?
        recipeService.updateRecipe(recipe);
        
        int recipe_seq = recipe.getRecipe_seq();
        Integer user_seq = recipe.getUser_seq();
        String recipe_nm = recipe.getRecipe_nm();
        
        model.addAttribute("recipe_seq", recipe_seq);
        model.addAttribute("user_seq", user_seq);
        model.addAttribute("recipe_nm", recipe_nm);
        
        System.out.println("레시피 번호는 "+ recipe_seq);
        System.out.println("레시피 이름은 "+ recipe_nm);
        System.out.println("접속한 유저는 " + user_seq);
        
        //원래 public String modify에 return 값이 있었으나, 파라미터값을 포함하는 주소로 넘길줄 몰라 void로 변경
        //return mav;
        return "redirect:/board/detail/" + user_seq + "/" + recipe_seq;
    }
    
    //  레시피 삭제 ----------------------------------------------------------------------------------왠지 안됨
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(int recipe_seq, RedirectAttributes rttr) throws Exception{
        recipeService.deleteRecipe(recipe_seq);
        rttr.addFlashAttribute("result", "delete success");
        return "redirect:/board/detail";
    }
    
    
    //  요리법 상세 작성
    @RequestMapping(value="/board/cook")
    public String cookPage(Recipe recipe, Model model) throws Exception{
        recipeService.insertCooking(recipe);
        return "/board/cook";
        
    }
    //  요리법 상세 작성 기능
    @RequestMapping(value="/board/cooking")
    public ModelAndView cooking(Recipe recipe) throws Exception{
        ModelAndView mav = new ModelAndView("redirect:/board/list{user_seq}");
        recipeService.insertCooking(recipe);
        return mav;
        
    }
    
    //  요리법 삭제(DB에서 데이터 삭제)
}
