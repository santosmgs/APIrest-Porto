package br.com.fiap.domain.resource;

import br.com.fiap.domain.entity.Bicicleta;
import br.com.fiap.domain.service.BicicletaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("/bicicleta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BicicletaResource implements Resource<Bicicleta, Long> {

    @Context
    UriInfo uriInfo;

     BicicletaService service = new BicicletaService();

    @POST
    @Override
    public Response persist(Bicicleta bicicleta) {
        Bicicleta persit = service.persist(bicicleta);

        if (Objects.isNull(persit)) return Response.status(404).build();

        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        URI uri = uriBuilder.path(String.valueOf(persit.getId())).build();

        return Response.created(uri).entity(persit).build();
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
