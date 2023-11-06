package br.com.fiap.domain.resource;

import br.com.fiap.domain.entity.Bicicleta;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Objects;

@Path("/animal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BicicletaResource implements Resource<Bicicleta, Long> {

    @Context
    UriInfo uriInfo;

    private BicicletaResource service = new BicicletaResource();

    @GET
    @Override
    public Response persist(Bicicleta bicicleta) {
        return null;
    }

    @GET
    @Override
    public Response findAll() {
        List all = service.findAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {
        Bicicleta bicicleta = service.findById(id);
        if (Objects.isNull(bicicleta)) return Response.status(404).build();
        return Response.ok(bicicleta).build();
    }

}
