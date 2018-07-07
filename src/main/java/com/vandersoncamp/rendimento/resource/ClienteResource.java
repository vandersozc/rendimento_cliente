package com.vandersoncamp.rendimento.resource;import com.vandersoncamp.rendimento.business.ClienteBusiness;import com.vandersoncamp.rendimento.model.Cliente;import javax.enterprise.context.RequestScoped;import javax.inject.Inject;import javax.ws.rs.*;import javax.ws.rs.core.MediaType;import javax.ws.rs.core.Response;@Path("/clientes")@RequestScopedpublic class ClienteResource {    @Inject    private ClienteBusiness business;    @GET    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    public Response find(@PathParam("id") Long id) {        Cliente cliente = business.find(id);        if (cliente == null) {            return Response.status(Response.Status.NOT_FOUND).build();        }        return Response.ok(cliente).build();    }    @GET    @Produces(MediaType.APPLICATION_JSON)    public Response findAll(            @QueryParam("filterField") String filterField,            @QueryParam("filterValue") String filterValue,            @QueryParam("order") String order) {        return Response.ok(business.findAll(filterField, filterValue, order)).build();    }    @POST    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response create(Cliente cliente) {        business.create(cliente);        return Response.status(Response.Status.CREATED).entity(cliente).build();    }    @PUT    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response update(Cliente cliente, @PathParam("id") Long id) {        if (business.find(id) == null) {            return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();        }        business.update(id, cliente);        return Response.status(Response.Status.OK).entity(cliente).build();    }}