package dev.jhugo.cdollar.data;

import dev.jhugo.cdollar.service.DollarService;

public enum Bank {
    NUBANK(0.04, "nubank"),
    SANTANDER(0.057, "santander");

    private final double spread;
    private final String name;
    private final double dollarPrice;

    Bank(double spread, String name){
        this.spread = spread;
        this.name = name;
        this.dollarPrice = new DollarService().getDollarPrice().value().get(0).cotacaoVenda();
    }

    public String getName() {
        return this.name;
    }
    public double getSpread() {
        return this.spread;
    }


    public Double calculateSpread() {
        return dollarPrice + (dollarPrice * spread);
    }

    public Double calculateFinalPrice() {
        return (Iof.getIof() * dollarPrice) 
                + dollarPrice 
                + (dollarPrice * spread);
    }

}
