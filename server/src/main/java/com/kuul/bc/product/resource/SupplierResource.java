package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Order;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("supplier")
public class SupplierResource {

    /**
     * Get the whole catalogue of all available products
     */
    @GET
    @Path("getOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveListOfProducts() {
        ClientResource client = new ClientResource();
        List<Order> orders = client.getOrders();
        return Response
                .ok(orders, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Set an order of products to be done
     */
    @PUT
    @Path("done")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response updateRadioState(@QueryParam("OrderId") long orderId) {
        ClientResource client = new ClientResource();
        Order order = client.getOrders().stream().filter(o -> o.getOrderId() == orderId).collect(Collectors.toList()).get(0);
        order.setDone(true);
        return Response
                .ok(client.getOrders(), MediaType.APPLICATION_JSON)
                .build();
    }

}
