package com.project.app.model;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "course")
public class Course {
  @Id
  public String idCourse;
  @NotEmpty(message = "'name' cannot be empty!")
  public String name;
  @NotEmpty(message = "'teacherID' cannot be empty!")
  public String idTeacher;
  @NotEmpty(message = "'studentID' No debe ser vacio!")
  public String idStudent;
  @NotEmpty(message = "status cannot be empty!")
  public String status;
  public String capmax;
  public String capmin;
}
