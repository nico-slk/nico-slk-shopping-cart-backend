package it.factor.shopping_cart_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private UUID productId;
    private UUID cartId;
    private String productName;
    private Double productPrice;
}
