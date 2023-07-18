package com.maxx.restApp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;


import com.maxx.showroom.hibernate.entities.BrandEntity;


import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource extends Application {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(MyResource.class);
        classes.add(BrandEntity.class);
        // Add any other providers or resource classes if needed
        return classes;
    }
	
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getIt() {
        return "Got it!";
    }
}
