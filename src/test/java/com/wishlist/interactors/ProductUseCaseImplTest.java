package com.wishlist.interactors;

import com.wishlist.datasources.ProductRepository;
import com.wishlist.entities.Product;
import com.wishlist.interactors.exception.BusinessException;
import com.wishlist.interactors.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductUseCaseImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductUseCaseImpl productUseCase;

    @Test
    public void test_getByIdException(){
        when(productRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productUseCase.getById(any()));
    }

    @Test
    public void test_registerException() {
        Product product = getProduct();

        doThrow(new RuntimeException("Failed to register product")).when(productRepository).save(product);

        assertThrows(BusinessException.class, () -> productUseCase.register(product));

    }

    @Test
    public void test_getAllException(){
        doThrow(new RuntimeException("Failed to get products list")).when(productRepository).findAll();

        assertThrows(BusinessException.class, () -> productUseCase.getAll());
    }

    private Product getProduct(){
        return  new Product("teste", new BigDecimal(100));
    }
}
