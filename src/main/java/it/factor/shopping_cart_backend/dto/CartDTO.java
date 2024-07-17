package it.factor.shopping_cart_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private String userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy, HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();
    private Double bonification;
    private Double totalSpended;
    private List<ProductDTO> productList = new ArrayList<>();
}
