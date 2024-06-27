package com.example.SpringDatajpaDemo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDatajpaDemo.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	Employee findByEmail(String email);

	List<Employee> findByAgeLessThan(int age);

    List<Employee> findByAgeLessThanAndSalaryLessThan(int age, Integer salary);

    List<Employee> findByDept(String dept);
    List<Employee>findByYearLessThan(Integer year);
    //List<Employee>findByYearGreaterThan(Integer year);

}
