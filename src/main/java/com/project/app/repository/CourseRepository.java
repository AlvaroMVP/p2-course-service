package com.project.app.repository;

import com.project.app.model.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
  /**
  * findByName.
   */
  Flux<Course> findByName(String name);

}
