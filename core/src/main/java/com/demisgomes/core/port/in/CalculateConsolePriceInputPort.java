package com.demisgomes.core.port.in;

import com.demisgomes.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.core.domain.models.ConsolePrice;

public interface CalculateConsolePriceInputPort {
    ConsolePrice calculate(ConsolePriceCalculateRequest consolePriceCalculateRequest);
}