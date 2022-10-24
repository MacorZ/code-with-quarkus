package org.acme.cores.crudmember.conrtrollers;

import io.vertx.ext.web.RequestBody;
import org.acme.cores.crudmember.services.MemberService;
import org.acme.entitys.Member;
import org.acme.entitys.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
