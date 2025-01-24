package com.prophet.prophetapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "grade_level")
  @Enumerated(EnumType.STRING)
  private GradeLevel gradeLevel;
  @Column(name = "gpa")
  private Double gpa;

  public enum GradeLevel {
    FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
  }
}
