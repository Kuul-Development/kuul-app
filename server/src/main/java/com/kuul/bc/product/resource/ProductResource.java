package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.RadioState;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Facade to access the radio
 */
@Path("radio")
public class ProductResource {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ProductResource.class);

    // TODO PeKr This solution is dangerous and should be replaced by a database
    private static RadioState radioState = new RadioState(false);

    /**
     * Returns the current {@link RadioState} as a {@link Response} object and logs the access.
     *
     * @return the current {@link RadioState}
     */
    @GET
    @Path("state")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveRadioState() {
        logger.info("Accessing endpoint state with GET, state {}", radioState.isActive());
        return Response
                .ok(radioState, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Updates the current {@link RadioState} with a new state given by the caller and logs the access.
     *
     * @param active true if radio should be activated, false if it should be deactivated
     * @return the updated {@link RadioState}
     */
    @PUT
    @Path("state")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response updateRadioState(@QueryParam("active") String active) {
        radioState.setActive(true);
        logger.info("Accessing endpoint state with PUT, new state: {}", active);
        return Response
                .ok(radioState, MediaType.APPLICATION_JSON)
                .build();
    }

    public static RadioState getRadioState() {
        return radioState;
    }

    public static void setRadioState(RadioState radioState) {
        ProductResource.radioState = radioState;
    }
}
