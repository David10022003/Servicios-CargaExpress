/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logica;

import com.example.dto.CargaDTO;
import com.example.entity.Carga;
import com.example.excepciones.OperacionInvalidaException;
import com.example.interfaces.IPersistencia;
import com.example.interfaces.IPersistenciaCarga;
import com.example.persistencia.CargaExpress_Persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServicioCarga implements IPersistenciaCarga {
    
    private static final ServicioCarga carga = new ServicioCarga();
    
    private IPersistencia persistencia;

    private ServicioCarga() {
        this.persistencia = CargaExpress_Persistencia.getInstancia();
    }
    
    public static ServicioCarga getCarga() {
        return carga;
    }

    @Override
    public CargaDTO create(CargaDTO carga) {
        try {
            return (CargaDTO) persistencia.create(carga);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CargaDTO update(CargaDTO carga) {
        return (CargaDTO) persistencia.update(carga);
    }

    @Override
    public CargaDTO delete(CargaDTO carga) {
        try {
            return (CargaDTO) persistencia.delete(carga);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<CargaDTO> findAll() {
        return persistencia.findAll(Carga.class);
    }

    @Override
    public CargaDTO findById(Integer carga) {
        return (CargaDTO)((List)persistencia.findById(Carga.class, carga)).get(0);
    }
}
