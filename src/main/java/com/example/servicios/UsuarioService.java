/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.persistencia.PersistenceManager;
import com.example.dto.UsuarioDTO;
import com.example.interfaces.IPersistenciaUsuario;
import com.example.logica.ServicioUsuario;
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
@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

    
    private IPersistenciaUsuario usuarioEjb = ServicioUsuario.getUsuario();

  
    @POST
    @Path("nuevo/")
    public Response registrarUsuario(UsuarioDTO user) {
        UsuarioDTO temp = usuarioEjb.create(user);
        if (temp != null) {
            return Response.status(200).header("UsuarioCreado", "*").entity(temp).build();
        } else {
            return Response.status(417).header("ErrorAlCrearUsuario", "*").build();
        }
    }

    @GET
    @Path("buscar/{id}")
    public Response obtenerUsuario(@PathParam("id") int id) {
        UsuarioDTO temp = usuarioEjb.findById(id);
        if (temp != null) {
            return Response.status(200).header("UsuarioEncontrado", "*").entity(temp).build();
        } else {
            return Response.status(404).header("idNoRegistrado", "*").build();
        }
    }

    @PUT
    @Path("actualizar/")
    public Response actualizarUsuario(UsuarioDTO usuario) {
        UsuarioDTO temp = usuarioEjb.update(usuario);
        if (temp != null) {
            return Response.status(200).header("UsuarioActualizado", "*").entity(temp).build();
        } else {
            return Response.status(404).header("idNoRegistrado", "*").build();
        }
    }

    @DELETE
    @Path("deshabilitar/")
    public Response deshabilitarUsuario(UsuarioDTO usuario) {
        UsuarioDTO temp = usuarioEjb.delete(usuario);
        if (temp != null) {
            return Response.status(200).header("UsuarioDeshabilitado", "*").entity(temp).build();
        } else {
            return Response.status(404).header("idNoRegistrado", "*").build();
        }
    }

    @GET
    @Path("lista/")
    public Response obtenerUsuarios() {
        List<UsuarioDTO> temp = usuarioEjb.findAll();
        if (temp != null) {
            return Response.status(200).header("UsuariosEncontrados", "*").entity(temp).build();
        } else {
            return Response.status(404).header("NoHayUsuariosRegistrados", "*").build();
        }
    }
}
