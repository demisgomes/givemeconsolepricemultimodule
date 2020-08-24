package com.demisgomes.core.usecase;

import com.demisgomes.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.core.port.in.CalculateConsolePriceInputPort;
import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;
import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;
import com.demisgomes.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.core.domain.models.ConsolePrice;

public class CalculateConsolePriceUseCase implements CalculateConsolePriceInputPort {
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRateOutputPort fetchExchangeRateOutputPort;
    private FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort;

    public CalculateConsolePriceUseCase(ConsolePriceCalculator consolePriceCalculator, FetchExchangeRateOutputPort fetchExchangeRateOutputPort, FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort) {
        this.consolePriceCalculator = consolePriceCalculator;
        this.fetchExchangeRateOutputPort = fetchExchangeRateOutputPort;
        this.fetchTaxPercentageOutputPort = fetchTaxPercentageOutputPort;
    }

    @Override
    public ConsolePrice calculate(ConsolePriceCalculateRequest consolePriceCalculateRequest) {
        double exchangeRate = fetchExchangeRateOutputPort.get();
        double taxPercentage = fetchTaxPercentageOutputPort.get();

        return consolePriceCalculator.calculateFromPriceInBRL(
                consolePriceCalculateRequest.getConsoleName(),
                consolePriceCalculateRequest.getPriceInUSD(),
                consolePriceCalculateRequest.getPriceInBRL(),
                exchangeRate,
                taxPercentage
        );
    }

}