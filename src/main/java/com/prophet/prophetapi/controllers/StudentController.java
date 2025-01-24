package com.prophet.prophetapi.controllers;

import com.prophet.prophetapi.dto.StudentDto;
import com.prophet.prophetapi.dto.StudentSearchRequest;
import com.prophet.prophetapi.model.Student;
import com.prophet.prophetapi.services.StudentService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping()
  private Page<StudentDto> getAllStudents() {
    return new PageImpl<>(studentService.getAllStudents());
  }

  @PostMapping("/search")
  private Page<StudentDto> searchStudents(@RequestBody StudentSearchRequest studentSearchRequest) {
    return studentService.searchStudents(studentSearchRequest);
  }


}
