package com.example.testingswagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class StudentDto {


    private String name;

    private String surname;

    private Integer age;

    private Long id;

}
