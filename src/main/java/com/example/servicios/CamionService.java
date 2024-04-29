/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.persistencia.PersistenceManager;
import com.example.dto.CamionDTO;
import com.example.interfaces.IPersistenciaCamion;
import com.example.logica.ServicioCamion;
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
@Path("/camion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CamionService {
    
  
    
    private IPersistenciaCamion camionEjb = ServicioCamion.getCamion();
    

    
    @POST
    @Path("nuevo/")
    public Response agregarCamion (List<CamionDTO> camiones) {
        for(CamionDTO camion : camiones)
            camionEjb.create(camion);
        return Response.status(200).header("CamionCreado", "*").entity(camiones).build();
    }
    
    @GET
    @Path("buscar/{id}")
    public Response obtenerCamion (@PathParam("id") int id) {
        CamionDTO temp = camionEjb.findById(id);
        if(temp != null)
            return Response.status(200).header("CamionEncontrado", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @PUT
    @Path("modificar/")
    public Response modificarCamion (CamionDTO camion){
        CamionDTO temp = camionEjb.update(camion);
        if(temp != null)
            return Response.status(200).header("CamionModificado", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @DELETE
    @Path("eliminar/")
    public Response eliminarCamion (CamionDTO camion) {
        CamionDTO temp = camionEjb.delete(camion);
        if(temp != null)
            return Response.status(200).header("CamionEliminado", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @GET
    @Path("lista/")
    public Response obtenerCamiones () {
        List<CamionDTO> temp = camionEjb.findAll();
        if(temp != null)
            return Response.status(200).header("CamionesEncontrados", "*").entity(temp).build();
        else
            return Response.status(404).header("NoHayCamionesRegistrados", "*").build();
    }
}

