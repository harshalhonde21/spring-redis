package com.example.rcs.model;

import java.io.Serializable;

public class DataModel implements Serializable {
    private String id;
    private String value;

    public DataModel() {}

    public DataModel(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
