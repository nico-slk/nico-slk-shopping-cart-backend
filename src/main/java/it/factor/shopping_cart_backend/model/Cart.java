package it.factor.shopping_cart_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy, HH:mm:ss")
    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "bonification")
    private Double bonification = 0.0;

    @Column(name = "total_spended")
    private Double totalSpended = 0.0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference
    private List<Product> products;
}
