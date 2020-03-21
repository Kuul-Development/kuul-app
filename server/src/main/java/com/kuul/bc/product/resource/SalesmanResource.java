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

    private static String salesman = "Max Musterverkäufer";
    private static Product pencil = new Product("Stift", "Gut zu schreiben", 5, salesman, 0.99);
    private static Product flower = new Product("Blume", "Riecht gut", 10, salesman, 1.45);
    private static Product soap = new Product("Seife", "Dreck blitzschnell weg", 3, salesman, 3.99);

    /**
     * Returns the current {@link RadioState} as a {@link Response} object and logs the access.
     *
     * @return the current {@link RadioState}
     */
    @POST
    @Path("products/{product}/{description}/{amount}/{salesman}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putProduct(@PathParam("product") String product, @PathParam("description") String description, @PathParam("amount") long amount, @PathParam("salesman") String salesman, @PathParam("price") double price) {
        Product newProduct = new Product(product, description, amount, salesman, price);

        List<Product> listOfProducts = Arrays.asList(pencil, flower, soap);
        listOfProducts.add(newProduct);
        return Response
                .ok(listOfProducts, MediaType.APPLICATION_JSON)
                .build();
    }
}
