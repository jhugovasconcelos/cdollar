package dev.jhugo.cdollar.service.impl;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import dev.jhugo.cdollar.data.Bank;
import dev.jhugo.cdollar.service.RatesService;

@Service
public class BankService implements RatesService {
    
    @Override
    public Double calculateSpread(String name) throws HttpClientErrorException{
        double spread = 0.0;
        switch (name.toLowerCase()) {
            case "nubank":
                spread = Bank.NUBANK.calculateSpread();
                break;
            case "santander":
                spread = Bank.SANTANDER.calculateSpread();
        }
        return spread;
    }

    @Override
    public Double calculateFinalPrice(String name) {
        double price = 0.0;
        switch (name.toLowerCase()) {
            case "nubank":
                price = Bank.NUBANK.calculateFinalPrice();
                break;
            case "santander":
                price = Bank.SANTANDER.calculateFinalPrice();
        }
        return price;
    }

}
