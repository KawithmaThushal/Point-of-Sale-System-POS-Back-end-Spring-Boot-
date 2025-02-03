package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Employee;
import com.posSeystem.PosSystem.repository.EmployeeRepository;
@Service
public class EmployeeserviceImpl implements Employeeservice{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee EmployeeAdd(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee EmployeeUpdate(Long Id, Employee employee) {
       Employee employee1= employeeRepository.findById(Id).orElse(employee);

       if(employee1 ==  null){
        return null;
       }else{
        employee1.setFname(employee.getFname());
        employee1.setLname(employee.getLname());
        employee1.setAdressa(employee.getAdressa());
        employee1.setBirthday(employee.getBirthday());
        employee1.setCity(employee.getCity());
        employee1.setContactNumber(employee.getContactNumber());
        employee1.setImage(employee.getImage());
        employee1.setNIC(employee.getNIC());

        return employeeRepository.save(employee1);
       }
    }

    @Override
    public void DeleteEmployee(Long Id) {
         employeeRepository.deleteById(Id);
    }

    @Override
    public Employee SerchEmployee(Long Id) {
       return employeeRepository.findById(Id).orElse(null);
    }
    
}
