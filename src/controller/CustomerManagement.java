package controller;

import model.Customer;
import model.PayForRoom;
import storage.customer.DataFile;
import storage.customer.ReadAndWriteCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    public static List<Customer> customerList;
    private static DataFile readWriteFile = ReadAndWriteCustomer.getInstance();
    static {
        customerList = readWriteFile.readFile();
    }

    public void addInformation(Customer customer){
        customerList.add(customer);
        readWriteFile.writeFile(customerList);
    }
    public  void deleteNumOfDay(List<Customer> customers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the idCard to remove!");
        String id = sc.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customerList.get(i) instanceof Customer) {
                if (customerList.get(i).getId().equals(id))
                    customerList.remove(customerList.get(i));
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
}
