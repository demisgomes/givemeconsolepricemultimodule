package com.demisgomes.quarkus.adapters.config;

import com.demisgomes.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;
import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;
import com.demisgomes.core.port.out.LoadConsolePriceOutputPort;
import com.demisgomes.core.port.out.SaveConsolePriceOutputPort;
import com.demisgomes.core.usecase.CalculateConsolePriceUseCase;
import com.demisgomes.core.usecase.LoadConsolePriceUseCase;
import com.demisgomes.core.usecase.RegisterConsolePriceUseCase;

import javax.inject.Singleton;

public class CoreInjection {

    @Singleton
    public ConsolePriceCalculator consolePriceCalculator(){
        return new ConsolePriceCalculator();
    }

    @Singleton
    public CalculateConsolePriceUseCase calculateConsolePrice(
            ConsolePriceCalculator consolePriceCalculator,
            FetchExchangeRateOutputPort fetchExchangeRateOutputPort,
            FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort){

        return new CalculateConsolePriceUseCase(
                consolePriceCalculator,
                fetchExchangeRateOutputPort,
                fetchTaxPercentageOutputPort
        );
    }

    @Singleton
    public LoadConsolePriceUseCase loadConsolePrice(LoadConsolePriceOutputPort loadConsolePriceOutputPort){
        return new LoadConsolePriceUseCase(loadConsolePriceOutputPort);
    }

    @Singleton
    public RegisterConsolePriceUseCase registerConsolePrice(
            ConsolePriceCalculator consolePriceCalculator,
            FetchExchangeRateOutputPort fetchExchangeRateOutputPort,
            FetchTaxPercentageOutputPort fetchTaxPercentageOutputPort,
            SaveConsolePriceOutputPort saveConsolePriceOutputPort){

        return new RegisterConsolePriceUseCase(
                consolePriceCalculator,
                fetchExchangeRateOutputPort,
                fetchTaxPercentageOutputPort,
                saveConsolePriceOutputPort
        );
    }

}