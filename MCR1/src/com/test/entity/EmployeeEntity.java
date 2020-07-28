package com.test.entity;

import java.util.ArrayList;

public class EmployeeEntity {

    private int id;
    // for unique employee
    private static int ID = 1;

    private String name;
    private ArrayList<SlotsEntity> slotsEntities;

    public EmployeeEntity(String name) {
        // call setter and getter so that one more layer can be add
        setId();
        setName(name);
        // Initialization
        slotsEntities = new ArrayList<>();
    }

    // can be called internally
    private void setId() {
        this.id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SlotsEntity> getSlotsEntities() {
        return slotsEntities;
    }

    public void setSlotsEntities(ArrayList<SlotsEntity> slotsEntities) {
        this.slotsEntities = slotsEntities;
    }
}
