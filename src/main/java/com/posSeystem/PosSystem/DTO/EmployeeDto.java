package com.posSeystem.PosSystem.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    
    private String Fname;
    private String Lname;
    private Long NIC;
    private String Adressa;

    private String Email;
    private Long ContactNumber;
    private  LocalDate Birthday;

    private String City;

    private String image;


    
}
