package com.assignment.loadmanagement.dao;

import com.assignment.loadmanagement.model.Load;
import jakarta.persistence.*;
import java.util.List;
import java.util.function.Consumer;

public class JpaLoadDaoImpl implements LoadDao {
    private EntityManager entityManager;


    public JpaLoadDaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loadmanagement");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Load getLoadById(long shipmentId) {
        return entityManager.find(Load.class, shipmentId);
    }

    @Override
    public List<Load> getAllLoads() {
        Query query = entityManager.createQuery("SELECT e FROM Load e");
        return query.getResultList();
    }

    @Override
    public void saveLoad(Load load) {
        executeInsideTransaction(entityManager -> entityManager.persist(load));
    }

    @Override
    public void updateLoad(Load load) {
        executeInsideTransaction(entityManager -> entityManager.merge(load));
    }

    @Override
    public void deleteLoad(long shipmentId) {
        executeInsideTransaction(entityManager -> {
            Load load = entityManager.find(Load.class, shipmentId);
            entityManager.remove(load);
        });

    }
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }


}
