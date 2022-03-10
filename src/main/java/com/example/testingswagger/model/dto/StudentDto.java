package com.example.testingswagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Schema(description = "I create StudentDto class for get http method")
public class StudentDto {


    @Schema(description = "description for name field", name = "firstname")
    private String name;

    @Schema(description = "description for surname field", name = "lastname")
    private String surname;

    @Schema(hidden = true)
    private Integer age;

    private Long id;

}
