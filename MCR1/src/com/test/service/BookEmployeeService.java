package com.test.service;

import com.test.customexception.CustomException;
import com.test.dao.RISingleton;
import com.test.entity.SlotsEntity;

public class BookEmployeeService {

    private static RISingleton riSingleton = RISingleton.getInstance();

    public static void bookSlot(int empID, int slotId) throws CustomException {

        if( !riSingleton.getEmployeeEntityHashMap().containsKey(empID) ||
                !riSingleton.getSlotsEntityHashMap().containsKey(slotId) ){
            throw new CustomException("Employee or Slot is not present");
        }

        if( riSingleton.getEmployeeSlotRelation().get(slotId) != empID ){
            throw new CustomException("Please give valid input");
        }

        // check slot and employee is available or not

        boolean isBooked = riSingleton.bookEmployee(empID,slotId);
        SlotsEntity slotsEntity = riSingleton.getSlotsEntityHashMap().get(slotId);

        int startTime = 10 + slotsEntity.getSlotNumber();
        int endTime = startTime + 1;
        if(isBooked){
            System.out.println("Employee is booked from : " + startTime + " to "+ endTime);
        }else {
            System.out.println("Employee can not booked from : " + startTime + " to "+ endTime);
        }

    }

    //todo: create a method to check employee slot relationship

}
