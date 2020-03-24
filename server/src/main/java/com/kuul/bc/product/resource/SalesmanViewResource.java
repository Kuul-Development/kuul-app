package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Resource class for the salesman view
 */
@Path("sell")
public class SalesmanViewResource {
    private static Map<Salesman, List<Product>> catalogue = new HashMap<>();

    /**
     * Add a salesman to the catalogue
     */
    @PUT
    @Path("salesman")
    public static Response addSalesman(@QueryParam("salesman") String salesman) {
        int size = catalogue.keySet().size();
        Salesman newSalesman = new Salesman(size+1,salesman);
        catalogue.put(newSalesman, new ArrayList<>());

        return Response
                .ok()
                .build();
    }

    /**
     * Get all available salesmen
     */
    @GET
    @Path("allsalesmen")
    public static Response getAllSalesmen() {
        return Response
                .ok(catalogue.keySet(), MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Add a product to the catalogue of a certain salesman
     */
    @PUT
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response addProduct(@QueryParam("id") long id,
                                            @QueryParam("product") String product,
                                            @QueryParam("desc") String description,
                                            @QueryParam("amount") long amount,
                                            @QueryParam("price") double price) {

        Salesman salesman = retrieveSalesmanFromCatalogue(id);
        Product newProduct = new Product(product, description, amount, price);
        catalogue.get(salesman).add(newProduct);

        return Response
                .ok(catalogue.get(salesman), MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Get the view on a catalogue of a certain salesman
     */
    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getStore(@QueryParam("id") long id) {
        Salesman salesman = catalogue.keySet()
                                     .stream()
                                     .filter(s -> s.getId() == id)
                                     .collect(Collectors.toList())
                                     .get(0);
        return Response
                .ok(catalogue.get(salesman), MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Delete all items from catalogue
     */
    @PUT
    @Path("delete")
    public static void deleteAll() {
        catalogue.clear();
    }

    public Map<Salesman, List<Product>> getCatalogue() {
        return catalogue;
    }

    private static Salesman retrieveSalesmanFromCatalogue(long id) {
        return catalogue.keySet()
                        .stream()
                        .filter(s -> s.getId() == id)
                        .collect(Collectors.toList())
                        .get(0);
    }
}
