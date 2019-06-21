package com.fast2.rest.utbildning;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fast2.rest.utbildning.model.Arbetsorder;



/**
 * to provide path to our webservice
 * the client should use path to acces 
 * @author Bassam Aldalati
 *
 */
@Path("/arbetsorderservice")
public interface ArbetsorderService {


    @Path("/arbetsorder")
    @GET
    List<Arbetsorder> getArbetsorders();
    
    @Path("/arbetsorder/{id}")
    @GET
    Arbetsorder getPatient(@PathParam(value = "id") long id);
    

    /**
     * good feature for fast2 use response which build in spring boot
     */
    @Path("/arbetsorder")
    @POST
    Response creteArbetsorder(Arbetsorder patient);
    
    @Path("/arbetsorder")
    @PUT
    Response updateArbetsorder(Arbetsorder patient);
    
    @Path("/arbetsorder/{id}")
    @DELETE
    Response deleteArbetsorder(@PathParam (value = "id") long id);
}
