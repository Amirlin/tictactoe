package com.example.demo.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class Student{

    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String institute;
    @NotNull
    private LocalDate birthdate;
}