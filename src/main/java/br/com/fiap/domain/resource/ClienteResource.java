package br.com.fiap.domain.resource;

import br.com.fiap.domain.entity.Cliente;
import br.com.fiap.domain.repository.ClienteRepository;
import br.com.fiap.domain.service.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;

import java.util.List;
import java.util.Objects;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource implements Resource<Cliente, Long>{

    @Context
    UriInfo uriInfo;

     ClienteService service = new ClienteService();



    @POST
    @Override
    public Response persist(Cliente c) {
       c.setId(null);
       Cliente cliente = service.persist(c);

       if (Objects.isNull(cliente))
           return Response.notModified("Não foi possivel salvar o cliente" +c).build();

       UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
           URI uri = uriBuilder.path(String.valueOf(cliente.getId())).build();

           return Response.created( uri ).entity( cliente ).build();

    }

    @GET
    @Override
    public Response findAll() {
       List<Cliente> all = service.findAll();
       return Response.ok(all).build();
    }


    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {
        Cliente cliente = service.findById(id);
        if (Objects.isNull(cliente)) return Response.status(404).build();
        return Response.ok(cliente).build();
    }

}