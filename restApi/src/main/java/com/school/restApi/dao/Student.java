package com.school.restApi.dao;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
public class Student {
    @NonNull @Column(unique=true)
    private Integer id;

    //@Size(min=2) @NotBlank(message="Firstname is mandatory")
    private String firstName;

    //@Size(min=2) @NotBlank(message="Lastname is mandatory")
    private String lastName;

    //@Size(min=2) @NotBlank(message="Classname is mandatory")
    private String className;

    //@Size(min=3) @NotBlank(message="Nationality is mandatory")
    private String nationality;

}
