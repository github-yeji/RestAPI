package com.example.demo.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.model.User;
import com.example.demo.user.model.Project;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("info")
public class InfoController {
	private InfoService infoService;

	@Autowired
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}

	@GetMapping("/info")
	public Object projectInfo() {

		Project project = infoService.getProjectInfo();
		
		return project;

	}

	@GetMapping("/info2")
	public String customJson() {
		JsonObject jo = new JsonObject();

		jo.addProperty("ProjectName", "Sample_RestAPI");
		jo.addProperty("author", "hello-world");
		jo.addProperty("createDate", new Date().toString());

		JsonArray ja = new JsonArray();
		for (int i = 0; i < 5; i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop" + i, i);
			ja.add(jObj);
		}

		jo.add("follower", ja);

		return jo.toString();

	}

	@GetMapping("/userList")
	public Object userList() {
		List<User> userList = infoService.getUserList();
		return userList;
	}
	
	@GetMapping("cityListByCode/{countryCode}/{population}")
	public Object cityByCountryCode(@PathVariable("countryCode") String ctCode, @PathVariable("population") int population) {
		List<User> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);
		return cityList;
	}
	
}
