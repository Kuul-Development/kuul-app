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
import java.util.Optional;

/**
 * Resource class for the supplier view
 */
@Path("deliver")
public class SupplierViewResource {

    /**
     * Get the whole catalogue of all available products
     */
    @GET
    @Path("getorders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveListOfProducts() {
        ClientViewResource client = new ClientViewResource();
        List<Order> allOrders = client.getOrders();
        return Response
                .ok(allOrders, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Set an order of products to be done
     */
    @PUT
    @Path("done")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response updateRadioState(@QueryParam("orderId") long orderId) {
        ClientViewResource client = new ClientViewResource();
        Optional<Order> order = findOrderById(client.getOrders(), orderId);
        order.ifPresent(o -> o.setDone(true));
        return Response
                .ok(client.getOrders(), MediaType.APPLICATION_JSON)
                .build();
    }

    static Optional<Order> findOrderById(List<Order> orders, long orderId)  {
        return orders.stream().filter(o -> o.getOrderId() == orderId).findFirst();
    }
}
