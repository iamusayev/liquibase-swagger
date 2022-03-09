package com.example.testingswagger.dao.entity;


import com.example.testingswagger.model.enums.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Status status;

}
