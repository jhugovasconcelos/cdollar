package dev.jhugo.cdollar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import dev.jhugo.cdollar.repository.DollarRecord;
import dev.jhugo.cdollar.service.DollarService;
import dev.jhugo.cdollar.service.Rates;

@Controller
public class DollarController {
    @Autowired
    DollarService dollarService;

    @Autowired
    Rates rates;
    
    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome to the API!");
    }

    @GetMapping("/price")
    public ResponseEntity<DollarRecord> getDollarPrice(){
       return ResponseEntity.ok(dollarService.getDollarPrice());
    }

    @GetMapping("/rates/nubank")
    public ResponseEntity<Double> getRateNubank(){
        return ResponseEntity.ok(rates.ratesNubank());
    }
    
}
