package it.factor.shopping_cart_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private String id;
    private String name;
    private Double price;
    private String image;
}
