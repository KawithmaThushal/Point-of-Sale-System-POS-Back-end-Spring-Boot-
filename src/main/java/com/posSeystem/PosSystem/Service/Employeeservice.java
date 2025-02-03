package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Employee;

@Service
public interface Employeeservice {

    Employee EmployeeAdd(Employee employee);
    List<Employee> getAllEmployee();
    Employee EmployeeUpdate(Long Id, Employee employee);
    void DeleteEmployee(Long Id);
    Employee SerchEmployee(Long Id);
    

}
