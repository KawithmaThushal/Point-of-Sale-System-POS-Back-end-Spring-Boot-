package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Categery;
import com.posSeystem.PosSystem.repository.CategeryRepository;

@Service
public class CategeryServiceImpl implements CategeryService{

    @Autowired
    private CategeryRepository categeryRepository;


    @Override
    public List<Categery> getAllCategery() {

    return categeryRepository.findAll();
       
    }

    @Override
    public Categery creatCategory(Categery categery) {
       
        return categeryRepository.save(categery);
    }

    @Override
    public Categery getFindCategery(Long id) {
        
        return categeryRepository.findById(id).orElse(null);
    }
    
}
