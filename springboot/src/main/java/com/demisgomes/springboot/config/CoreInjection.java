package com.demisgomes.springboot.config;

import com.demisgomes.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;
import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;
import com.demisgomes.core.port.out.LoadConsolePriceOutputPort;
import com.demisgomes.core.port.out.SaveConsolePriceOutputPort;
import com.demisgomes.core.usecase.CalculateConsolePriceUseCase;
import com.demisgomes.core.usecase.LoadConsolePriceUseCase;
import com.demisgomes.core.usecase.RegisterConsolePriceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {
    @Bean
    public ConsolePriceCalculator consolePriceCalculator(){
        return new ConsolePriceCalculator();
    }

    @Bean
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

    @Bean
    public LoadConsolePriceUseCase loadConsolePrice(LoadConsolePriceOutputPort loadConsolePriceOutputPort){
        return new LoadConsolePriceUseCase(loadConsolePriceOutputPort);
    }

    @Bean
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
