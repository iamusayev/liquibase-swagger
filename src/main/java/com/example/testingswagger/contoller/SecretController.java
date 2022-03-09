package com.example.testingswagger.contoller;


import com.example.testingswagger.dao.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/secret")
@RequiredArgsConstructor
@Hidden
@Tag(name = "Secret controller", description = "We can remove all students" )
public class SecretController {

    private final StudentRepository repository;

    @DeleteMapping
    public void deleteAllStudents(){
        repository.deleteAll();
    }

}
