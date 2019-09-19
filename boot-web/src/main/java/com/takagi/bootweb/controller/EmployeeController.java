package com.takagi.bootweb.controller;

import com.takagi.bootweb.dao.EmployeeDao;
import com.takagi.bootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "list";
    }
}
