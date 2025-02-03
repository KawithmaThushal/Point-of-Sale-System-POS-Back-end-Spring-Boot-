package com.posSeystem.PosSystem.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.DTO.EmployeeDto;
import com.posSeystem.PosSystem.Entity.Employee;
import com.posSeystem.PosSystem.Service.Employeeservice;






@RestController
@CrossOrigin(origins = ("*"))
@RequestMapping("/Employee")

public class EmployeeController {
    
    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("/Add")
    public ResponseEntity<Employee> postMethodName(@RequestBody EmployeeDto entity) {
        Employee employee = new Employee();
        employee.setFname(entity.getFname());
        employee.setLname(entity.getLname());
        employee.setNIC(entity.getNIC());
        employee.setAdressa(entity.getAdressa());
        employee.setBirthday(entity.getBirthday());
        employee.setContactNumber(entity.getContactNumber());
        employee.setCity(entity.getCity());
        employee.setEmail(entity.getEmail());
        employee.setImage(entity.getImage().toString());

        Employee employee2 = employeeservice.EmployeeAdd(employee);

        return ResponseEntity.status(201).body(	employee2);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> getEmployeeDetails() {
        List<Employee> employees = employeeservice.getAllEmployee();

        return ResponseEntity.status(200).body(employees);
    }

    @PutMapping("updated/{id}")
    public ResponseEntity<Employee> putMethodName(@PathVariable Long id, @RequestBody EmployeeDto entity) {
       try {
        Employee employee = new Employee();
        employee.setFname(entity.getFname());
        employee.setLname(entity.getLname());
        employee.setNIC(entity.getNIC());
        employee.setAdressa(entity.getAdressa());
        employee.setBirthday(entity.getBirthday());
        employee.setContactNumber(entity.getContactNumber());
        employee.setCity(entity.getCity());
        employee.setEmail(entity.getEmail());
        employee.setImage(entity.getImage());

        Employee employee2 =employeeservice.EmployeeUpdate(id, employee);

        return ResponseEntity.status(201).body(employee2);
        
       } catch (Exception e) {
        e.getMessage();
        return ResponseEntity.status(500).build();       }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Employee> getdetailsFinal(@PathVariable("id") Long Id) {
        Employee employee= employeeservice.SerchEmployee(Id);
        return  ResponseEntity.status(200).body(employee);
    }

  
    
    
    
    

}
