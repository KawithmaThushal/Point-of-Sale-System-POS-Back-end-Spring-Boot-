package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Categery;

@Service
public interface CategeryService {

    List<Categery> getAllCategery();
    Categery creatCategory(Categery categery);
    Categery getFindCategery(Long id);
    
}