package com.demisgomes.quarkus.adapters.repository.panache;

import com.demisgomes.quarkus.adapters.repository.model.ConsolePricePanache;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsolePricePanacheRepository implements PanacheRepositoryBase<ConsolePricePanache, Integer> {}