package dev.jhugo.cdollar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jhugo.cdollar.repository.Iof;
import dev.jhugo.cdollar.service.DollarService;
import dev.jhugo.cdollar.service.RatesService;

@Service
public class NubankRates implements RatesService{
    private final double spread = 0.04;
    private double dollarPrice;
    @Autowired
    public Iof iof;
    
    // Constructor injection for the dollar price
    public NubankRates(){
        this.dollarPrice = new DollarService().getDollarPrice().value().get(0).cotacaoVenda();
    }

    // Bank-specific implementation of methods
    @Override
    public Double getSpread() {
        return dollarPrice + (dollarPrice * spread);
    }

    @Override
    public Double getFinalRate() {
        double dollarIof = (iof.getIof() * dollarPrice);
        return dollarIof + getSpread();
    }
    
}
