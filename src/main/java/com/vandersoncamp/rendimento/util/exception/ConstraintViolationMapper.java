package com.vandersoncamp.rendimento.util.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.*;

/**
 * Classe responsável pela verificação das entidades
 * @author vanderson.campanholi
 */

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Map<String, List<String>> erros = new HashMap<>();

        for (ConstraintViolation<?> v : e.getConstraintViolations()) {
            String value = Optional.ofNullable(v.getInvalidValue()).orElse("NULL").toString();
            erros.put(printPropertyPath(v.getPropertyPath()), Arrays.asList(value, v.getMessage()));
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(erros).build();
    }

    private String printPropertyPath(Path path) {
        if (path == null) {
            return "UNKNOWN";
        }

        String propertyPath = "";
        Path.Node parameterNode = null;
        for (Path.Node node : path) {
            if (node.getKind() == ElementKind.PARAMETER) {
                parameterNode = node;
            }

            if (node.getKind() == ElementKind.PROPERTY) {
                if (!propertyPath.isEmpty()) {
                    propertyPath += ".";
                }
                propertyPath += node;
            }
        }

        if (propertyPath.isEmpty() && parameterNode != null) {
            propertyPath = parameterNode.toString();
        }
        return propertyPath;
    }

}
