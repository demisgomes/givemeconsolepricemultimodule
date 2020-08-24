package com.demisgomes.springboot.adapters.integration;

import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceMock implements FetchExchangeRateOutputPort {

    @Override
    public double get() {
        return 5.43;
    }
}