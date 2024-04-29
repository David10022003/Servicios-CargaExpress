/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.dto.RemisionDTO;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersistenciaRemision {
    public RemisionDTO create(RemisionDTO remision);
    public RemisionDTO update(RemisionDTO remision);
    public RemisionDTO delete(RemisionDTO remision);
    public List<RemisionDTO> findAll();
    public RemisionDTO findById(Integer remision);
}
