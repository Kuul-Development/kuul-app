package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.RadioState;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("client")
public class ClientResource {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ClientResource.class);

    // TODO PeKr This solution is dangerous and should be replaced by a database
    private static String salesman1 = "Max Musterverkäufer";
    private static String salesman2 = "Hans Wurstverkäufer";
    private static Product pencil = new Product("Stift", "Gut zu schreiben", 5, salesman1, 0.99);
    private static Product flower = new Product("Blume", "Riecht gut", 10, salesman1, 1.45);
    private static Product soap = new Product("Seife", "Dreck blitzschnell weg", 3, salesman1, 3.99);
    private static Product sausage = new Product("Mettwurst", "Lecker schmecker", 6, salesman2, 4.00);

    /**
     * Returns the current {@link RadioState} as a {@link Response} object and logs the access.
     *
     * @return the current {@link RadioState}
     */
    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveListOfProducts() {
        List<Product> listOfProducts = Arrays.asList(pencil, flower, soap, sausage);
        return Response
                .ok(listOfProducts, MediaType.APPLICATION_JSON)
                .build();
    }
}
