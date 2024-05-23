package com.wishlist.transportlayers;

import com.wishlist.entities.Product;
import com.wishlist.interactors.ProductUseCase;
import com.wishlist.transportlayers.dto.ProductDTO;
import com.wishlist.transportlayers.mapper.MapperProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    ProductUseCase productUseCase;

    private final MapperProduct productMapper = MapperProduct.INSTANCE;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id){
        var result = productUseCase.getById(id);
        return ResponseEntity.ok(productMapper.map(result));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody ProductDTO productDTO){
        productUseCase.register(productMapper.mapToProduct(productDTO));
        return ResponseEntity.ok("Registered product");
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productUseCase.getAll());
    }
}
