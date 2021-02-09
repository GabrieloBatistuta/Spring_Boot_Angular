package com.enjoycoding.restservices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoycoding.restservices.entity.Course;
import com.enjoycoding.restservices.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course save(Course object) {
		return courseRepository.save(object);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Course object) {
		courseRepository.deleteAll();

	}

}
