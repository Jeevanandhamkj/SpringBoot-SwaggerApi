package com.example.SpringDatajpaDemo.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.example.SpringDatajpaDemo.Model.Employee;
import com.example.SpringDatajpaDemo.Repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo employeeRepo;
	
	EmployeeService(EmployeeRepo employeeRepo){
		this.employeeRepo=employeeRepo;
	}

	public Employee add(Employee e) {
		
		Employee employee= employeeRepo.findByEmail(e.getEmail());
		if(employee !=null) {
			throw new UserDetailsAlreadyExistException("Email already there");
		}
		else {
			return employeeRepo.save(e);
		}
	}
	public List<Employee>addAlling(List<Employee> employees){
		return employeeRepo.saveAll(employees);
	}
	public List<Employee>findAllEmp(){
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> findby(Long id) throws AccountNotFoundException {
		Optional<Employee>eOptional=employeeRepo.findById(id);
		if(eOptional.isPresent()) {
			return employeeRepo.findById(id);
		}
		else {
			throw new AccountNotFoundException("user id not found");
		}
	}
	
	public String del(Long id) {
		employeeRepo.deleteById(id);
		return "id delete successfully";
	}
	
	public Employee up(Employee e,Long id) {
		Employee employee=employeeRepo.findById(id).get();
		employee.setId(e.getId());
		employee.setDept(e.getDept());
		employee.setName(e.getName());
		employee.setAge(e.getAge());
		employee.setEmail(e.getEmail());
		employee.setMobile(e.getMobile());
		employee.setSalary(e.getSalary());
		employee.setYear(e.getYear());
		
		return employeeRepo.save(employee);
	}
	
	
	
	public List<Employee> checkAge(int age) {
		return employeeRepo.findByAgeLessThan(age)	;	
	}
	
	public List<Employee>checkageandsalary(int age,Integer salary){
		return employeeRepo.findByAgeLessThanAndSalaryLessThan(age,salary);
	}
	
	public List<Employee>checkdepa(String dept){
		return employeeRepo.findByDept(dept);
	}
	
	public List<Employee>jdateless(Integer year){
		return employeeRepo.findByYearLessThan(year);
	}
}
