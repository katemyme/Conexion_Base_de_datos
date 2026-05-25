package dao;

import configuracion.JPAUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import modelos.Carrera;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDao implements  CRUDinterface<Carrera>{


    @Override
    public void eliminar (Long id ){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Carrera carrera = em.find(Carrera.class, id);
            if ( carrera != null){
                em.remove(carrera);
                JOptionPane.showMessageDialog(null, "Eliminado exitoso");
            }else {
                JOptionPane.showMessageDialog(null, "No se encontro la carrera");
            }
            em.getTransaction().commit();
        }catch (Exception ex ){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void Actualizar(Carrera object) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            System.out.println("Actualizado exitoso");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
    @Override
    public List<Carrera> listar() {
        List<Carrera> carreras = new ArrayList<>();

        EntityManager em = JPAUtil.getEntityManager();
        try{
            carreras = em.createQuery( "select  c from Carrera c", Carrera.class).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return carreras;
    }
    @Override
    public void guardar(Carrera object) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("Guardado exitoso");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
