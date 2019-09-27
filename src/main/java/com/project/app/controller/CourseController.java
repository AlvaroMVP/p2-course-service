package com.project.app.controller;

import com.project.app.model.Course;
import com.project.app.service.CourseInterface;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1.0")
public class CourseController {

  /**
 * Injected service.
 */
  @Autowired
  private CourseInterface service;

  /**
 * . method to list students
*/
  @GetMapping("/course")
  public Mono<ResponseEntity<Flux<Course>>> findAll() {
    return Mono.just(
    ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(service.findAll()));
  }

  /**
  * . method to search students by id
 */
  @GetMapping("/courses/{id}")
  public Mono<ResponseEntity<Course>> findById(@PathVariable final String id) {
    return service.findById(id)
    .map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
    .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   **. method to search by name
  */
  @GetMapping("/courses/name/{name}")
  public Flux<ResponseEntity<Course>> findByName(@PathVariable String name) {
    return service.findByName(name).map(p -> ResponseEntity.ok()
    .contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
  .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * . Service save
   */
  @PostMapping("/course")
  public Mono<ResponseEntity<Course>> newCourse(@Valid @RequestBody final Course course) {
    return service.save(course)
    .map(addCourse -> new ResponseEntity<>(addCourse, HttpStatus.CREATED))
    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.CONFLICT));
  }

  /**
  * . method to update a student
  **/
  @PutMapping("/courses/{id}")
  public Mono<ResponseEntity<Course>> updateTeacher(@PathVariable(value = "id") final String id,
      @Valid @RequestBody final Course course) {
    return service.findById(id)
    .flatMap(existingCourse -> {
      existingCourse.setName(course.getName());
      existingCourse.setStatus(course.getStatus());
      existingCourse.setCapmax(course.getCapmax());
      existingCourse.setCapmin(course.getCapmin());
      return service.save(existingCourse);
    })
      .map(updateCourse -> new ResponseEntity<>(updateCourse, HttpStatus.CREATED))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
  *.method to delete a student by id
  */
  @DeleteMapping("/courses/{id}")
  public Mono<ResponseEntity<Void>> deleteCourse(@PathVariable(value = "id") final String id) {
    return service.findById(id)
    .flatMap(existingCourse -> service.delete(existingCourse)
    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
