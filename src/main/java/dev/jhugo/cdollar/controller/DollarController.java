package dev.jhugo.cdollar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dev.jhugo.cdollar.service.DollarService;

@Controller
public class DollarController {
    @Autowired
    DollarService dollarService;
    
    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome to the API!");
    }

    @GetMapping("/price")
    public ResponseEntity<String> getDollarPrice(){
       return ResponseEntity.ok(dollarService.getDollarPrice());
    }

    
}
