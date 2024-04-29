/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logica;

import com.example.dto.RemisionDTO;
import com.example.entity.Remision;
import com.example.excepciones.OperacionInvalidaException;
import com.example.interfaces.IPersistencia;
import com.example.interfaces.IPersistenciaRemision;
import com.example.persistencia.CargaExpress_Persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServcioRemision implements IPersistenciaRemision {
    
    private static final ServcioRemision remision = new ServcioRemision();
    
    private IPersistencia persistencia;

    private ServcioRemision() {
        this.persistencia = CargaExpress_Persistencia.getInstancia();
    }
    
    public static ServcioRemision getRemision() {
        return remision;
    }

    @Override
    public RemisionDTO create(RemisionDTO remision) {
        try {
            return (RemisionDTO) persistencia.create(remision);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServcioRemision.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RemisionDTO update(RemisionDTO remision) {
        return (RemisionDTO) persistencia.update(remision);
    }

    @Override
    public RemisionDTO delete(RemisionDTO remision) {
         try {
             return (RemisionDTO) persistencia.delete(remision);
         } catch (OperacionInvalidaException ex) {
             Logger.getLogger(ServcioRemision.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    @Override
    public List<RemisionDTO> findAll() {
        return persistencia.findAll(Remision.class);
    }

    @Override
    public RemisionDTO findById(Integer remision) {
        return (RemisionDTO)((List)persistencia.findById(Remision.class, remision)).get(0);
    }
}
