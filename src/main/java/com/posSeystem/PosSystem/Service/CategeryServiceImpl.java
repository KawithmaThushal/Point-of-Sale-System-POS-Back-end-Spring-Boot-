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

    @Override
    public Categery updateCategory(Long id, Categery categery) {
       Categery categery2= categeryRepository.findById(id).orElse(null);

       if(categery2 == null){
        return null;
       }else{
        categery2.setName(categery.getName());

        return categeryRepository.save(categery2);
       }
    }

    @Override
    public void DeleteCategory(Long id) {
       categeryRepository.deleteById(id);
    }
    
}
