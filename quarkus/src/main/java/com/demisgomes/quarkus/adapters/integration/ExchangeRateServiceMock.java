package com.demisgomes.quarkus.adapters.integration;

import com.demisgomes.core.port.out.FetchExchangeRateOutputPort;

import javax.inject.Singleton;

@Singleton
public class ExchangeRateServiceMock implements FetchExchangeRateOutputPort {

    @Override
    public double get() {
        return 5.43;
    }
}