package com.prophet.prophetapi.services;

import com.prophet.prophetapi.dto.StudentDto;
import com.prophet.prophetapi.dto.StudentSearchRequest;
import com.prophet.prophetapi.exception.ContentNotFoundException;
import com.prophet.prophetapi.mappings.StudentMapper;
import com.prophet.prophetapi.model.Student;
import com.prophet.prophetapi.repository.StudentRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
    this.studentRepository = studentRepository;
    this.studentMapper = studentMapper;
  }

  public List<StudentDto> getAllStudents() {
    if (studentRepository.count() == 0) {
      throw new ContentNotFoundException("No students found");
    }
    return studentRepository.findAll().stream().map(studentMapper::studentToStudentDto).toList();
  }

  public Page<StudentDto> searchStudents(StudentSearchRequest studentSearchRequest) {
    // playing around with Example, ExampleMatcher, and Pageable to create simple filterable, pageable search api
    Student student = new Student();
    student.setFirstName(studentSearchRequest.getFirstName());
    student.setLastName(studentSearchRequest.getLastName());
    student.setGradeLevel(studentSearchRequest.getGradeLevel());
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreNullValues();
    Example<Student> example = Example.of(student, matcher);
    Sort sortDetails = Sort.by(Sort.Direction.fromString(studentSearchRequest.getSortDirection()), "firstName");
    Page<StudentDto> results = studentRepository
        .findAll(example, PageRequest.of(studentSearchRequest.getPageNumber(), studentSearchRequest.getPageSize(), sortDetails))
        .map(studentMapper::studentToStudentDto);
    if (results.isEmpty()) {
      throw new ContentNotFoundException("No students found");
    }
    return results;
  }
}
