package com.test.dao;

import com.test.entity.EmployeeEntity;
import com.test.entity.SlotsEntity;

import java.util.HashMap;

public class RISingleton {

    private static RISingleton instance;

    private HashMap<Integer, EmployeeEntity> employeeEntityHashMap;
    private HashMap<Integer, SlotsEntity> slotsEntityHashMap;
    private HashMap<Integer, Integer> employeeSlotRelation;

    private RISingleton(){
        // initialization
        employeeEntityHashMap = new HashMap<>();
        slotsEntityHashMap = new HashMap<>();
        employeeSlotRelation = new HashMap<>();

        // considering 2 employee

        EmployeeEntity employee1 = new EmployeeEntity("A");
        EmployeeEntity employee2 = new EmployeeEntity("B");

        // due to time limit considering fixed timeSlots
        // 10 to 17, there will be 7 time slots
        for(int i=0;i<7;i++){
            SlotsEntity slotsEntity = new SlotsEntity(i, false);
            employee1.getSlotsEntities().add(slotsEntity);
            slotsEntityHashMap.put(slotsEntity.getId(), slotsEntity);
            employeeSlotRelation.put(slotsEntity.getId(),employee1.getId());

            SlotsEntity slotsEntity1 = new SlotsEntity(i, false);
            employee2.getSlotsEntities().add(slotsEntity1);
            slotsEntityHashMap.put(slotsEntity1.getId(), slotsEntity1);
            employeeSlotRelation.put(slotsEntity1.getId(), employee2.getId());
        }

        employeeEntityHashMap.put(employee1.getId(),employee1);
        employeeEntityHashMap.put(employee2.getId(), employee2);

    }

    // for make thread Safe make it Synchronized but not considering threading part
    public boolean bookEmployee( int empID, int slotId ){

        EmployeeEntity employeeEntity = employeeEntityHashMap.get(empID);
        SlotsEntity slotsEntity = slotsEntityHashMap.get(slotId);

        //todo :  slots is connected with employee or not

        // check if slot is free
        if( slotsEntity.isStatus() == false ){
            slotsEntity.setStatus(true);
            return true;
        }

        return false;
    }

    public boolean unBookEmployee( int empID, int slotId ){
        EmployeeEntity employeeEntity = employeeEntityHashMap.get(empID);
        SlotsEntity slotsEntity = slotsEntityHashMap.get(slotId);

        // for assignment purpose considering only Single Service
        slotsEntity.setStatus(false);
        return true;
    }

    // for assignment purpose making getter and Setter
    public HashMap<Integer, EmployeeEntity> getEmployeeEntityHashMap() {
        return employeeEntityHashMap;
    }

    public void setEmployeeEntityHashMap(HashMap<Integer, EmployeeEntity> employeeEntityHashMap) {
        this.employeeEntityHashMap = employeeEntityHashMap;
    }

    public HashMap<Integer, SlotsEntity> getSlotsEntityHashMap() {
        return slotsEntityHashMap;
    }

    public void setSlotsEntityHashMap(HashMap<Integer, SlotsEntity> slotsEntityHashMap) {
        this.slotsEntityHashMap = slotsEntityHashMap;
    }

    public HashMap<Integer, Integer> getEmployeeSlotRelation() {
        return employeeSlotRelation;
    }

    public void setEmployeeSlotRelation(HashMap<Integer, Integer> employeeSlotRelation) {
        this.employeeSlotRelation = employeeSlotRelation;
    }

    public static RISingleton getInstance(){
        if(instance==null){
            synchronized (RISingleton.class){
                if(instance==null){
                    instance = new RISingleton();
                }
            }
        }
        return instance;
    }

}
