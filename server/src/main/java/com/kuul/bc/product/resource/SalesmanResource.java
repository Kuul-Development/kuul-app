package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Product;

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

@Path("salesman")
public class SalesmanResource {
    private static Map<String, List<Product>> catalogue = new HashMap<>();

    @PUT
    @Path("addproduct")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response updateRadioState(@QueryParam("salesman") String salesman,
                                            @QueryParam("product") String product,
                                            @QueryParam("desc") String description,
                                            @QueryParam("amount") long amount) {

        Product newProduct = new Product(product, description, amount);
        catalogue.get(salesman).add(newProduct);

        return Response
                .ok(catalogue.get(salesman), MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("addsalesman")
    public static void addSalesman(@QueryParam("salesman") String salesman) {
        catalogue.put(salesman, new ArrayList<>());
    }

    @GET
    @Path("getstore")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getstore(@QueryParam("salesman") String salesman) {
        return Response
                .ok(catalogue.get(salesman), MediaType.APPLICATION_JSON)
                .build();
    }

    public Map<String, List<Product>> getCatalogue() {
        return catalogue;
    }
}
