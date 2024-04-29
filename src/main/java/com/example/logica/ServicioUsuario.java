/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logica;

import com.example.dto.UsuarioDTO;
import com.example.entity.Usuario;
import com.example.excepciones.OperacionInvalidaException;
import com.example.interfaces.IPersistencia;
import com.example.interfaces.IPersistenciaUsuario;
import com.example.persistencia.CargaExpress_Persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServicioUsuario implements IPersistenciaUsuario {
    
    private static final ServicioUsuario usuario = new ServicioUsuario();
    
    private IPersistencia persistencia;

    private ServicioUsuario() {
       this.persistencia = CargaExpress_Persistencia.getInstancia();
    }
    
    public static ServicioUsuario getUsuario() {
        return usuario;
    }
    
    
    
    @Override
    public UsuarioDTO create(UsuarioDTO user) {
        try {
            return (UsuarioDTO) persistencia.create(user);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioDTO update(UsuarioDTO user) {
        return (UsuarioDTO) persistencia.update(user);
    }

    @Override
    public UsuarioDTO delete(UsuarioDTO user) {
        try {
           return (UsuarioDTO) persistencia.delete(user);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<UsuarioDTO> findAll() {
       return persistencia.findAll(Usuario.class);
    }

    @Override
    public UsuarioDTO findById(Integer user) {
      return (UsuarioDTO)((List)persistencia.findById(Usuario.class, user)).get(0);
    }
        
}
