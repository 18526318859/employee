package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao department;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection <Employee> alls = employeeDao.getAll ( );
        model.addAttribute ( "emps",alls );
        return "emp/list";
    }
    @GetMapping("/emp")
    public String addpage(Model model){
        Collection <Department> departments = department.getDepartments ( );
        model.addAttribute ( "departments",departments );

        return "emp/add";
    }
    @PostMapping("/emp")
    public String addemp(Employee e){
        System.out.println (e);
        employeeDao.save ( e );
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}") //从路径中取参
    public String toUpdate(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployById ( id );
        Collection <Department> departments = department.getDepartments ( );
        model.addAttribute("emp",employee);
        model.addAttribute ( "departments",departments );
        return "emp/update";
    }

    @PostMapping("/toupdate")
    public String Update(Employee employee){
        employeeDao.save(employee);
        return  "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public  String todelete(@PathVariable("id")Integer id,Model model)
    {
        employeeDao.delete (id);
        return  "redirect:/emps"; //重定向到/emps
    }


}
