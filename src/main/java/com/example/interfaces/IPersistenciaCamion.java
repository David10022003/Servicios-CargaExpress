/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.dto.CamionDTO;
import com.example.entity.Camion;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersistenciaCamion {
    public CamionDTO create(CamionDTO camion);
    public CamionDTO update(CamionDTO camion);
    public CamionDTO delete(CamionDTO camion);
    public List<CamionDTO> findAll();
    public CamionDTO findById(Integer camion);
}
