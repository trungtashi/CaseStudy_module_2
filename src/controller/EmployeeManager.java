package controller;

import model.*;
import storage.ReadAndWriteEmployees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    public static List<Hotel> hotelList = new ArrayList<>();

    public void addEmployees(List<Hotel> hotelList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter idCard: ");
        String id = sc.nextLine();
        System.out.println("Enter Number of working days: ");
        int numOfWorkingDays = sc.nextInt();

        System.out.println("Enter name employee: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter wage of employee: ");
        double wage = sc.nextDouble();
        Employees employees = new Employees(id,numOfWorkingDays,name,wage);
        hotelList.add(employees);
        ReadAndWriteEmployees.writeFile(hotelList);
    }
    public  void deleteEmployees(List<Hotel> hotelList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the idCard to remove!");
        String id = sc.nextLine();
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i) instanceof Employees) {
                if (hotelList.get(i).getId().equals(id))
                    hotelList.remove(hotelList.get(i));
                ReadAndWriteEmployees.writeFile(hotelList);
            } else {
                System.out.println("Not Found Id:");
            }
        }
    }
    public double payWage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id card of employees");
        String id = sc.nextLine();
        double payWage = 0;
        for (int i = 0; i < hotelList.size(); i++) {
            if(hotelList.get(i) instanceof PayWage){
                if(hotelList.get(i).getId().equals(id)){
                    payWage = ((PayWage) hotelList.get(i)).payWage();
                }
            }
        }
        return payWage;
    }

}
