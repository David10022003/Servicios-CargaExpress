/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;

/**
 *
 * @author USER
 */
public class CamionDTO {
    
    private int id;
    private String placa;
    private String modelo;
    private String capacidad;
    private String tipoCarroceria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CamionDTO() {
    }

    public CamionDTO(String placa) {
        this.placa = placa;
    }

    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }
    
    
    
}
