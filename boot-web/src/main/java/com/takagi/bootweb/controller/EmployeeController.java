package com.takagi.bootweb.controller;

import com.takagi.bootweb.dao.DepartmentDao;
import com.takagi.bootweb.dao.EmployeeDao;
import com.takagi.bootweb.entities.Department;
import com.takagi.bootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查询部门信息
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model) {
        //查询部门信息
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        //获取员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String saveEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
