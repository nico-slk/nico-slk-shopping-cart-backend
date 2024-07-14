package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.model.Cart;
import it.factor.shopping_cart_backend.repository.CartRepository;
import it.factor.shopping_cart_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.addCart(cart));
    }

    @DeleteMapping("/{cartId}/producto/{productId}")
    public ResponseEntity<String> deleteCart(@PathVariable("cartId") UUID cartId, @PathVariable("productId") UUID productId) {
        cartService.deleteProduct(cartId, productId);
        return ResponseEntity.ok("Producto eliminado con éxito del carrito.");
    }
}
