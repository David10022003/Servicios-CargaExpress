/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.persistencia.PersistenceManager;
import com.example.dto.RemisionDTO;
import com.example.interfaces.IPersistenciaRemision;
import com.example.logica.ServcioRemision;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/remision")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RemisionService {
    
    
    private IPersistenciaRemision remisionEjb = ServcioRemision.getRemision();

    
    @POST
    @Path("nuevo/")
    public Response agregarRemision (List<RemisionDTO> remisiones) {
        for(RemisionDTO remision : remisiones)
            remisionEjb.create(remision);
        return Response.status(200).header("RemisionCreada", "*").entity(remisiones).build();
    }
    
    @GET
    @Path("buscar/{id}")
    public Response obtenerRemision (@PathParam("id") int id) {
        RemisionDTO temp = remisionEjb.findById(id);
        if(temp != null)
            return Response.status(200).header("RemisionEncontrada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @PUT
    @Path("modificar/")
    public Response modificarRemision (RemisionDTO remision){
        RemisionDTO temp = remisionEjb.update(remision);
        if(temp != null)
            return Response.status(200).header("RemisionModificada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @DELETE
    @Path("eliminar/")
    public Response eliminarRemision (RemisionDTO remision) {
        RemisionDTO temp = remisionEjb.delete(remision);
        if(temp != null)
            return Response.status(200).header("RemisionEliminada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @GET
    @Path("lista/")
    public Response obtenerRemisiones () {
        List<RemisionDTO> temp = remisionEjb.findAll();
        if(temp != null)
            return Response.status(200).header("RemisionesEncontradas", "*").entity(temp).build();
        else
            return Response.status(404).header("NoHayRemisionesRegistradas", "*").build();
    }
}