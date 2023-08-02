package com.example.springboot.entity;

import lombok.Data;

@Data
public class Country {
    private String Name;
    private Integer SurfaceArea;
    //    @JsonIgnore
    private Integer Population;
    private Integer LifeExpectancy;
    private Integer GNP;

}