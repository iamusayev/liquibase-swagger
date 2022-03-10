package com.example.testingswagger.service;


import com.example.testingswagger.dao.entity.StudentEntity;
import com.example.testingswagger.dao.repository.StudentRepository;
import com.example.testingswagger.mapper.StudentMapper;
import com.example.testingswagger.model.constants.ExceptionConstants;
import com.example.testingswagger.model.dto.StudentDto;
import com.example.testingswagger.model.enums.Status;
import com.example.testingswagger.model.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.testingswagger.mapper.StudentMapper.mapEntityToDto;
import static com.example.testingswagger.model.constants.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {


    private final StudentRepository repository;


    public void createStudent(StudentDto dto) {
        log.info("ActionLog.createStudent.start id : {}", dto.getId());

        repository.save(StudentMapper.mapDtoToEntity(dto));

        log.info("ActionLog.creatStudent.end id : {}", dto.getId());
    }

    public StudentDto getStudent(Long id) {
        log.info("ActionLog.getStudent.start id: {}", id);

        StudentDto dto = StudentMapper.mapEntityToDto(fetchStudentIfExist(id));

        log.info("ActionLog.getStudent.end id: {}", id);

        return dto;
    }


    public List<StudentDto> getStudents() {
        log.info("ActionLog.getStudents.start");

        List<StudentDto> dtos = repository
                .findAll()
                .stream()
                .map(StudentMapper::mapEntityToDto)
                .collect(Collectors.toList());

        log.info("ActionLog.getStudents.end");
        return dtos;
    }


    public void deleteStudent(Long id) {
        log.info("ActionLog.deleteStudent.start id: {}", id);

        StudentEntity entity = fetchStudentIfExist(id);
        entity.setStatus(Status.REMOVED);
        repository.save(entity);

        log.info("ActionLog.deleteStudent.end id: {}", id);
    }


    public void updateStudent(Long id, StudentDto dto) {
        log.info("ActionLog.updateStudent.start id: {}", id);

        StudentEntity entity = fetchStudentIfExist(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        repository.save(entity);

        log.info("ActionLog.updateStudent.end id: {}", id);
    }


    public void updateStudentName(Long id, String name) {
        log.info("ActionLog.updateStudentName.start id: {}", id);

        StudentEntity entity = fetchStudentIfExist(id);
        entity.setName(name);
        repository.save(entity);

        log.info("ActionLog.updateStudentName.end id: {}", id);
    }


    public void updateStudentSurname(Long id, String surname) {
        log.info("ActionLog.updateStudentLastname.start id: {}", id);

        StudentEntity entity = fetchStudentIfExist(id);
        entity.setSurname(surname);
        repository.save(entity);

        log.info("ActionLog.updateStudentLastname.end id: {}", id);
    }


    public void updateStudentAge(Long id, Integer age) {
        log.info("ActionLog.updateStudentAge.start id: {}", id);

        StudentEntity entity = fetchStudentIfExist(id);
        entity.setAge(age);
        repository.save(entity);

        log.info("ActionLog.updateStudentAge.start id: {}", id);
    }


    private StudentEntity fetchStudentIfExist(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> {
                    log.error("ActionLog.fetchStudentIfExist.error id : {}", id);
                    throw new NotFoundException(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
                });
    }

}
