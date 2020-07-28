package com.test.entity;

public class SlotsEntity {

    private int id;
    private static int ID = 1;

    // here I am considering fixed slots (1 hrs each)
    // if not fixed then it can be considered start time and end time
    // int startTime and end time with date
    // Here I am considering only for One day due to time constrains
    private int slotNumber;
    // here I am considering all the employees are available
    private boolean status;

    public SlotsEntity(int slotNumber, boolean status) {

        setId();
        this.slotNumber = slotNumber;
        this.status = status;
    }

    private void setId() {
        this.id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
