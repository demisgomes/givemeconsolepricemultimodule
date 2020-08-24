package com.demisgomes.springboot.adapters.repository.mapper;


import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.springboot.adapters.repository.model.ConsolePriceJpa;
import org.springframework.stereotype.Component;

@Component
public class ConsolePriceMapper{
    public ConsolePriceJpa toConsolePriceJpa(ConsolePrice consolePrice) {
        return new ConsolePriceJpa(
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


    public ConsolePrice toConsolePrice(ConsolePriceJpa consolePriceJpa) {
        return new ConsolePrice(
                consolePriceJpa.getId(),
                consolePriceJpa.getConsoleName(),
                consolePriceJpa.getPriceInUSD(),
                consolePriceJpa.getExchangeRate(),
                consolePriceJpa.getTaxPercentage(),
                consolePriceJpa.getTaxAmount(),
                consolePriceJpa.getProfitPercentage(),
                consolePriceJpa.getProfitAmount(),
                consolePriceJpa.getPriceInBRL()
        );
    }
}