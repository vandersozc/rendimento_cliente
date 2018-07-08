package com.vandersoncamp.rendimento.util.exception;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Classe responsável pela verificação da existência da entidade
 * @author vanderson.campanholi
 */

@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {

   @Override
   public Response toResponse(EntityNotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).build();
   }
}