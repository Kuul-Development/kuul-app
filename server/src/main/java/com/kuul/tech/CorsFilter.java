package com.kuul.tech;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        response.getHeaders().add("Access-Control-Allow-Origin", "http://testbucket-pekr.s3-website-us-east-1.amazonaws.com/");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, OPTIONS");
    }
}
