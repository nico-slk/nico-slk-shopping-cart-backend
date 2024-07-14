package it.factor.shopping_cart_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "special_date")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String name;

}
