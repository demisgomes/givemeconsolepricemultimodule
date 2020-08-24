package com.demisgomes.core.usecase;

import com.demisgomes.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.core.port.in.RegisterConsolePriceInputPort;
import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;
import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;
import com.demisgomes.core.port.out.SaveConsolePriceOutputPort;
import com.demisgomes.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.core.domain.models.ConsolePrice;

public class RegisterConsolePriceUseCase implements RegisterConsolePriceInputPort {
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRateOutputPort fetchExchangeRateOutputPort;
    private FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort;
    private SaveConsolePriceOutputPort saveConsolePriceOutputPort;

    public RegisterConsolePriceUseCase(ConsolePriceCalculator consolePriceCalculator, FetchExchangeRateOutputPort fetchExchangeRateOutputPort, FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort, SaveConsolePriceOutputPort saveConsolePriceOutputPort) {
        this.consolePriceCalculator = consolePriceCalculator;
        this.fetchExchangeRateOutputPort = fetchExchangeRateOutputPort;
        this.fetchTaxPercentageOutputPort = fetchTaxPercentageOutputPort;
        this.saveConsolePriceOutputPort = saveConsolePriceOutputPort;
    }

    @Override
    public ConsolePrice register(ConsolePriceRegisterRequest consolePriceRegisterRequest) {
        double exchangeRate = fetchExchangeRateOutputPort.get();
        double taxPercentage = fetchTaxPercentageOutputPort.get();
        ConsolePrice consolePrice =
                consolePriceCalculator.calculateFromProfit(
                        consolePriceRegisterRequest.getConsoleName(),
                        consolePriceRegisterRequest.getPriceInUSD(),
                        consolePriceRegisterRequest.getProfitPercentage(),
                        exchangeRate,
                        taxPercentage
                );

        return saveConsolePriceOutputPort.save(consolePrice);
    }
}