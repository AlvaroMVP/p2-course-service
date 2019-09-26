package com.project.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.project.app.model.Course;

import reactor.core.publisher.Flux;

public interface CourseRepository extends ReactiveMongoRepository<Course, String>{
	  /**
	 * findByName.
	 */
	  Flux<Course> findByName(String name);

}
