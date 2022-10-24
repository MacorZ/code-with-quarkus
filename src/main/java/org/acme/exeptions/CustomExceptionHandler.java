package org.acme.exeptions;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author ToanNT
 */
@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException e) {
        return Response.status(RestResponse.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
