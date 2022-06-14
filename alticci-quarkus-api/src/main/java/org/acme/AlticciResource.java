package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/alticci")
@Tag(name = "Alticci Resource", description = "Alticci REST API")
public class AlticciResource {

    private int[] cache = new int[1048];

    private int AlticciiOf(int n){
        if(cache[n]!=0){
            return cache[n];
        }

        if(n<=0){
            return cache[0];
        }

        if(n==1){
            cache[n] = 1;
            return cache[n];
        }

        if(n==2){
            cache[n] = 1;
            return cache[n];
        }

        int result = AlticciiOf(n-3) + AlticciiOf(n-2);
        cache[n] = result;
        return cache[n];
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
        operationId = "getAlticciN",
        summary = "Get the Nth term of Alticci sequency",
        description = "The Alticci sequency - a(n) - is defined as: n=0 => a(0) = 0, n=1 => a(1) = 1, n=2 => a(2) = 1 and n>2 => a(n) = a(n-3) + a(n-2)"
    )
    @APIResponse(
        responseCode = "200",
        description = "Operation completed",
        content = @Content(mediaType = "text/plain")
    )
    @Path("/{n}")
    public int alticci(
        @Parameter(
            description = "Nth term of Alticci sequency",
            required = true
        )
        @PathParam("n") int n){
        return AlticciiOf(n);
    }

}