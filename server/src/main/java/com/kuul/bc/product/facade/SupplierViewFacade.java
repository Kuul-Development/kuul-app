package com.kuul.bc.product.facade;

import com.kuul.bc.product.business.SupplierViewBL;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Presentation layer for the supplier view
 */
@Path("deliver")
public class SupplierViewFacade {

    @Inject
    private SupplierViewBL supplierViewBL;

    /**
     * Set an order of products to be done
     */
    @PUT
    @Path("done")
    public void markOrderAsDone(@QueryParam("orderId") long orderId) {
      supplierViewBL.markOrderAsDone(orderId);
    }
}
