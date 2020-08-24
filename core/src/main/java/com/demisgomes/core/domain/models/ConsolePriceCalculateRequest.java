package com.demisgomes.core.domain.models;

public class ConsolePriceCalculateRequest {
    private String consoleName;
    private double priceInUSD;
    private double priceInBRL;

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }

    public double getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public double getPriceInBRL() {
        return priceInBRL;
    }

    public void setPriceInBRL(double priceInBRL) {
        this.priceInBRL = priceInBRL;
    }
}