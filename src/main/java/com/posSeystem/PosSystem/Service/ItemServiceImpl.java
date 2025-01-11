package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Item;
import com.posSeystem.PosSystem.repository.itemRepository;

@Service
public class ItemServiceImpl implements ItemService{

@Autowired
private itemRepository repository;

    @Override
    public List<Item> gettAllItem() {
    
            return repository.findAll();
    }

    @Override
    public Item creatItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Item getItemId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item item2 = repository.findById(id).orElse(item);

        if(item2 == null){
            return null;
        }else{
            item2.setName(item.getName());
            item2.setDiscription(item.getDiscription());
            item2.setPrice(item.getPrice());
            item2.setQuantity(item.getQuantity());
            item2.setImage(item.getImage());
            item2.setCategory(item.getCategory());

            return repository.save(item2);
        }

    }

    @Override
    public void DeleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Item> getItemsByCategoryId(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }

   
}
