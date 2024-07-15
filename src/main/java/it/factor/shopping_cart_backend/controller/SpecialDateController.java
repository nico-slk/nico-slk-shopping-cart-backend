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
@CrossOrigin(origins = "*")
public class SpecialDateController {

    @Autowired
    private SpecialDateService specialDateService;

    @GetMapping("/")
    public ResponseEntity<SpecialDate> getSpecialDate() {
        LocalDateTime now = LocalDateTime.now();
        return ResponseEntity.ok(specialDateService.getAllSpecialDates(now));
    }

    @PostMapping("/")
    public ResponseEntity<SpecialDate> addSpecialDate(@RequestBody SpecialDate specialDate) {
        return ResponseEntity.ok(specialDateService.addSpecialDate(specialDate));
    }

}
