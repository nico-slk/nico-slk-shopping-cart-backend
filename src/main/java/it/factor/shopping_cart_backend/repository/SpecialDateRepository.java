package it.factor.shopping_cart_backend.repository;

import it.factor.shopping_cart_backend.model.SpecialDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecialDateRepository extends JpaRepository<SpecialDate, UUID> {
}
