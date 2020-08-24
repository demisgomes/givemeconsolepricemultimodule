package com.demisgomes.core.port.in;

import com.demisgomes.core.domain.models.ConsolePrice;

public interface LoadConsolePriceInputPort {
    ConsolePrice getById(Integer id);
}