package com.egabiproject;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-13T03:46:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setFirstName( request.getFirstName() );
        student.setLastName( request.getLastName() );
        student.setEmail( request.getEmail() );
        student.setFacultyId( request.getFacultyId() );
        student.setLevel( request.getLevel() );

        return student;
    }

    @Override
    public StudentResponse toResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setStudentId( student.getStudentId() );
        studentResponse.setFirstName( student.getFirstName() );
        studentResponse.setLastName( student.getLastName() );
        studentResponse.setEmail( student.getEmail() );
        studentResponse.setFacultyId( student.getFacultyId() );
        studentResponse.setLevel( student.getLevel() );

        return studentResponse;
    }
}
