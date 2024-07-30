package dev.jhugo.cdollar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import dev.jhugo.cdollar.data.DollarRecord;
import dev.jhugo.cdollar.service.DollarService;
import dev.jhugo.cdollar.service.impl.BankService;

@RestController
@Tag(name = "Dollar Controller", description = "RESTful API for providing the dollar price at credit card transaction")
public record DollarController(BankService bankService, DollarService dollarService) {

    @GetMapping("/price")
    @Operation(summary = "Get the current PTAX dollar price", description = "Retrieve PTAX dollar price from the BCB")
    public ResponseEntity<DollarRecord> getDollarPrice() {
        return ResponseEntity.ok(dollarService.getDollarPrice());
    }

    @GetMapping("/spread/{name}")
    @Operation(summary = "Get the dollar price from selected bank with spread", description = "Retrieve current dollar price from selected bank with spread")
    public ResponseEntity<Double> getSpread(@PathVariable String name) {
        return ResponseEntity.ok(bankService.calculateSpread(name));
    }

    @GetMapping("/rates/{name}")
    @Operation(summary = "Get the total price per dollar in selected bank credit card transaction", description = "Calculate the total price to be paid per dollar in selected bank on an international credit card transaction")
    public ResponseEntity<Double> getRate(@PathVariable String name) {
        return ResponseEntity.ok(bankService.calculateFinalPrice(name));
    }


}
