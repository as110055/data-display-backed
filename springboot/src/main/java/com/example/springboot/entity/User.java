package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
//    @JsonIgnore
    private String gender;
    private Integer age;
    private String education;

}
