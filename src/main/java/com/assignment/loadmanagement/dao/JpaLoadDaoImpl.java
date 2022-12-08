package com.assignment.loadmanagement.dao;

import com.assignment.loadmanagement.model.Load;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class JpaLoadDaoImpl implements LoadDao {
    @Autowired
    private EntityManager entityManager;

    public JpaLoadDaoImpl() {
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
        entityManager.persist(load);
    }

    @Override
    public void updateLoad(Load load) {
        entityManager.merge(load);
    }

    @Override
    public void deleteLoad(long shipmentId) {
        Load load = getLoadById(shipmentId);
        entityManager.remove(load);

    }


}
