package it.factor.shopping_cart_backend.dto;

import it.factor.shopping_cart_backend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private UUID cartId;
    private UUID userId;
    private Double bonification;
    private Double totalSpended;
    private List<Product> productList = new ArrayList<>();
}
