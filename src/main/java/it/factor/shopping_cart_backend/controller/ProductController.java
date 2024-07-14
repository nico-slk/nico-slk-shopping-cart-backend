package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.model.Product;
import it.factor.shopping_cart_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{cartId}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable("cartId") UUID cartId) {
        return ResponseEntity.ok(productService.getAllProductsByCartId(cartId));
    }
}
