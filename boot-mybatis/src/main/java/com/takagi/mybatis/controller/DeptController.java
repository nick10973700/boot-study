package com.takagi.mybatis.controller;

import com.takagi.mybatis.bean.Dept;
import com.takagi.mybatis.mapper.DeptMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptMapper deptMapper;

    @GetMapping("/dept/{id}")
    public Dept getDept(@PathVariable("id") Integer id) {
        return deptMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Dept addDept(Dept dept) {
        deptMapper.insertDept(dept);
        return dept;
    }
}
