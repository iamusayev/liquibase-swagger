package com.example.testingswagger.service;


import com.example.testingswagger.dao.entity.StudentEntity;
import com.example.testingswagger.dao.repository.StudentRepository;
import com.example.testingswagger.mapper.StudentMapper;
import com.example.testingswagger.model.dto.StudentDto;
import com.example.testingswagger.model.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.testingswagger.mapper.StudentMapper.mapEntityToDto;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository repository;


    public void createStudent(StudentDto dto) {
        repository.save(StudentMapper.mapDtoToEntity(dto));
    }

    public StudentDto getStudent(Long id) {
        return mapEntityToDto(fetchStudentIfExist(id));
    }


    public List<StudentDto> getStudents() {
        return repository
                .findAll()
                .stream()
                .map(StudentMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }


    public void deleteStudent(Long id) {
        StudentEntity entity = fetchStudentIfExist(id);
        entity.setStatus(Status.REMOVED);
        repository.save(entity);
    }


    public void updateStudent(Long id, StudentDto dto) {
        StudentEntity entity = fetchStudentIfExist(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        repository.save(entity);
    }


    public void updateStudentName(Long id, String name) {
        StudentEntity entity = fetchStudentIfExist(id);
        entity.setName(name);
        repository.save(entity);
    }


    public void updateStudentSurname(Long id, String surname) {
        StudentEntity entity = fetchStudentIfExist(id);
        entity.setSurname(surname);
        repository.save(entity);
    }


    public void updateStudentAge(Long id, Integer age) {
        StudentEntity entity = fetchStudentIfExist(id);
        entity.setAge(age);
        repository.save(entity);
    }


    private StudentEntity fetchStudentIfExist(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("STUDENT_NOT_FOUND"));
    }


}
