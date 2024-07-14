package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.model.SpecialDate;
import it.factor.shopping_cart_backend.service.SpecialDateService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/date")
public class SpecialDateController {

    @Autowired
    private SpecialDateService specialDateService;

    @GetMapping("/{startDate}")
    public ResponseEntity<SpecialDate> getSpecialDate(@PathVariable String startDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy, HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(startDate, formatter);

        return ResponseEntity.ok(specialDateService.getSpecialDateByStartDate(date));
    }

    @PostMapping("/{startDate}")
    public ResponseEntity<SpecialDate> addSpecialDate(@RequestBody SpecialDate specialDate) {
        return ResponseEntity.ok(specialDateService.addSpecialDate(specialDate));
    }

}
