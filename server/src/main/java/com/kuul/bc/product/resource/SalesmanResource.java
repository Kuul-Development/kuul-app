package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.RadioState;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("salesman")
public class SalesmanResource {

    private static Product pencil = new Product("Stift", "Gut zu schreiben", 5);
    private static Product flower = new Product("Blume", "Riecht gut", 10);
    private static Product soap = new Product("Seife", "Dreck blitzschnell weg", 3);

    /**
     * Returns the current {@link RadioState} as a {@link Response} object and logs the access.
     *
     * @return the current {@link RadioState}
     */
    @POST
    @Path("products/{product}/{description}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putProduct(@PathParam("product") String product, @PathParam("description") String description, @PathParam("amount") long amount) {
        Product newProduct = new Product(product, description, amount);

        List<Product> listOfProducts = Arrays.asList(pencil, flower, soap);
        listOfProducts.add(newProduct);
        return Response
                .ok(listOfProducts, MediaType.APPLICATION_JSON)
                .build();
    }
}
