package kerkro.bc.facade;

import kerkro.bc.business.HelloWorldBL;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloWorldFacade {
    @Inject
    HelloWorldBL helloWorldBL;

    @GET
    @Produces("text/html")
    @Path("world")
    public String testFunction() {
        return helloWorldBL.getMessage();
    }
}
