package com.egabiproject;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {

        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponse createStudent(StudentRequest request) {

        if(studentRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Student student = studentMapper.toEntity(request);

        return studentMapper.toResponse(
                studentRepository.save(student)
        );
    }

    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudent(Long id) {

        Student student = studentRepository.findById(id).get();

        return studentMapper.toResponse(student);
    }

    public StudentResponse updateStudent(Long id,
                                         StudentRequest request) {

        Student student = studentRepository.findById(id).get();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setFacultyId(request.getFacultyId());
        student.setLevel(request.getLevel());

        return studentMapper.toResponse(
                studentRepository.save(student)
        );
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }
}