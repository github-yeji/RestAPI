package com.example.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.user.model.User;
import com.example.demo.user.model.Project;
import com.example.demo.user.repository.UserRepository;

@Service
public class InfoService {
	private final UserRepository userRepository;

	@Autowired
	public InfoService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Project getProjectInfo() {

		Project project = new Project();
		project.projectName = "restAPI-sample";
		project.author = "hello-bryan";

		return project;
	}

	public List<User> getUserList() {
		return this.userRepository.findList();
	}

	public List<User> findCityByCodeAndPopulation(String countryCode, int population) {
		return this.userRepository.findByCountryCodeAndPopulation(countryCode, population);
	}
}
