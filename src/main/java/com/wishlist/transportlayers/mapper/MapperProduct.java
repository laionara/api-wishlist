package com.wishlist.transportlayers.mapper;

import com.wishlist.entities.Product;
import com.wishlist.transportlayers.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperProduct {

    MapperProduct INSTANCE = Mappers.getMapper(MapperProduct.class);

    ProductDTO map(Product product);

    List<ProductDTO> mapToProducts(List<Product> product);

    Product mapToProduct(ProductDTO productDTO);

}
