/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.dto.UsuarioDTO;
import com.example.entity.Usuario;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersistenciaUsuario {
    
    public UsuarioDTO create(UsuarioDTO user);
    public UsuarioDTO update(UsuarioDTO user);
    public UsuarioDTO delete(UsuarioDTO user);
    public List<UsuarioDTO> findAll();
    public UsuarioDTO findById(Integer user);
}
