package com.example.springboot.Controller;

import com.example.springboot.entity.Country;
import com.example.springboot.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")

public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping
    public List<Country> index() {
        List<Country> all = countryMapper.findAll();
        return all;
    }

    //两个国家信息
    //接口路径：/user/countryName?name1=***&name2=***
    @GetMapping("/countryName")
    public Map<String, Object> findCountry(@RequestParam String name1,
                                        @RequestParam String name2) {
        List<Country> data = countryMapper.selectCountry(name1, name2);
        Integer total = countryMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
