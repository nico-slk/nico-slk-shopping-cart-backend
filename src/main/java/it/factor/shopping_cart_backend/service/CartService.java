package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.dto.CartDTO;
import it.factor.shopping_cart_backend.model.Cart;
import it.factor.shopping_cart_backend.model.Product;
import it.factor.shopping_cart_backend.model.User;
import it.factor.shopping_cart_backend.repository.CartRepository;
import it.factor.shopping_cart_backend.repository.ProductRepository;
import it.factor.shopping_cart_backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Cart addCart(CartDTO cartDTO) {
        Double total = 0.0;
        User user = userRepository.findById(UUID.fromString(cartDTO.getUserId()))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Cart cart = new Cart();
        cart.setBonification(cartDTO.getBonification());
        cart.setTotalSpended(cartDTO.getTotalSpended());
        cart.setDate(cartDTO.getDate());

        List<Product> products = cartDTO.getProductList().stream()
                .map(dto -> productRepository.findById(UUID.fromString(dto.getId()))
                        .orElseThrow(() -> new RuntimeException("Product not found")))
                .collect(Collectors.toList());

        for (Product product : products) {
            total = total + product.getPrice();
        }

        user.setTotalSpendMonth(user.getTotalSpendMonth() + total);
        user.setLastBuyDate(cartDTO.getDate());

        cart.setTotalSpended(total);

        cart.setProducts(products);

        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    public void deleteProduct(UUID cartId, UUID productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Carrito no encontrado"));
        List<Product> products = cart.getProducts();
        Product productToDelete = products.stream().filter(product -> product.getId().equals(productId)).findFirst().get();
        cart.getProducts().remove(productToDelete);
        cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}
