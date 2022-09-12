package views;

import controller.CustomerManagement;
import controller.EmployeeManager;
import model.Customer;
import model.Employees;

import java.util.List;
import java.util.Scanner;

import static controller.CustomerManagement.customerList;
import static controller.EmployeeManager.employeeManagers;

public class Main {
    public static List<Customer> customers = customerList;
    public static List<Employees> employees = employeeManagers;

    public static void main(String[] args) {

        CustomerManagement customerManage = new CustomerManagement();
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Customer manager");
            System.out.println("2. Employees manager");
            String line = sc.nextLine();

            switch (line) {
                case "1": {
                    System.out.println("");
                    System.out.println("1: Add new customer!");
                    System.out.println("2: Display customer!");
                    System.out.println("3: Delete information customer!");
                    System.out.println("4: Charge guest room!");
                    System.out.println("5: To exit!");
                    String inputCustomer = sc.nextLine();
                    switch (inputCustomer) {
                        case "1":

                            System.out.println("Enter numbers of days: ");
                            int numberOfDay = sc.nextInt();
                            System.out.println("Enter type room: ");
                            sc.nextLine();
                            String typeRoom = sc.nextLine();

                            System.out.println("Enter price room: ");
                            double cost = sc.nextDouble();

                            System.out.println("Enter name customer: ");
                            sc.nextLine();
                            String name = sc.nextLine();

                            System.out.println("Enter age: ");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter identityCard");
                            String id = sc.nextLine();
                            Customer customer = new Customer(numberOfDay, typeRoom,cost,id,name,age);

                            customerManage.addInformation(customer);
                            break;
                        case "2":
                            for (Customer list : customerList
                            ) {
                                System.out.println(list.toString());
                            }
                            break;
                        case "3":
                            customerManage.deleteNumOfDay(customerList);
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
                case "2": {
                    System.out.println("");
                    System.out.println("1: Add new employee!");
                    System.out.println("2: Display employees!");
                    System.out.println("3: Delete information employees!");
                    System.out.println("4: Calculate employee salary!");
                    System.out.println("5: To exit!");
                    String inputEmployees = sc.nextLine();
                    switch (inputEmployees) {
                        case "1":
                            System.out.println("Enter idCard: ");
                            String id = sc.nextLine();
                            System.out.println("Enter Number of working days: ");
                            int numOfWorkingDays = sc.nextInt();

                            System.out.println("Enter name employee: ");
                            sc.nextLine();
                            String name = sc.nextLine();

                            System.out.println("Enter wage of employee: ");
                            double wage = sc.nextDouble();
                            Employees employee = new Employees(id,numOfWorkingDays,name,wage);
                            employeeManager.addEmployees(employee);
                            break;
                        case "2":
                            for (Employees list : employees
                            ) {
                                System.out.println(list.toString());
                            }
                            break;
                        case "3":
                            employeeManager.deleteEmployees(employees);
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
