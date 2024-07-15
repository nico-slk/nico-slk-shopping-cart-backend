package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.dto.CartDTO;
import it.factor.shopping_cart_backend.model.Cart;
import it.factor.shopping_cart_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping(path = "/prod")
    public ResponseEntity<List<Cart>> getProducts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path="/")
    public ResponseEntity<Cart> addCart(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.addCart(cartDTO));
    }

    @DeleteMapping("/{cartId}/product/{productId}")
    public ResponseEntity<String> deleteCart(@PathVariable("cartId") UUID cartId, @PathVariable("productId") UUID productId) {
        cartService.deleteProduct(cartId, productId);
        return ResponseEntity.ok("Producto eliminado con éxito del carrito.");
    }
}
