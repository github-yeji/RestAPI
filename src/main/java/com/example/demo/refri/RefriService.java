package com.example.demo.refri;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.food.Food;
import com.example.demo.food.FoodRepository;
import com.example.demo.refri.model.UserRefri;
import com.example.demo.refri.repository.RefriRepository;

@Service
public class RefriService {
	private final RefriRepository refriRepository;
	private final FoodRepository foodRepository;
	
	public RefriService(RefriRepository refriRepository, FoodRepository foodRepository){
		this.refriRepository = refriRepository;
		this.foodRepository = foodRepository;
	}
	
	public List<UserRefri> getUserRefri(){
		return this.refriRepository.findUserRefrigerator();
	}

	public Food findFood(Food food){
		return this.foodRepository.findfood(food);
	}

	public Integer clearRefri(UserRefri userRefri) {
		return this.refriRepository.clear(userRefri);
	}
	
	public UserRefri insert(UserRefri userRefri) {
		return this.refriRepository.insert(userRefri);
	}

	
}
