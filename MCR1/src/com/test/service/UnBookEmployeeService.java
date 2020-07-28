package com.test.service;

import com.test.customexception.CustomException;
import com.test.dao.RISingleton;
import com.test.entity.SlotsEntity;

public class UnBookEmployeeService {

    private static RISingleton riSingleton = RISingleton.getInstance();

    public static void unBookEmployee(int empID, int slotId) throws CustomException {

        if( !riSingleton.getEmployeeEntityHashMap().containsKey(empID) ||
                !riSingleton.getSlotsEntityHashMap().containsKey(slotId) ){
            throw new CustomException("Employee or Slot is not present");
        }

        if( riSingleton.getEmployeeSlotRelation().get(slotId) != empID ){
            throw new CustomException("Please give valid input");
        }

        boolean isBooked = riSingleton.bookEmployee(empID,slotId);

        SlotsEntity slotsEntity = riSingleton.getSlotsEntityHashMap().get(slotId);
        int startTime = 10 + slotsEntity.getSlotNumber();
        int endTime = startTime + 1;
        riSingleton.unBookEmployee(empID, slotId);

        System.out.println("Employee is free from : " + startTime + " to "+ endTime);

    }

}
