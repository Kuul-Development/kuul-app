package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Order;
import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.RadioState;

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

@Path("client")
public class ClientResource {

    private static List<Order> shoppingCard = new ArrayList<>();

    /**
     * Get the whole catalogue of all available products
     */
    @GET
    @Path("getcatalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveListOfProducts() {
        SalesmanResource salesman = new SalesmanResource();
        Map<String, List<Product>> catalogue = salesman.getCatalogue();
        return Response
                    .ok(catalogue, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Place an order of products
     */
    @PUT
    @Path("placeOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response updateRadioState(@QueryParam("salesman") String salesman, @QueryParam("product") String product) {
        SalesmanResource seller = new SalesmanResource();
        Product orderedProduct = seller.getCatalogue()
                                       .get(salesman)
                                       .stream()
                                       .filter(listItem -> listItem.getProductId().equals(product)).collect(Collectors.toList())
                                       .get(0);
        Order newOrder = new Order(salesman, orderedProduct);
        shoppingCard.add(newOrder);
        return Response
                .ok(shoppingCard, MediaType.APPLICATION_JSON)
                .build();
    }

    public List<Order> getOrders() {
        return shoppingCard;
    }
}
