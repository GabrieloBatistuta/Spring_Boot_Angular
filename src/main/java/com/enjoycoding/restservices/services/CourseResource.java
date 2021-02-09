package com.enjoycoding.restservices.services;

import com.enjoycoding.restservices.entity.Course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
// http://localhost:8080/api/v1/title
@RequestMapping("api/v1")
public class CourseResource {


	private final CourseService courseService;
	
	public CourseResource(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("title")
	public String retriveTitle() {
		return "Learn Angular and Spring Boot";
	}

	@GetMapping("course")
	public Course retrieveCourse() {
		return new Course(Long.valueOf(1), "Learn Angular and Spring Boot", new BigDecimal("299.99"), new Date(), 3);
	}

	@GetMapping("courses")
	public List<Course> findAll() {
		return courseService.findAll();
	}

	// Der Aufruf sieht so aus! http://localhost:8080/api/v1/courses/1000
	@GetMapping("courses/{id}")
	public Course findCourse(@PathVariable Long id) {
		return courseService.findById(id);
	}

	@DeleteMapping("courses/{id}")
	public ResponseEntity<Void> deletCourse(@PathVariable Long id) {
		if (courseService.findById(id) != null) {
			courseService.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("courses/{id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course body, @PathVariable Long id) {
		Course course = courseService.findById(id);

		if (course == null) {
			return ResponseEntity.notFound().build();
		}
		Course updatedCourse = courseService.save(body);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
	}

	@PostMapping("courses")
	public ResponseEntity<Course> createCourse(@RequestBody Course body) {
		Course createCourse = courseService.save(body);
		return new ResponseEntity<Course>(createCourse, HttpStatus.CREATED);
	}
}
