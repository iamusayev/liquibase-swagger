package com.example.testingswagger.contoller;


import com.example.testingswagger.model.dto.StudentDto;
import com.example.testingswagger.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registration student", description = "we can register our user")
    public void createStudent(@RequestBody StudentDto dto) {
        service.createStudent(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get  student by id", description = "For use this method you need to input some ID")
    public StudentDto getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @GetMapping
    @Operation(summary = "Get all students", description = "For use this method you don't need to input ID")
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestBody StudentDto dto) {
        service.updateStudent(id, dto);
    }

    @PatchMapping("/{id}/name")
    public void updateStudentName(@PathVariable Long id,
                                  @RequestParam(value = "value") String name) {
        service.updateStudentName(id, name);
    }

    @PatchMapping("/{id}/surname")
    public void updateStudentLatname(@PathVariable Long id,
                                     @RequestParam(value = "value") String surname) {
        service.updateStudentSurname(id, surname);
    }

    @PatchMapping("/{id}/age")
    public void updateStudentAge(@PathVariable Long id,
                                 @RequestParam(value = "value") Integer age) {
        service.updateStudentAge(id, age);
    }
}
