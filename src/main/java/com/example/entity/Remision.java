/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author USER
 */
@Entity
public class Remision implements Serializable {
    
    @Id
    @GeneratedValue
    private String id;
    private String fechaRecogida;
    private String origen; 
    private String destino;
    private String placaCamion;
    private Usuario conductor;

    public Remision() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPlacaCamion() {
        return placaCamion;
    }

    public void setPlacaCamion(String placaCamion) {
        this.placaCamion = placaCamion;
    }

    public Usuario getConductor() {
        return conductor;
    }

    public void setConductor(Usuario conductor) {
        this.conductor = conductor;
    }
    
    
    
}
