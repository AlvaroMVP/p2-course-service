package com.project.app.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
