/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.persistencia;

import com.example.dto.CamionDTO;
import com.example.dto.CargaDTO;
import com.example.dto.RemisionDTO;
import com.example.dto.UsuarioDTO;
import com.example.entity.Camion;
import com.example.entity.Carga;
import com.example.entity.Remision;
import com.example.entity.Usuario;
import com.example.excepciones.OperacionInvalidaException;
import com.example.interfaces.IPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author USER
 */
public class CargaExpress_Persistencia implements IPersistencia {
    
    private static final CargaExpress_Persistencia instancia = new CargaExpress_Persistencia();
    
    private EntityManager entityManager;
    
    private CargaExpress_Persistencia() {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }
    
    public static CargaExpress_Persistencia getInstancia() {
        return instancia;
    }
        
        
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public Object create(Object obj) throws OperacionInvalidaException {
        if (obj instanceof CamionDTO) {
            CamionDTO v = (CamionDTO) obj;
            Camion crear = new Camion();
            crear.setId(v.getId());
            crear.setPlaca(v.getPlaca());
            crear.setModelo(v.getModelo());
            crear.setCapacidad(v.getCapacidad());
            crear.setTipoCarroceria(v.getTipoCarroceria());
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                System.out.println("NO CREADO");
            } finally {
                entityManager.clear();
            }
            System.out.println("CREADO");
            return obj;
        }
        else if (obj instanceof CargaDTO) {
            CargaDTO m = (CargaDTO) obj;
            Carga crear = new Carga();
            crear.setDestino(m.getDestino());
            crear.setDimensiones(m.getDimensiones());
            crear.setEmpaque(m.getDimensiones());
            crear.setFecha(m.getFecha());
            crear.setOrigen(m.getOrigen());
            crear.setId(m.getId());
            crear.setPeso(m.getPeso());
            crear.setPropietario(m.getPropietario());
            crear.setValorAsegurado(m.getValorAsegurado());
             try {
                entityManager.getTransaction().begin();
                entityManager.persist(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                return null;
            } finally {
                entityManager.clear();
            }
            return obj;
        } 
        else if (obj instanceof RemisionDTO){
            Remision crear = new Remision();
            RemisionDTO m = (RemisionDTO) obj;
            crear.setId(m.getId());
            crear.setConductor(m.getConductor());
            crear.setDestino(m.getDestino());
            crear.setFechaRecogida(m.getFechaRecogida());
            crear.setOrigen(m.getOrigen());
            crear.setPlacaCamion(m.getPlacaCamion());
             try {
                entityManager.getTransaction().begin();
                entityManager.persist(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
              return null;
            } finally {
                entityManager.clear();
            }
            return obj;
        } 
        else if (obj instanceof UsuarioDTO) {
            Usuario crear = new Usuario();
            UsuarioDTO m = (UsuarioDTO) obj;
            crear.setId(m.getId());
            crear.setContrasena(crear.getContrasena());
            crear.setCorreo(m.getCorreo());
            crear.setDireccion(m.getDireccion());
            crear.setNombre(m.getNombre());
            crear.setRol(m.getRol());
            crear.setTelefono(m.getTelefono());
             try {
                entityManager.getTransaction().begin();
                entityManager.persist(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                System.out.println("NO CREADO");
               return obj;
            } finally {
                entityManager.clear();
            }
             System.out.println("CREADO");
            return obj;
        } 
        return null;
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public Object update(Object obj){
        if (obj instanceof CamionDTO) {
            CamionDTO v = (CamionDTO) obj;
            Camion crear = new Camion();
            crear.setId(v.getId());
            crear.setPlaca(v.getPlaca());
            crear.setModelo(v.getModelo());
            crear.setCapacidad(v.getCapacidad());
            crear.setTipoCarroceria(v.getTipoCarroceria());
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
            return obj;
        }
        else if (obj instanceof CargaDTO) {
            CargaDTO m = (CargaDTO) obj;
            Carga crear = new Carga();
            crear.setDestino(m.getDestino());
            crear.setId(m.getId());
            crear.setDimensiones(m.getDimensiones());
            crear.setEmpaque(m.getDimensiones());
            crear.setFecha(m.getFecha());
            crear.setOrigen(m.getOrigen());
            crear.setPeso(m.getPeso());
            crear.setPropietario(m.getPropietario());
            crear.setValorAsegurado(m.getValorAsegurado());
             try {
                entityManager.getTransaction().begin();
                entityManager.merge(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
             return obj;
        } 
        else if (obj instanceof RemisionDTO){
            Remision crear = new Remision();
            RemisionDTO m = (RemisionDTO) obj;
            crear.setConductor(m.getConductor());
            crear.setDestino(m.getDestino());
            crear.setId(m.getId());
            crear.setFechaRecogida(m.getFechaRecogida());
            crear.setOrigen(m.getOrigen());
            crear.setPlacaCamion(m.getPlacaCamion());
             try {
                entityManager.getTransaction().begin();
                entityManager.merge(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
             return obj;
        } 
        else if (obj instanceof UsuarioDTO) {
            Usuario crear = new Usuario();
            UsuarioDTO m = (UsuarioDTO) obj;
            crear.setId(m.getId());
            crear.setContrasena(crear.getContrasena());
            crear.setCorreo(m.getCorreo());
            crear.setDireccion(m.getDireccion());
            crear.setNombre(m.getNombre());
            crear.setRol(m.getRol());
            crear.setTelefono(m.getTelefono());
             try {
                entityManager.getTransaction().begin();
                entityManager.merge(crear);
                entityManager.getTransaction().commit();
                entityManager.refresh(crear);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
            return obj;
        } 
        return null;
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public Object delete(Object obj) throws OperacionInvalidaException{
       if (obj instanceof CamionDTO) {
            CamionDTO v = (CamionDTO) obj;
            Camion crear = new Camion();
            crear.setPlaca(v.getPlaca());
            crear.setId(v.getId());
            crear.setModelo(v.getModelo());
            crear.setCapacidad(v.getCapacidad());
            crear.setTipoCarroceria(v.getTipoCarroceria());
            try {
                entityManager.getTransaction().begin();
                Camion managedUsuario = entityManager.merge(crear);
                entityManager.remove(managedUsuario);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
            return obj;
        }
        else if (obj instanceof CargaDTO) {
            CargaDTO m = (CargaDTO) obj;
            Carga crear = new Carga();
            crear.setDestino(m.getDestino());
            crear.setDimensiones(m.getDimensiones());
            crear.setEmpaque(m.getDimensiones());
            crear.setFecha(m.getFecha());
            crear.setId(m.getId());
            crear.setOrigen(m.getOrigen());
            crear.setPeso(m.getPeso());
            crear.setPropietario(m.getPropietario());
            crear.setValorAsegurado(m.getValorAsegurado());
             try {
                entityManager.getTransaction().begin();
                Carga managedUsuario = entityManager.merge(crear);
                entityManager.remove(managedUsuario);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
             return obj;
        } 
        else if (obj instanceof RemisionDTO){
            Remision crear = new Remision();
            RemisionDTO m = (RemisionDTO) obj;
            crear.setConductor(m.getConductor());
            crear.setDestino(m.getDestino());
            crear.setId(m.getId());
            crear.setFechaRecogida(m.getFechaRecogida());
            crear.setOrigen(m.getOrigen());
            crear.setPlacaCamion(m.getPlacaCamion());
             try {
                entityManager.getTransaction().begin();
                Remision managedUsuario = entityManager.merge(crear);
                entityManager.remove(managedUsuario);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
             return obj;
        } 
        else if (obj instanceof UsuarioDTO) {
            Usuario crear = new Usuario();
            UsuarioDTO m = (UsuarioDTO) obj;
            crear.setContrasena(crear.getContrasena());
            crear.setCorreo(m.getCorreo());
            crear.setId(m.getId());
            crear.setDireccion(m.getDireccion());
            crear.setNombre(m.getNombre());
            crear.setRol(m.getRol());
            crear.setTelefono(m.getTelefono());
             try {
                entityManager.getTransaction().begin();
                Usuario managedUsuario = entityManager.merge(crear);
                entityManager.remove(managedUsuario);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
             return obj;
        } 
       return null;
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c) {
        List findAll = null;
        if (c.equals(Camion.class)) {   
            try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT c FROM Camion c");
                List temp = query.getResultList();
                findAll = convertToDTO(Camion.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
        } 
        else if (c.equals(Carga.class)) {
            try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT c FROM Carga c");
                List temp = query.getResultList();
                findAll = convertToDTO(Carga.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
        } 
        else if (c.equals(Usuario.class)) {
            try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT c FROM Usuario c");
                List temp = query.getResultList();
                findAll = convertToDTO(Usuario.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
        } 
        else if (c.equals(Remision.class)) {
            try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT c FROM Remision c");
                List temp = query.getResultList();
                findAll = convertToDTO(Remision.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
        }
        return findAll;
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id){
        List temp;
        Object salida = null;
        if (c.equals(Camion.class))
        {
            Camion find = null;
            try {
                entityManager.getTransaction().begin();
                temp = new ArrayList<Camion>();
                temp.add(entityManager.find(Camion.class, id));
                salida = convertToDTO(Camion.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            }
            return salida;
        } 
        else if (c.equals(Carga.class))
        {
         Carga find = null;
            try {
                entityManager.getTransaction().begin();
                temp = new ArrayList<Carga>();
                temp.add(entityManager.find(Camion.class, id));
                salida = convertToDTO(Carga.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            } 
            return salida;
        } 
        else if (c.equals(Usuario.class))
        {
           Usuario find = null;
            try {
                entityManager.getTransaction().begin();
                temp = new ArrayList<Usuario>();
                temp.add(entityManager.find(Usuario.class, id));
                salida = convertToDTO(Usuario.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            } 
            return salida;
        }
        else if(c.equals(Remision.class)) {
            Remision find = null;
            try {
                entityManager.getTransaction().begin();
                temp = new ArrayList<Remision>();
                temp.add(entityManager.find(Remision.class, id));
                salida = convertToDTO(Carga.class, temp);
                entityManager.getTransaction().commit();
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
            } 
            return salida;            
        }
        return null;
    }
    
    public List convertToDTO(Class c, List object) {
        List result = null;
        if(c.equals(Usuario.class)) {
            result = new ArrayList<UsuarioDTO>();
            for(Object u : object) {
                Usuario user = (Usuario)u;
                UsuarioDTO temp = new UsuarioDTO();
                temp.setContrasena(user.getContrasena());
                temp.setCorreo(user.getCorreo());
                temp.setId(user.getId());
                temp.setDireccion(user.getDireccion());
                temp.setNombre(user.getNombre());
                temp.setRol(user.getRol());
                temp.setTelefono(user.getTelefono());
                result.add(temp);
            }
        }
        else if (c.equals(Camion.class)) {
            result = new ArrayList<CamionDTO>();
            for(Object u : object) {
                Camion user = (Camion)u;
                CamionDTO temp = new CamionDTO();
                temp.setCapacidad(user.getCapacidad());
                temp.setModelo(user.getModelo());
                temp.setPlaca(user.getPlaca());
                temp.setId(user.getId());
                temp.setTipoCarroceria(user.getTipoCarroceria());
                result.add(temp);
            }
        }
        else if(c.equals(Carga.class)) {
            result = new ArrayList<CargaDTO>();
            for(Object u : object) {
                Carga user = (Carga)u;
                CargaDTO temp = new CargaDTO();
                temp.setDestino(user.getDestino());
                temp.setDimensiones(user.getDimensiones());
                temp.setEmpaque(user.getEmpaque());
                temp.setFecha(user.getFecha());
                temp.setId(user.getId());
                temp.setOrigen(user.getOrigen());
                temp.setPeso(user.getPeso());
                temp.setPropietario(user.getPropietario());
                temp.setValorAsegurado(user.getValorAsegurado());
                result.add(temp);
            }
        }
        else if(c.equals(Remision.class)) {
            result = new ArrayList<RemisionDTO>();
            for(Object u : object) {
                Remision user = (Remision)u;
                RemisionDTO temp = new RemisionDTO();
                temp.setConductor(user.getConductor());
                temp.setDestino(user.getDestino());
                temp.setFechaRecogida(user.getFechaRecogida());
                temp.setId(user.getId());
                temp.setOrigen(user.getOrigen());
                temp.setPlacaCamion(user.getPlacaCamion());
                result.add(temp);
            }
        }
        return result;
    }
    
}
