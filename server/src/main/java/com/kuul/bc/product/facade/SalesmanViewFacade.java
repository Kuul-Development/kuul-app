package com.kuul.bc.product.facade;

import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;
import com.kuul.bc.product.business.SalesmanViewBL;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

/**
 * Presentation layer for the salesman view
 */
@Path("sell")
public class SalesmanViewFacade {

    @Inject
    private SalesmanViewBL salesmanViewBL;

    /**
     * Add a salesman to the catalogue
     */
    @PUT
    @Path("salesman")
    public void addSalesman(@QueryParam("salesman") String salesman) {
       salesmanViewBL.addSalesman(salesman);
    }

    /**
     * Get all available salesmen
     */
    @GET
    @Path("allsalesmen")
    public Response getAllSalesmen() {
        Set<Salesman> allSalesmen = salesmanViewBL.getAllSalesman();
        return Response.ok(allSalesmen, MediaType.APPLICATION_JSON)
                       .build();
    }

    @GET
    @Path("testendpoint")
    public Response getTestEndpoint() {
        Salesman salesman = new Salesman();
        salesman.setName("testName7");
        return Response.ok(salesman, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Add a product to the catalogue of a certain salesman
     */
    @PUT
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public void addProduct(@QueryParam("id") long id,
                                            @QueryParam("product") String product,
                                            @QueryParam("desc") String description,
                                            @QueryParam("amount") long amount,
                                            @QueryParam("price") double price) {
        salesmanViewBL.addProduct(id, product, description, amount, price);
    }

    /**
     * Get the view on a catalogue of a certain salesman
     */
    @GET
    @Path("store")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStore(@QueryParam("id") long id) {
        List<Product> store = salesmanViewBL.getStore(id);
        return Response
                .ok(store, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Delete all stores and products from catalogue
     */
    @PUT
    @Path("delete")
    public void deleteAll() {
        salesmanViewBL.deleteAll();
    }

}
