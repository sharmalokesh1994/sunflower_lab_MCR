package com.test;

import com.test.customexception.CustomException;
import com.test.service.BookEmployeeService;
import com.test.service.EmployeeStatusService;
import com.test.service.UnBookEmployeeService;


public class Test {

    public static void main(String[] args) {


        // for testing we can take inputs also


        // but due to less time I am writing directly

        // get employee Service status
        try {
            EmployeeStatusService.checkEmployeeStatus(1);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        // book two slots
        try {
            BookEmployeeService.bookSlot(1,9);
            BookEmployeeService.bookSlot(1, 11);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        // check status again
        try {
            EmployeeStatusService.checkEmployeeStatus(1);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        // try to book same slot, which is already booked
        try {
            BookEmployeeService.bookSlot(1, 11);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        // UnBook slot and check status
        try {
            UnBookEmployeeService.unBookEmployee(1, 11);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        try {
            EmployeeStatusService.checkEmployeeStatus(1);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        // giving wrong Input
        try {
            EmployeeStatusService.checkEmployeeStatus(10);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }



        /*System.out.println("Welcome ...");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try{
                System.out.println("To ");
            }catch (Exception e){
                System.out.println("Please give correct input");
            }
        }*/
    }

}
