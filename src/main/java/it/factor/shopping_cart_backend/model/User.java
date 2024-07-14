package it.factor.shopping_cart_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "vip", nullable = false)
    private boolean isVip;

    @Column(name = "total_spend_month")
    private Double totalSpendMonth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy, HH:mm:ss")
    @Column(name = "last_buy_date")
    private LocalDateTime lastBuyDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cartList = new ArrayList<>();

}
