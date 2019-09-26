package com.project.app.service;

import com.project.app.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseInterface {
	
	  /**
	 * method FindAll.
	 */
	  public Flux<Course> findAll();

	  /**
	 * method FindById.
	 */
	  public Mono<Course> findById(String id);

	  /**
	 * method save.
	 */
	  public Mono<Course> save(Course course);

	  /**
	 * method delete.
	 */
	  public Mono<Void> delete(Course course);

	  /**
	 * findByName.
	 */
	  public Flux<Course> findByName(String name);

}
