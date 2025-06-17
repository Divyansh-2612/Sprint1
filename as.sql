CREATE TABLE Student (
    student_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    student_name VARCHAR2(100) NOT NULL,
    student_email VARCHAR2(100) UNIQUE NOT NULL,
    student_college VARCHAR2(100)
);