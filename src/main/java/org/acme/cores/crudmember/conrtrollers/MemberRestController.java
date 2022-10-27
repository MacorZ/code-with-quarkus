package org.acme.cores.crudmember.conrtrollers;

import io.vertx.ext.web.RequestBody;
import org.acme.cores.crudmember.services.MemberService;
import org.acme.entitys.Member;
import org.acme.entitys.Person;
import org.acme.exeptions.CustomException;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author ToanNT
 */
@Path("/rest")
public class MemberRestController {
    @Autowired
    private MemberService memberService;

    @Path("/member/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() {
        return Response.ok(memberService.getList()).build();
    }

    @Path("/member/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Member member) {
        return Response.ok(memberService.save(member)).build();
    }

    @Path("/member/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Member member) throws CustomException {
        return Response.ok(memberService.update(id, member)).build();
    }

    @Path("/member/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@RestPath("id") Long id) throws CustomException {
        return Response.ok(memberService.delete(id)).build();
    }

    @Path("/member/list/name")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByTen(@RestQuery("ten") String ten) {
        return Response.ok(memberService.getByTen(ten)).build();
    }
}
