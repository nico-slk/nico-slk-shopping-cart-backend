package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.model.Cart;
import it.factor.shopping_cart_backend.model.Product;
import it.factor.shopping_cart_backend.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addCart(Cart cart) {
        List<Product> products = cart.getProductList();
        Double total = 0.0;
        for (Product product : products) {
            total = total + product.getPrice();
        }
        cart.setTotalSpended(total);
        return cartRepository.save(cart);
    }

    public void deleteProduct(UUID cartId, UUID productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Carrito no encontrado"));
        List<Product> products = cart.getProductList();
        Product productToDelete = products.stream().filter(product -> product.getId().equals(productId)).findFirst().get();
        cart.getProductList().remove(productToDelete);
        cartRepository.save(cart);
    }
}
