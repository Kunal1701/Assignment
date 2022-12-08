package com.assignment.loadmanagement.controller;

import com.assignment.loadmanagement.dao.JpaLoadDaoImpl;
import com.assignment.loadmanagement.dao.LoadDao;
import com.assignment.loadmanagement.model.Load;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoadController {

        private LoadDao loadDao;
        public LoadController(){
            loadDao = new JpaLoadDaoImpl();
        }

    @PostMapping("/load")
        public void saveLoad(@RequestBody Load load){
            loadDao.saveLoad(load);
        }
        @GetMapping("/load/{id}")
        public Load getLoadById(@PathVariable String id){
            return loadDao.getLoadById(Long.parseLong(id));
        }
        @GetMapping("/load")
        public List<Load> getAllLoads(){
            return loadDao.getAllLoads();
        }
        @DeleteMapping("/load/{id}")
        public void deleteLoad( @PathVariable String id){
            loadDao.deleteLoad(Long.parseLong(id));
        }
        @PutMapping("/load/{id}")
        public void updateLoad(@RequestBody Load load, @PathVariable String id){
            loadDao.updateLoad(load, Long.parseLong(id));

        }

}
