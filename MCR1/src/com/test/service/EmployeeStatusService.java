package com.test.service;

import com.test.customexception.CustomException;
import com.test.dao.RISingleton;
import com.test.entity.EmployeeEntity;
import com.test.entity.SlotsEntity;

public class EmployeeStatusService {

    private static RISingleton riSingleton = RISingleton.getInstance();

    public static void checkEmployeeStatus(int empID) throws CustomException {
        // todo : check if the employee is available

        if( !riSingleton.getEmployeeEntityHashMap().containsKey(empID) ){
            throw new CustomException("Employee is not present");
        }
        EmployeeEntity employeeEntity = riSingleton.getEmployeeEntityHashMap().get(empID);

        System.out.println("Employee Name : " + employeeEntity.getName());
        for(SlotsEntity slotsEntity : employeeEntity.getSlotsEntities()){
            int slotNumber = slotsEntity.getSlotNumber();
            System.out.println("SlotID : " + slotsEntity.getId());
            int startTime = 10+slotNumber;
            int endTime = startTime + 1;

            System.out.println("Start Time : "+startTime);
            System.out.println("End Time : "+ endTime);
            System.out.println("Status : "+slotsEntity.isStatus());

            System.out.println();

        }

    }

}
