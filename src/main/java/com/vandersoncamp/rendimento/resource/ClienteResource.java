package com.vandersoncamp.rendimento.resource;import com.vandersoncamp.rendimento.business.ClienteBusiness;import com.vandersoncamp.rendimento.business.EmprestimoBO;import com.vandersoncamp.rendimento.model.Cliente;import javax.enterprise.context.RequestScoped;import javax.inject.Inject;import javax.ws.rs.*;import javax.ws.rs.core.MediaType;import javax.ws.rs.core.Response;/** * Classe responsável por mapear os serviços acessados pelo front-end * @author vanderson.campanholi */@Path("/clientes")@RequestScopedpublic class ClienteResource {    @Inject    private ClienteBusiness business;    @GET    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    public Response find(@PathParam("id") Long id) {        Cliente cliente = business.find(id);        if (cliente == null) {            return Response.status(Response.Status.NOT_FOUND).build();        }        return Response.ok(cliente).build();    }    @GET    @Produces(MediaType.APPLICATION_JSON)    public Response findAll(            @QueryParam("page")            @DefaultValue("1") Integer pageNumber,            @QueryParam("size")            @DefaultValue("15") Integer pageSize,            @QueryParam("filterField") String filterField,            @QueryParam("filterValue") String filterValue,            @QueryParam("order") String order) {        Long total = business.getCount(filterField, filterValue);        Response.Status responseStatus = (pageNumber * pageSize < total) ? Response.Status.PARTIAL_CONTENT : Response.Status.OK;        Response response = Response.status(responseStatus)                .entity(business.findAll(pageSize, pageNumber, filterField, filterValue, order)).build();        response.getHeaders().add("X-Total-Lenght", total);        response.getHeaders().add("X-Page-Size", pageSize);        response.getHeaders().add("X-Current-Page", pageNumber);        return response;    }    //@GET   // @Produces(MediaType.APPLICATION_JSON)   // public Response findAll(   //         @QueryParam("filterField") String filterField,   //         @QueryParam("filterValue") String filterValue,   //         @QueryParam("order") String order) {   //     return Response.ok(business.findAll(filterField, filterValue, order)).build();    //}    @POST    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response create(Cliente cliente) {        business.create(cliente);        return Response.status(Response.Status.CREATED).entity(cliente).build();    }    @PUT    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response update(@PathParam("id") Long id, Cliente cliente) {        if (business.find(id) == null) {            return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();        }        business.update(cliente);        return Response.status(Response.Status.OK).entity(cliente).build();    }    @DELETE    @Path("{id}")    public Response delete(@PathParam("id") Long id) {        business.delete(id);        return Response.status(Response.Status.NO_CONTENT).build();    }    @PUT    @Path("simular-emprestimo")    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response simularEmprestimo(EmprestimoBO emprestimo) {        business.simulaValorImprestimo(emprestimo);        return Response.status(Response.Status.OK).entity(emprestimo).build();    }}