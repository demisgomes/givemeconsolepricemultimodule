package com.demisgomes.core.port.out;

import com.demisgomes.core.domain.models.ConsolePrice;

public interface SaveConsolePriceOutputPort {
    ConsolePrice save(ConsolePrice consolePrice);
}