package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.dto.ProductDTO;
import it.factor.shopping_cart_backend.model.Product;
import it.factor.shopping_cart_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/prod")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}
