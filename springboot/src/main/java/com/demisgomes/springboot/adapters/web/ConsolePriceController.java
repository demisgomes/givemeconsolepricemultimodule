package com.demisgomes.springboot.adapters.web;

import com.demisgomes.core.domain.exception.ConsolePriceNotFoundException;
import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.core.port.in.CalculateConsolePriceInputPort;
import com.demisgomes.core.port.in.LoadConsolePriceInputPort;
import com.demisgomes.core.port.in.RegisterConsolePriceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
class ConsolePriceController{
    private RegisterConsolePriceInputPort registerConsolePriceInputPort;
    private CalculateConsolePriceInputPort calculateConsolePriceInputPort;
    private LoadConsolePriceInputPort loadConsolePriceInputPort;

    @Autowired
    public ConsolePriceController(RegisterConsolePriceInputPort registerConsolePriceInputPort, CalculateConsolePriceInputPort calculateConsolePriceInputPort, LoadConsolePriceInputPort loadConsolePriceInputPort) {
        this.registerConsolePriceInputPort = registerConsolePriceInputPort;
        this.calculateConsolePriceInputPort = calculateConsolePriceInputPort;
        this.loadConsolePriceInputPort = loadConsolePriceInputPort;
    }

    @PostMapping("/consoles")
    public ResponseEntity<ConsolePrice> registerConsolePrice(@RequestBody ConsolePriceRegisterRequest consolePriceRegisterRequest) {
        ConsolePrice consolePrice = registerConsolePriceInputPort.register(consolePriceRegisterRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consolePrice.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/calculate")
    public ResponseEntity<ConsolePrice> calculatePricefromBRL(@RequestBody ConsolePriceCalculateRequest consolePriceCalculateRequest) {
        ConsolePrice consolePrice = calculateConsolePriceInputPort.calculate(consolePriceCalculateRequest);
        return ResponseEntity.ok(consolePrice);
    }

    @GetMapping("/consoles/{id}")
    public ResponseEntity<ConsolePrice> getConsolePriceById(@PathVariable Integer id) {
        try {
            ConsolePrice consolePrice = loadConsolePriceInputPort.getById(id);
            return ResponseEntity.ok(consolePrice);
        } catch (ConsolePriceNotFoundException exception){
            return ResponseEntity.of(Optional.empty());
        }

    }
}