package com.demisgomes.springboot.adapters.repository;

import com.demisgomes.core.domain.exception.ConsolePriceNotFoundException;
import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.core.port.out.LoadConsolePriceOutputPort;
import com.demisgomes.core.port.out.SaveConsolePriceOutputPort;
import com.demisgomes.springboot.adapters.repository.jpa.ConsolePriceJpaRepository;
import com.demisgomes.springboot.adapters.repository.mapper.ConsolePriceMapper;
import com.demisgomes.springboot.adapters.repository.model.ConsolePriceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConsolePriceRepository implements SaveConsolePriceOutputPort, LoadConsolePriceOutputPort {

    private ConsolePriceJpaRepository consolePriceJpaRepository;
    private ConsolePriceMapper consolePriceMapper;

    @Autowired
    public ConsolePriceRepository(ConsolePriceJpaRepository consolePriceJpaRepository, ConsolePriceMapper consolePriceMapper) {
        this.consolePriceJpaRepository = consolePriceJpaRepository;
        this.consolePriceMapper = consolePriceMapper;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        ConsolePriceJpa consolePriceJpa = consolePriceJpaRepository.findById(id).orElseThrow(ConsolePriceNotFoundException::new);
        return consolePriceMapper.toConsolePrice(consolePriceJpa);
    }

    @Override
    public ConsolePrice save(ConsolePrice consolePrice) {
        ConsolePriceJpa consolePriceJpa = consolePriceMapper.toConsolePriceJpa(consolePrice);
        ConsolePriceJpa consolePriceJpaSaved = consolePriceJpaRepository.save(consolePriceJpa);

        return consolePriceMapper.toConsolePrice(consolePriceJpaSaved);

    }
}