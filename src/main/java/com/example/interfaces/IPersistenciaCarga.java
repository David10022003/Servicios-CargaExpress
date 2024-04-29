/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.dto.CargaDTO;
import com.example.dto.UsuarioDTO;
import com.example.entity.Usuario;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersistenciaCarga {
    public CargaDTO create(CargaDTO carga);
    public CargaDTO update(CargaDTO carga);
    public CargaDTO delete(CargaDTO carga);
    public List<CargaDTO> findAll();
    public CargaDTO findById(Integer carga);
}
