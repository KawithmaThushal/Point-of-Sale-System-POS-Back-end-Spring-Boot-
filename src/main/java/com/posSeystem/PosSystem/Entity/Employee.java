package com.posSeystem.PosSystem.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Fname;
    @Column(nullable = false)
    private String Lname;
    @Column(nullable = false)
    private Long NIC;
    @Column(nullable = false)
    private String Adressa;

    private String Email;
    @Column(nullable = false)
    private Long ContactNumber;
    @Column(nullable = false)
    private  LocalDate Birthday;

    private String City;

    private String  image;


    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime AddDate;
    
    @PrePersist
    protected void onCreate() {
        if (AddDate == null) {
            this.AddDate = LocalDateTime.now();
        }
    }

   

}
