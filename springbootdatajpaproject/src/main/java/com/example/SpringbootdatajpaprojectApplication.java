package com.example;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

@SpringBootApplication
public class SpringbootdatajpaprojectApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdatajpaprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name and salary");

        employee.setName(scanner.nextLine());
        employee.setSalary(scanner.nextFloat());

        System.out.println("Add Operation");

        dao.save(employee);

        dao.findAll().forEach(a ->
                System.out.println(
                        a.getId() + "\t" +
                        a.getName() + "\t" +
                        a.getSalary()));

        scanner.close();
    }
}