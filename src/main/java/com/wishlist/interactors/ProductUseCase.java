package com.wishlist.interactors;

import com.wishlist.entities.Product;
import com.wishlist.transportlayers.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductUseCase {

    void register(Product product);

    Product getById(String id);

    List<Product> getAll();

}
