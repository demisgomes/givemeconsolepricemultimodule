package com.demisgomes.core.port.out;

import com.demisgomes.core.domain.models.ConsolePrice;

public interface LoadConsolePriceOutputPort {
    ConsolePrice getById(Integer id);
}