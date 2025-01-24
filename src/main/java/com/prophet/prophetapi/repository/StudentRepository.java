package com.prophet.prophetapi.repository;

import com.prophet.prophetapi.dto.StudentDto;
import com.prophet.prophetapi.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Page<StudentDto> findBy(Example<Student> student, Pageable pageable);

}
