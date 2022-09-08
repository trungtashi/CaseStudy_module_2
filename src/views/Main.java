package views;

import controller.CustomerManagement;
import controller.EmployeeManager;
import model.Hotel;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Hotel> hotelList = CustomerManagement.hotelList;

    public static void main(String[] args) {

        CustomerManagement customerManage = new CustomerManagement();
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("A. Customer manager");
            System.out.println("B. Employees manager");
            String line = sc.nextLine();

            switch (line) {
                case "a": {
                    System.out.println("");
                    System.out.println("1: Add new customer!");
                    System.out.println("2: Display customer!");
                    System.out.println("3: Delete information customer!");
                    System.out.println("4: Charge guest room!");
                    System.out.println("5: To exit!");
                    String customer = sc.nextLine();
                    switch (customer) {
                        case "1":
                            customerManage.addInformation(hotelList);
                            break;
                        case "2":
                            for (Hotel list : hotelList
                            ) {
                                System.out.println(list.toString());
                            }
                            break;
                        case "3":
                            customerManage.deleteNumOfDay(hotelList);
                            break;
                        case "4":
                            System.out.println("Bill: " + customerManage.payForRoom());
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                //            Employees manager
                case "b": {
                    System.out.println("");
                    System.out.println("1: Add new employee!");
                    System.out.println("2: Display employees!");
                    System.out.println("3: Delete information employees!");
                    System.out.println("4: Calculate employee salary!");
                    System.out.println("5: To exit!");
                    String employees = sc.nextLine();
                    switch (employees) {
                        case "1":
                            employeeManager.addEmployees(hotelList);
                            break;
                        case "2":
                            for (Hotel list : hotelList
                            ) {
                                System.out.println(list.toString());
                            }
                            break;
                        case "3":
                            employeeManager.deleteEmployees(hotelList);
                            break;
                        case "4":
                            System.out.println("Total: " + employeeManager.payWage());
                            break;

                        default:
                            System.out.println("Invalid");
                            break;
                    }
                }
            }
        }
    }
}
