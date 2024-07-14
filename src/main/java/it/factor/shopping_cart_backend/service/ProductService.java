package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.model.Product;
import it.factor.shopping_cart_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProductsByCartId(UUID cartId) {
        return productRepository.findAllByCartId(cartId);
    }
}
