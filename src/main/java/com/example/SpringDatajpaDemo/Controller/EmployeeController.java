package com.example.SpringDatajpaDemo.Controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringDatajpaDemo.Model.Employee;
import com.example.SpringDatajpaDemo.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/jpa")
public class EmployeeController {
	
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	@Operation(summary = "Add multiple employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employees added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
	@PostMapping("/add")
	public Employee adding(@RequestBody Employee e) {
		logger.trace("Employee added successfully");
		return employeeService.add(e);
	}
	@Operation(summary = "Get Employee by EmployeeId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",description = "get the employee"),
			@ApiResponse(responseCode = "404",description = "null")
	})
	@GetMapping("/{id}")
	public Optional<Employee> findEmp(@PathVariable("id")Long id)throws AccountNotFoundException {
		logger.warn("Emp details by id retrived");
		return employeeService.findby(id);
		
	}
	
	@GetMapping("/all")
	public List<Employee>findAll(){
		logger.warn("employee details fully retrive");
		return employeeService.findAllEmp();
	}
	@DeleteMapping("/del/{id}")
	public String del(Long id) {
		logger.debug(" Id deleted success fully ");
		return employeeService.del(id);
	}
	@PutMapping("/up/{id}")
	public Employee up(@RequestBody Employee e, @PathVariable("id")Long id) {
		logger.trace("Updated");
		return employeeService.up(e, id);
	}
	@GetMapping("/c/{age}")
	public List<Employee> ch(@PathVariable("age")int age) {
		logger.info("Requirment retrived");
		return employeeService.checkAge(age);
	}
	@GetMapping("/c/{age}/{salary}")
	public List<Employee>ca(@PathVariable("age")int age ,@PathVariable("salary")Integer salary){
		logger.warn("Retrived successfully");
		return employeeService.checkageandsalary(age, salary);
		
	}
	@GetMapping("/d/{dept}")
	public List<Employee>de(@PathVariable("dept")String dept){
		return employeeService.checkdepa(dept);
	}
	@GetMapping("/k/{year}")
	public List<Employee>less(@PathVariable("year")Integer year){
		return employeeService.jdateless(year);
	}
	@GetMapping("/demo")
	public String demo(@RequestParam String name) {
		return "Hello"+name;
	}
	@PostMapping("/addAll")
	ResponseEntity<List<Employee>>adal(List<Employee>e){
		List<Employee>employees=employeeService.addAlling(e);
		return new ResponseEntity<>(employees,HttpStatus.CREATED);
	}
	@PostMapping("/up")
	public ResponseEntity<?>uploadfile(@RequestParam("image")MultipartFile[] file){
		logger.info("{}number of file uploaded"+file.length);
		return ResponseEntity.ok("Uploaded");
	}

}
