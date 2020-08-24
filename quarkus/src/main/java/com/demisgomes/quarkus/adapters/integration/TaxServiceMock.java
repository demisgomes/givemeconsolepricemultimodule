package com.demisgomes.quarkus.adapters.integration;

import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;

import javax.inject.Singleton;

@Singleton
public class TaxServiceMock implements FetchTaxPercentageOutputPort {
    @Override
    public double get() {
        return 0.4;
    }
}