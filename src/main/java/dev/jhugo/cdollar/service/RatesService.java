package dev.jhugo.cdollar.service;

import org.springframework.web.client.HttpClientErrorException;

public interface RatesService {
    public Double calculateSpread(String name) throws HttpClientErrorException;

    public Double calculateFinalPrice(String name) throws HttpClientErrorException;
}