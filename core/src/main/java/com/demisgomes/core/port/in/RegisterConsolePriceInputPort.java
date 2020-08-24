package com.demisgomes.core.port.in;

import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.core.domain.models.ConsolePriceRegisterRequest;

public interface RegisterConsolePriceInputPort {
    ConsolePrice register(ConsolePriceRegisterRequest consolePriceRegisterRequest);
}