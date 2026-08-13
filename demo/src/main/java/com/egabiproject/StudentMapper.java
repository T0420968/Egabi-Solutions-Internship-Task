package com.egabiproject;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequest request);

    StudentResponse toResponse(Student student);
}