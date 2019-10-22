package com.fast2.rest.exception.utbildning;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMappar extends Throwable implements ExceptionMapper<Throwable> {

	private static final long serialVersionUID = 1L;

	@Override
	public Response toResponse(Throwable t) {
		
		if(t instanceof BusinessException) {
			BusinessException businessException = (BusinessException) t;
		    return Response.status(businessException.getErrorCode()).entity(businessException.toJson()).type(MediaType.APPLICATION_JSON).build();
		}else if(t instanceof NotFoundException) {
			BusinessException e = (BusinessException) t;
			BusinessException businessException = new BusinessException("fel : " + e.getMessage(),Response.Status.NOT_FOUND);
			businessException.setFriendlyMessage("resource not found");
			businessException.setMoreInfo(e.getMessage());
			return Response.serverError().status(businessException.getErrorCode()).entity(businessException.toJson()).type(MediaType.APPLICATION_JSON).build();
		}else if(t instanceof WebApplicationException) {
			WebApplicationException we = (WebApplicationException) t;
			BusinessException businessException = new BusinessException("" + t.getMessage() , Response.Status.NOT_FOUND);
			return Response.serverError().status(businessException.getErrorCode()).entity(businessException.toJson()).type(MediaType.APPLICATION_JSON).build();
		}
		
		BusinessException mae = new BusinessException("" + t.getMessage());

		return Response.status(500).entity(mae.toJson()).type(MediaType.APPLICATION_JSON).build();
	}

}
