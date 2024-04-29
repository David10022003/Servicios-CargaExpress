/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.excepciones.OperacionInvalidaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPersistencia {
    
    public Object create(Object obj) throws OperacionInvalidaException;
    public Object update(Object obj);
    public Object delete(Object obj) throws OperacionInvalidaException;
    public List findAll(Class c);
    public Object findById(Class c, Object id);
    
}
