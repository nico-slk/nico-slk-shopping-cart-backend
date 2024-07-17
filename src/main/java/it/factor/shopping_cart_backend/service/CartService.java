package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.dto.CartDTO;
import it.factor.shopping_cart_backend.dto.ProductDTO;
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

import java.time.LocalDateTime;
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

        LocalDateTime lastBuy = user.getLastBuyDate();
        LocalDateTime lastBuyMoth = user.getLastBuyDate().plusMonths(1);
        LocalDateTime now = LocalDateTime.now();

        Boolean isStillVIP = lastBuy.isBefore(now) && lastBuyMoth.isAfter(now);

        user.setVip(isStillVIP);

        for (Product product : products) {
            total = total + product.getPrice();
        }

        if (total > 10000) {
            user.setVip(true);
        }

        user.setTotalSpendMonth(user.getTotalSpendMonth() + total);
        user.setLastBuyDate(cartDTO.getDate());

        cart.setTotalSpended(total);

        cart.setProducts(products);

        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}
