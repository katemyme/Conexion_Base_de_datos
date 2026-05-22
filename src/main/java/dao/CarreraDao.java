package dao;

import configuracion.JPAUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import modelos.Carrera;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDao implements  CRUDinterface<Carrera>{


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
            ex.printStackTrace(); // ← esto muestra el error real
        } finally {
            em.close();
        }
    }
}
