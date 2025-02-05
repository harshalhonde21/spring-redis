package com.example.rcs.repository;

import com.example.rcs.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public DataRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveData(String key, DataModel data) {
        redisTemplate.opsForValue().set(key, data);
    }

    public DataModel getData(String key) {
        return (DataModel) redisTemplate.opsForValue().get(key);
    }

    public void deleteData(String key) {
        redisTemplate.delete(key);
    }
}
