package com.fast2.rest.utbildning;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import com.fast2.rest.exception.utbildning.BusinessException;
import com.fast2.rest.utbildning.model.Arbetsorder;



/**
 * to provide path to our webservice
 * the client should use path to acces 
 * @author Bassam Aldalati
 *
 */
@Path("/arbetsorderservice")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
public interface ArbetsorderService {


    @Path("/arbetsorder")
    @GET
    List<Arbetsorder> getArbetsorders();
    
    @Path("/arbetsorder/{id}")
    @GET
    Arbetsorder getArbetsorder(@PathParam(value = "id") long id) throws BusinessException;

    /**
     * good feature for fast2 use response which build in spring boot
     */
    @Path("/arbetsorder")
    @POST
    Response creteArbetsorder(Arbetsorder arbetsorder);
    
    @Path("/arbetsorder")
    @PUT
    Response updateArbetsorder(Arbetsorder arbetsorder) throws BusinessException ;
    
    @Path("/arbetsorder/{id}")
    @DELETE
    Response deleteArbetsorder(@PathParam (value = "id") long id);
}
