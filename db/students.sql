CREATE TABLE students
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    grade_level VARCHAR(50) NULL,
    gpa DECIMAL(3, 2) NULL
);

INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('John', 'Doe', 'FRESHMAN', 3.50);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Jane', 'Smith', 'SOPHOMORE', 3.80);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Michael', 'Johnson', 'JUNIOR', 3.20);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Emily', 'Davis', 'SENIOR', 3.90);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('David', 'Clark', 'SENIOR', 3.60);