package com.posSeystem.PosSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Product;
import com.posSeystem.PosSystem.repository.ProductRepository;
@Service
public class ProductServiceImpl implements Productservice{

    @Autowired
    private ProductRepository productRepository;

    

    @Override
    public Product creatProduct(Product product) {

        Optional<Product> existingProduct = productRepository.findByProductname(product.getProductname());
        if (existingProduct.isPresent()) {
            throw new IllegalArgumentException("Product with this name already exists"); // handle not situation
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> geProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteproduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product product2 =productRepository.findById(id).orElse(null);

        if(product2 == null){
            return null;
        }else{
            product2.setProductname(product.getProductname());
            product2.setCategory(product.getCategory());
            product2.setFoodType(product.getFoodType());
            product2.setImage(product.getImage());


            return productRepository.save(product2);
        }


       

    }

    @Override
    public Product getFindProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductsByType(String foodType) {
        return productRepository.findByFoodType(foodType);
    }

   
   

    
}
