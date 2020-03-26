package com.kuul.bc.product.facade;

import com.kuul.bc.product.dto.Catalogue;
import com.kuul.bc.product.business.ClientViewBL;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Presentation layer for the client view
 */
@Path("buy")
public class ClientViewFacade {

    @Inject
    private ClientViewBL clientViewBL;

    /**
     * Get the whole catalogue of available stores and products
     */
    @GET
    @Path("catalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCatalogue() {
        List<Catalogue> catalogue = clientViewBL.getCatalogue();
        return Response
                .ok(catalogue, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Create a new client
     */
    @PUT
    @Path("client")
    @Produces(MediaType.APPLICATION_JSON)
    public void createClient() {
        clientViewBL.createClient();
    }

    /**
     * Place an order of products
     */
    @PUT
    @Path("order")
    @Produces(MediaType.APPLICATION_JSON)
    public void placeOrder(@QueryParam("client") long id, @QueryParam("salesman") String salesman, @QueryParam("product") String product) {
        clientViewBL.placeOrder(id, salesman, product);
    }

    /**
     * Delete all items from shoppingCard
     */
    @PUT
    @Path("delete")
    public void deleteAll() {
        clientViewBL.deleteAll();
    }
}
