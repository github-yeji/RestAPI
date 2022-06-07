package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.City;
import com.example.demo.model.Project;
import com.example.demo.repository.CityRepository;

@Service
public class InfoService {
	private final CityRepository cityRepository;

	@Autowired
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public Project getProjectInfo() {

		Project project = new Project();
		project.projectName = "restAPI-sample";
		project.author = "hello-bryan";

		return project;
	}

	public List<City> getCityList() {
		return this.cityRepository.findList();
	}

	public List<City> findCityByCodeAndPopulation(String countryCode, int population) {
		return this.cityRepository.findByCountryCodeAndPopulation(countryCode, population);
	}
}
