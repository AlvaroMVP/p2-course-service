package com.project.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.app.model.Course;
import com.project.app.repository.CourseRepository;
import com.project.app.service.CourseInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CourseServiceImpl implements CourseInterface {

	 /**
	   * Injected courseRepository.
	   */
	  @Autowired
	  private CourseRepository courseRepository;

	  /**
	   * Implement findAll.
	   */
	  @Override
	  public Flux<Course> findAll() {
	    return courseRepository.findAll();
	  }

	  /**
	   * Implement findById.
	   */
	  @Override
	  public Mono<Course> findById(String id) {
	    return courseRepository.findById(id);
	  }

	  /**
	   * Implement save.
	   */
	  @Override
	  public Mono<Course> save(Course course) {
	    return courseRepository.save(course);
	  }

	  /**
	   * Implement delete.
	   */
	  @Override
	  public Mono<Void> delete(Course course) {
	    return courseRepository.delete(course);
	  }

	  /**
	   * Implement findByName.
	   */
	  @Override
	  public Flux<Course> findByName(String name) {
	    return courseRepository.findByName(name);
	  }



}
