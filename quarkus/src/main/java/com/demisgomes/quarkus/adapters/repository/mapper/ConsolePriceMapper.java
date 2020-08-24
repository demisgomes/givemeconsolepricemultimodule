package com.demisgomes.quarkus.adapters.repository.mapper;

import com.demisgomes.quarkus.adapters.repository.model.ConsolePricePanache;
import com.demisgomes.core.domain.models.ConsolePrice;

import javax.inject.Singleton;

@Singleton
public class ConsolePriceMapper{
    public ConsolePricePanache toConsolePricePanache(ConsolePrice consolePrice) {
        return new ConsolePricePanache(
                consolePrice.getId(),
                consolePrice.getConsoleName(),
                consolePrice.getPriceInUSD(),
                consolePrice.getExchangeRate(),
                consolePrice.getTaxPercentage(),
                consolePrice.getTaxAmount(),
                consolePrice.getProfitPercentage(),
                consolePrice.getProfitAmount(),
                consolePrice.getPriceInBRL()
        );
    }


    public ConsolePrice toConsolePrice(ConsolePricePanache consolePricePanache) {
        return new ConsolePrice(
                consolePricePanache.getId(),
                consolePricePanache.getConsoleName(),
                consolePricePanache.getPriceInUSD(),
                consolePricePanache.getExchangeRate(),
                consolePricePanache.getTaxPercentage(),
                consolePricePanache.getTaxAmount(),
                consolePricePanache.getProfitPercentage(),
                consolePricePanache.getProfitAmount(),
                consolePricePanache.getPriceInBRL()
        );
    }
}