package com.example.springboot.Controller;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user" )
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody User user){
        //新增或更新
        return userService.save(user);
    }

    @GetMapping
    public List<User> index() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }
    //分页查询
    //接口路径：/user/page?pageNum=1&pageSize=10
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
    //swagger
    @RequestMapping("/info")
    public String info(String id){
        return "Railgun1Ysr0z";
    }
    @ApiOperation(value = "用户测试",notes = "用户测试notes")
    @GetMapping("/test")
    public String test(String id){
        return "test";
    }
}
