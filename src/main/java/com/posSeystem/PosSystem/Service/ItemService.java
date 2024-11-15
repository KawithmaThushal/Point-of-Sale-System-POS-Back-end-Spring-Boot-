package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Item;

@Service
public interface ItemService {

    List<Item> gettAllItem();
    Item creatItem(Item item);
    Item getItemId(Long id);
    Item updateItem(Long id, Item item);
    void DeleteItem(Long id);


    
} 
