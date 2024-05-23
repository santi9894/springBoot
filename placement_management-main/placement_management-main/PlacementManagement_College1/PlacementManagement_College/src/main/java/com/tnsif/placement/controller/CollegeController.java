package com.tnsif.placement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.placement.entity.College;
import com.tnsif.placement.repository.CollegeRepository;



@RestController
@RequestMapping("/college")
@CrossOrigin(origins = "http://localhost:4200")
public class CollegeController {

	@Autowired
	private CollegeRepository collegeRepo;

	@GetMapping("/{id}")
	public College getCollegeById(@PathVariable Long id) {
		return collegeRepo.findById(id).get();
	}

	@GetMapping
	public List<College> getAllColleges() {
		return collegeRepo.findAll();
	}

	@PostMapping
	public College createCollege(@RequestBody College college) {
		return collegeRepo.save(college);
	}

	@PutMapping("/{id}")
	public College updateCollege(@PathVariable Long id, @RequestBody College college) {

		college.setId(id);
		return collegeRepo.save(college);
	}

	@DeleteMapping("/{id}")
	public void deleteCollegeById(@PathVariable Long id) {
		collegeRepo.deleteById(id);
	}
}
