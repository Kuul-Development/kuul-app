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
import java.util.Map;

@Path("client")
public class ClientResource {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ClientResource.class);

    /**
     * Returns the current {@link RadioState} as a {@link Response} object and logs the access.
     *
     * @return the current {@link RadioState}
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
}
