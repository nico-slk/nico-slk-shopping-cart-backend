package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.model.SpecialDate;
import it.factor.shopping_cart_backend.repository.SpecialDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SpecialDateService {
    @Autowired
    private SpecialDateRepository specialDateRepository;

    public SpecialDate getSpecialDateByStartDate(LocalDateTime startDate) {
        return specialDateRepository.findByStartDate(startDate);
    }

    public SpecialDate addSpecialDate(SpecialDate specialDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy, HH:mm:ss");

        LocalDateTime startDate = LocalDateTime.parse(specialDate.getStartDate().toString(), formatter);
        LocalDateTime endDate = LocalDateTime.parse(specialDate.getStartDate().toString(), formatter);

        specialDate.setStartDate(startDate);
        specialDate.setEndDate(endDate);

        return specialDateRepository.save(specialDate);
    }
}
