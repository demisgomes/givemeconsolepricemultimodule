package com.demisgomes.springboot.adapters.integration;

import com.demisgomes.core.port.out.FetchTaxPercentageOutputPort;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceMock implements FetchTaxPercentageOutputPort {
    @Override
    public double get() {
        return 0.4;
    }
}