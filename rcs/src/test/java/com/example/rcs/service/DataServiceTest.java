package com.example.rcs.service;

import com.example.rcs.model.DataModel;
import com.example.rcs.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class DataServiceTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private DataService dataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveData() {
        DataModel data = new DataModel("1", "Test Value");
        dataService.saveData("key1", data);
        verify(dataRepository, times(1)).saveData("key1", data);
    }
}
