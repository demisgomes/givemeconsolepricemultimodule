package com.demisgomes.core.domain.behavior;

import com.demisgomes.core.domain.models.ConsolePrice;

public class ConsolePriceCalculator{
    public ConsolePrice calculateFromProfit(String consoleName, double priceInUSD, double profitPercentage,
                                            double exchangeRate, double taxPercentage) {

        double priceInBRLBeforeTax = priceInUSD * exchangeRate;
        double taxAmount = priceInBRLBeforeTax * taxPercentage;
        double profitAmount = (priceInBRLBeforeTax + taxAmount) * profitPercentage;

        double priceInBRL = priceInBRLBeforeTax + taxAmount + profitAmount;

        return new ConsolePrice(
                null,
                consoleName,
                priceInUSD,
                exchangeRate,
                taxPercentage,
                taxAmount,
                profitPercentage,
                profitAmount,
                priceInBRL
        );
    }

    public ConsolePrice calculateFromPriceInBRL(String consoleName, double priceInUSD, double priceInBRL,
                            double exchangeRate, double taxPercentage) {

        double priceInBRLBeforeTax = priceInUSD * exchangeRate;
        double taxAmount = priceInBRLBeforeTax * taxPercentage;
        double priceInBRLWithTax = priceInBRLBeforeTax+taxAmount;

        double profitAmount = priceInBRL - (priceInBRLBeforeTax + taxAmount);
        double profitPercentage = profitAmount/priceInBRLWithTax;

        return new ConsolePrice(
                null,
                consoleName,
                priceInUSD,
                exchangeRate,
                taxPercentage,
                taxAmount,
                profitPercentage,
                profitAmount,
                priceInBRL
        );
    }
}