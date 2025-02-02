package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.model.SpecialDate;
import it.factor.shopping_cart_backend.repository.SpecialDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SpecialDateService {
    @Autowired
    private SpecialDateRepository specialDateRepository;

    public SpecialDate getAllSpecialDates(LocalDateTime now) {
        return specialDateRepository.findAllByStartDateBeforeAndEndDateAfter(now, now);
    }

    public SpecialDate addSpecialDate(SpecialDate specialDate) {
        LocalDateTime startDate = specialDate.getStartDate();
        LocalDateTime endDate = specialDate.getStartDate().plusMonths(1);

        specialDate.setStartDate(startDate);
        specialDate.setEndDate(endDate);

        return specialDateRepository.save(specialDate);
    }
}
