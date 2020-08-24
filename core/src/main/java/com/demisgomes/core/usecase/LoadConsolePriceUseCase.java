package com.demisgomes.core.usecase;

import com.demisgomes.core.port.in.LoadConsolePriceInputPort;
import com.demisgomes.core.port.out.LoadConsolePriceOutputPort;
import com.demisgomes.core.domain.models.ConsolePrice;

public class LoadConsolePriceUseCase implements LoadConsolePriceInputPort {
    private LoadConsolePriceOutputPort loadConsolePriceOutputPort;

    public LoadConsolePriceUseCase(LoadConsolePriceOutputPort loadConsolePriceOutputPort) {
        this.loadConsolePriceOutputPort = loadConsolePriceOutputPort;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        return loadConsolePriceOutputPort.getById(id);
    }
}