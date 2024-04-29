/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.persistencia.PersistenceManager;
import com.example.dto.CargaDTO;
import com.example.interfaces.IPersistenciaCarga;
import com.example.logica.ServicioCarga;
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
@Path("/carga")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CargaService {
  
    private IPersistenciaCarga cargaEjb = ServicioCarga.getCarga();

    
    @POST
    @Path("nuevo/")
    public Response agregarCarga (List<CargaDTO> cargas) {
        for(CargaDTO carga : cargas)
            cargaEjb.create(carga);
        return Response.status(200).header("CargaCreada", "*").entity(cargas).build();
    }
    
    @GET
    @Path("buscar/{id}")
    public Response obtenerCarga (@PathParam("id") int id) {
        CargaDTO temp = cargaEjb.findById(id);
        if(temp != null)
            return Response.status(200).header("CargaEncontrada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @PUT
    @Path("modificar/")
    public Response modificarCarga (CargaDTO carga){
        CargaDTO temp = cargaEjb.update(carga);
        if(temp != null)
            return Response.status(200).header("CargaModificada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @DELETE
    @Path("eliminar/")
    public Response eliminarCarga (CargaDTO carga) {
        CargaDTO temp = cargaEjb.delete(carga);
        if(temp != null)
            return Response.status(200).header("CargaEliminada", "*").entity(temp).build();
        else
            return Response.status(404).header("idNoRegistrado", "*").build();
    }
    
    @GET
    @Path("lista/")
    public Response obtenerCargas () {
        List<CargaDTO> temp = cargaEjb.findAll();
        if(temp != null)
            return Response.status(200).header("CargasEncontradas", "*").entity(temp).build();
        else
            return Response.status(404).header("NoHayCargasRegistradas", "*").build();
    }
}
