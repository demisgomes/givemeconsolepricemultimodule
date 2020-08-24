package com.demisgomes.quarkus.adapters.web;

import com.demisgomes.core.domain.exception.ConsolePriceNotFoundException;
import com.demisgomes.core.domain.models.ConsolePrice;
import com.demisgomes.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.core.port.in.CalculateConsolePriceInputPort;
import com.demisgomes.core.port.in.LoadConsolePriceInputPort;
import com.demisgomes.core.port.in.RegisterConsolePriceInputPort;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class ConsolePriceController{
    private RegisterConsolePriceInputPort registerConsolePriceInputPort;
    private CalculateConsolePriceInputPort calculateConsolePriceInputPort;
    private LoadConsolePriceInputPort loadConsolePriceInputPort;

    @Inject
    public ConsolePriceController(RegisterConsolePriceInputPort registerConsolePriceInputPort, CalculateConsolePriceInputPort calculateConsolePriceInputPort, LoadConsolePriceInputPort loadConsolePriceInputPort) {
        this.registerConsolePriceInputPort = registerConsolePriceInputPort;
        this.calculateConsolePriceInputPort = calculateConsolePriceInputPort;
        this.loadConsolePriceInputPort = loadConsolePriceInputPort;
    }

    @Path("/consoles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerConsolePrice(ConsolePriceRegisterRequest consolePriceRegisterRequest, @Context UriInfo uriInfo) {
        ConsolePrice consolePrice = registerConsolePriceInputPort.register(consolePriceRegisterRequest);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consolePrice.getId()));
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(consolePrice.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
        return Response.created(builder.build()).build();
//        return Response.ok(consolePrice).build();
    }

    @Path("/calculate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculatePricefromBRL(ConsolePriceCalculateRequest consolePriceCalculateRequest) {
        ConsolePrice consolePrice = calculateConsolePriceInputPort.calculate(consolePriceCalculateRequest);
        return Response.ok(consolePrice).build();
    }

    @Path("/consoles/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsolePriceById(@PathParam("id") Integer id) {
        try {
            ConsolePrice consolePrice = loadConsolePriceInputPort.getById(id);
            return Response.ok(consolePrice).build();
        } catch (ConsolePriceNotFoundException exception){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}