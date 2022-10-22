package org.acme;

import org.acme.entitys.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        Person person = Person.builder().name("Toàn").age(20).sex(true).build();
        return Response.ok(person).build();
    }
}