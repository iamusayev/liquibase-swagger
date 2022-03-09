package com.example.testingswagger.mapper;

import com.example.testingswagger.dao.entity.StudentEntity;
import com.example.testingswagger.model.dto.StudentDto;
import com.example.testingswagger.model.enums.Status;

public class StudentMapper {

    public static StudentEntity mapDtoToEntity(StudentDto dto){
        return StudentEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .age(dto.getAge())
                .status(Status.DRAFT)
                .build();
    }

    public static StudentDto mapEntityToDto(StudentEntity entity){
        return StudentDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .build();
    }

}
