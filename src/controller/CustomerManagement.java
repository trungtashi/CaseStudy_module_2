package controller;

import model.Customer;
import model.PayForRoom;
import storage.customer.DataFile;
import storage.customer.ReadAndWriteCustomer;

import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    public static List<Customer> customerList;
    private static DataFile readWriteFileCustomer = ReadAndWriteCustomer.getInstance();
    static {
        customerList = readWriteFileCustomer.readFile();
    }

    public void addInformation(Customer customer){
        customerList.add(customer);
        readWriteFileCustomer.writeFile(customerList);
    }
    public  void deleteNumOfDay(List<Customer> customers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the idCard to remove!");
        String id = sc.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customerList.get(i) instanceof Customer) {
                if (customerList.get(i).getId().equals(id))
                    customerList.remove(customerList.get(i));
                readWriteFileCustomer.writeFile(customers);
            } else {
                System.out.println("Not Found Id:");
            }
        }
    }
    public double payForRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id card of you");
        String id = sc.nextLine();
        double priceRoom = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i) instanceof PayForRoom){
                if(customerList.get(i).getId().equals(id)){
                    priceRoom = ((PayForRoom) customerList.get(i)).payForRoom();
                }
            }
        }
        return priceRoom;
    }
    public void searchCustomerById(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of customer: ");
        String id = sc.nextLine();
        for (Customer customer: customerList) {
            if(customer.getId().equals(id)){
                System.out.println("Name: "+ customer.getName() +", bill: " + customer.payForRoom());
            }
        }
    }
}
