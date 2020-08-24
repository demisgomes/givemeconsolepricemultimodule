package com.demisgomes.quarkus.adapters.repository;

import com.demisgomes.quarkus.adapters.repository.panache.ConsolePricePanacheRepository;
import com.demisgomes.quarkus.adapters.repository.mapper.ConsolePriceMapper;
import com.demisgomes.quarkus.adapters.repository.model.ConsolePricePanache;
import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.core.port.out.LoadConsolePriceOutputPort;
import com.demisgomes.core.port.out.SaveConsolePriceOutputPort;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class ConsolePriceRepository implements SaveConsolePriceOutputPort, LoadConsolePriceOutputPort {
    @Inject
    private ConsolePricePanacheRepository consolePricePanacheRepository;
    @Inject
    private ConsolePriceMapper consolePriceMapper;


    public ConsolePriceRepository(ConsolePricePanacheRepository consolePricePanacheRepository, ConsolePriceMapper consolePriceMapper) {
        this.consolePricePanacheRepository = consolePricePanacheRepository;
        this.consolePriceMapper = consolePriceMapper;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        ConsolePricePanache consolePricePanache = consolePricePanacheRepository.findById(id);
        return consolePriceMapper.toConsolePrice(consolePricePanache);
    }

    @Override
    @Transactional
    public ConsolePrice save(ConsolePrice consolePrice) {
        ConsolePricePanache consolePricePanache = consolePriceMapper.toConsolePricePanache(consolePrice);
        ConsolePricePanache.persist(consolePricePanache);
        return consolePriceMapper.toConsolePrice(consolePricePanache);
        //consolePricePanacheRepository.persist(consolePricePanache);

        //return consolePrice;

    }
}