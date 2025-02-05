package com.example.rcs.controller;

import com.example.rcs.model.DataModel;
import com.example.rcs.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public void saveData(@RequestParam String key, @RequestBody DataModel data) {
        dataService.saveData(key, data);
    }

    @GetMapping("/{key}")
    public DataModel getData(@PathVariable String key) {
        return dataService.getData(key);
    }

    @DeleteMapping("/{key}")
    public void deleteData(@PathVariable String key) {
        dataService.deleteData(key);
    }
}
