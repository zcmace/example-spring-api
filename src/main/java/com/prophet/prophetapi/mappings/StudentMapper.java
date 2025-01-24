package com.prophet.prophetapi.mappings;

import com.prophet.prophetapi.dto.StudentDto;
import com.prophet.prophetapi.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  StudentDto studentToStudentDto(Student student);

  Student studentDtoToStudent(StudentDto studentDto);
}