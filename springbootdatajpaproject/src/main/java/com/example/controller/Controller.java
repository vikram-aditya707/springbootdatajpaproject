package com.example.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

@RestController
@RequestMapping("/emp")
public class Controller {

    @Autowired
    private EmployeeDao dao;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return dao.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee searchEmployeeById(@PathVariable("id") int id) {

        Optional<Employee> byId = dao.findById(id);

        if (byId.isEmpty()) {
            return null;
        }

        return byId.get();
    }
}