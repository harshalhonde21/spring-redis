package com.example.rcs.service;

import com.example.rcs.model.DataModel;
import com.example.rcs.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void saveData(String key, DataModel data) {
        dataRepository.saveData(key, data);
    }

    @Cacheable(value = "dataCache", key = "#key")
    public DataModel getData(String key) {
        System.out.println("Fetching from DB, not cache...");
        return dataRepository.getData(key);
    }

    public void deleteData(String key) {
        dataRepository.deleteData(key);
    }
}
