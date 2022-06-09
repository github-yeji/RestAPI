package com.example.demo.refri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.food.Food;
import com.example.demo.refri.model.UserRefri;

@RestController
@RequestMapping("refri")
public class RefriController {
	private RefriService refriService;

	@Autowired
	public RefriController(RefriService refriService) {
		this.refriService = refriService;
	}
	
	@GetMapping("/userRefri")
	public Object userRefri() {
		List<UserRefri> userRefri = refriService.getUserRefri();
		return userRefri;
	}
	
	@GetMapping("/clearfood")
	public ResponseEntity<String> refriclear(@RequestBody UserRefri userRefri) {
		try {
			Integer deletedCnt =refriService.clearRefri(userRefri);
			return new ResponseEntity<>(String.format("%d deleted", deletedCnt), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("refriclear Error!!!!!!!!! " +e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/refriUpdate")
	public ResponseEntity<UserRefri> refriAdd(@RequestBody UserRefri userRefri) {
		try {
//			UserRefri userRefri = new UserRefri();
//			
//			
//			
//			
//			refriService.findFood(food);
//			
//			System.out.println("해당 식재료 찾기 완료 >>" + food);
//			userRefri.setRefriUserSeq(food.getRefriUserSeq());
//			System.out.println("RefriUserSeq >> " +userRefri.getRefriUserSeq());
//			userRefri.setFoodCode(food.getCdId());
//			System.out.println("FoodCode >> " +userRefri.getFoodCode());
//			
			
			refriService.clearRefri(userRefri);
			System.out.println("식재료 클리어 완료");
			
			
			return new ResponseEntity<>(refriService.insert(userRefri), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("refriAdd Error!!!!!!!!! " +e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
