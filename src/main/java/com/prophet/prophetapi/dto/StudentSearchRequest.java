package com.prophet.prophetapi.dto;

import com.prophet.prophetapi.model.Student;
import com.prophet.prophetapi.util.PageableRequest;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class StudentSearchRequest extends PageableRequest {
  @Schema(description = "First Name", example = "John", nullable = true)
  private String firstName;
  @Schema(description = "Last Name", example = "Smith", nullable = true)
  private String lastName;
  @Schema(description = "Grade Level", enumAsRef = true, nullable = true)
  private Student.GradeLevel gradeLevel;
}
