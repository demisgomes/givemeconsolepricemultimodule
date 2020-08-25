package com.demisgomes.quarkus.adapters.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;
import javax.inject.Singleton;
import javax.json.bind.JsonbConfig;

@Singleton
public class ConsolePriceJSONCustomizer implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig jsonbConfig) {
        jsonbConfig.withNullValues(false);
    }
}
