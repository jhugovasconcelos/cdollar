package dev.jhugo.cdollar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rates {
    private double spread;
    private double iof;
    
    @Autowired
    private DollarService dollarService;


    public Double ratesNubank(){
        spread = 0.04;
        iof = 0.038;
        double dolarPrice = dollarService.getDollarPrice().value().get(0).cotacaoVenda();
        return dolarPrice + (dolarPrice * spread) + (dolarPrice * iof);
    }
}
