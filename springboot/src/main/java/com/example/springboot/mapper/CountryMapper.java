package com.example.springboot.mapper;

import com.example.springboot.entity.Country;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface CountryMapper {
    @Select("select * from country")
    List<Country> findAll();

    @Select("select * from country where Name = #{name1} or Name = #{name2}")
    List<Country> selectCountry(String name1, String name2);

    @Select("select count(*) from country")
    Integer selectTotal();
}
