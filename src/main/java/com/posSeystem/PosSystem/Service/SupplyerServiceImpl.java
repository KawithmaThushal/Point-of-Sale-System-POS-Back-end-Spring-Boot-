package com.posSeystem.PosSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Supplyer;
import com.posSeystem.PosSystem.repository.SupplyerRepository;

@Service
public class SupplyerServiceImpl   implements SupplyerService{
    @Autowired
    private SupplyerRepository supplyerRepository;

    @Override
    public Supplyer CreatSupplyer(Supplyer supplyer) {

        return supplyerRepository.save(supplyer);
        
    }
    
}
