package com.assignment.loadmanagement.dao;

import com.assignment.loadmanagement.model.Load;

import java.util.List;

public interface LoadDao {
    Load getLoadById(long id);
    List<Load> getAllLoads();
    void saveLoad(Load load);
    void updateLoad(Load load,long id);
    void deleteLoad(long id);
}
