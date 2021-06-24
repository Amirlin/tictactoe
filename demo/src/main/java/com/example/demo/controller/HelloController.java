package com.example.demo.controller;

import com.example.demo.dto.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {
        private Student student=null;

    @GetMapping("/hello")
    public Student  sayHello(){
        return student;
    }
    @PostMapping("/hello")
    public Student  sayHello(@RequestBody @Valid Student body){
        this.student=body;
        return body;
    }
}
