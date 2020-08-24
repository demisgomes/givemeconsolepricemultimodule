package com.demisgomes.core.domain.models;

public class ConsolePriceRegisterRequest {
    private String consoleName;
    private double priceInUSD;
    private double profitPercentage;

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

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }
}
