create table students
(
    id         SERIAL primary key,
    first_name  varchar(255)  not null,
    last_name   varchar(255)  not null,
    grade_level varchar(50)   null,
    gpa         decimal(3, 2) null
);

INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('John', 'Doe', 'FRESHMAN', 3.50);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Jane', 'Smith', 'SOPHOMORE', 3.80);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Michael', 'Johnson', 'JUNIOR', 3.20);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('Emily', 'Davis', 'SENIOR', 3.90);
INSERT INTO students (first_name, last_name, grade_level, gpa) VALUES ('David', 'Clark', 'SENIOR', 3.60);

