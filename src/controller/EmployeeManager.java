package controller;

import model.*;
import storage.employees.DataFileEmployees;
import storage.employees.ReadAndWriteEmployees;

import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    public static List<Employees> employeeManagers;
    private static DataFileEmployees readWriteFile = ReadAndWriteEmployees.getInstance();
    static {
        employeeManagers = readWriteFile.readFile();
    }

    public void addEmployees(Employees employees){
        employeeManagers.add(employees);
        readWriteFile.writeFile(employeeManagers);
    }
    public  void deleteEmployees(List<Employees> employees){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the idCard to remove!");
        String id = sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Employees) {
                if (employees.get(i).getId().equals(id))
                    employees.remove(employees.get(i));
//                ReadAndWriteEmployees.writeFile(employees);
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
        for (int i = 0; i < employeeManagers.size(); i++) {
            if(employeeManagers.get(i) instanceof PayWage){
                if(employeeManagers.get(i).getId().equals(id)){
                    payWage = ((PayWage) employeeManagers.get(i)).payWage();
                }
            }
        }
        return payWage;
    }


}
