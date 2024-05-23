package com.wishlist.interactors;

import com.wishlist.datasources.ProductRepository;
import com.wishlist.entities.Product;
import com.wishlist.interactors.exception.BusinessException;
import com.wishlist.interactors.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCaseImpl implements ProductUseCase{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void register(Product product) {
        try {
            productRepository.save(product);
        }catch (Exception e){
            throw new BusinessException("Failed to register product", e);
        }
    }

    @Override
    public Product getById(String id) {
        var productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

    }

    @Override
    public List<Product> getAll() {
        try {
            return productRepository.findAll();
        }catch (Exception e){
            throw new BusinessException("Failed to get products list", e);
        }
    }
}
