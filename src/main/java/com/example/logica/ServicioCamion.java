/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logica;

import com.example.dto.CamionDTO;
import com.example.entity.Camion;
import com.example.excepciones.OperacionInvalidaException;
import com.example.interfaces.IPersistencia;
import com.example.interfaces.IPersistenciaCamion;
import com.example.persistencia.CargaExpress_Persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServicioCamion implements IPersistenciaCamion {
    
    private static final ServicioCamion camion = new ServicioCamion();

     private IPersistencia persistencia;

    private ServicioCamion() {
        this.persistencia = CargaExpress_Persistencia.getInstancia();
    }  
    
    public static ServicioCamion getCamion() {
        return camion;
    }
    
    @Override
    public CamionDTO create(CamionDTO camion) {
        try {
            return (CamionDTO) persistencia.create(camion);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CamionDTO update(CamionDTO camion) {
        return (CamionDTO) persistencia.update(camion);
    }

    @Override
    public CamionDTO delete(CamionDTO camion) {
         try {
             return (CamionDTO) persistencia.delete(camion);
         } catch (OperacionInvalidaException ex) {
             Logger.getLogger(ServicioCamion.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    @Override
    public List<CamionDTO> findAll() {
        return persistencia.findAll(Camion.class);
    }

    @Override
    public CamionDTO findById(Integer camion) {
        return (CamionDTO) ((List)persistencia.findById(Camion.class, camion)).get(0);
    }
    
}
