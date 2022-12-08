package com.assignment.loadmanagement.dao;

import com.assignment.loadmanagement.model.Load;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class JpaLoadDaoImpl implements LoadDao {

    private EntityManager entityManager;
    public JpaLoadDaoImpl(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loadmanagement");
        entityManager = entityManagerFactory.createEntityManager();
    }



    @Override
    public Load getLoadById(long id) {
        return entityManager.find(Load.class, id);
    }


    @Override
    public List<Load> getAllLoads() {
        Query query = entityManager.createQuery("SELECT e FROM Load e");
        return query.getResultList();
    }


    @Override
    public void saveLoad(Load load) {
        entityManager.getTransaction().begin();
        entityManager.persist(load);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateLoad(Load load, long id) {
        Load load1 = entityManager.find(Load.class, id);
        entityManager.getTransaction().begin();
        load1.setLoadingPoint(load.getLoadingPoint());
        load1.setUnloadingPoint(load.getUnloadingPoint());
        load1.setProductType(load.getProductType());
        load1.setTruckType(load.getTruckType());
        load1.setNoOfTrucks(load.getNoOfTrucks());
        load1.setWeight(load.getWeight());
        load1.setComment(load.getComment());
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteLoad(long id) {
        entityManager.getTransaction().begin();
        Load load = entityManager.find(Load.class, id);
        entityManager.remove(load);
        entityManager.getTransaction().commit();
    }



}
