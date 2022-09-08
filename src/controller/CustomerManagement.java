package controller;

import model.Customer;
import model.PayForRoom;
import model.Hotel;
import storage.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    public static List<Hotel> hotelList = new ArrayList<>();

    public void addInformation(List<Hotel> hotelList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers of days: ");
        int numberOfDay = sc.nextInt();
        System.out.println("Enter type room: ");
        sc.nextLine();
        String typeRoom = sc.nextLine();

        System.out.println("Enter price room: ");
        double cost = sc.nextDouble();

        System.out.println("Enter name person: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter identityCard");
        String id = sc.nextLine();
        Customer customer = new Customer(numberOfDay, typeRoom,cost,id,name,age);
        hotelList.add(customer);
        ReadAndWrite.writeFile(hotelList);
    }
    public  void deleteNumOfDay(List<Hotel> hotelList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the idCard to remove!");
        String id = sc.nextLine();
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i) instanceof Customer) {
                if (hotelList.get(i).getId().equals(id))
                    hotelList.remove(hotelList.get(i));
                ReadAndWrite.writeFile(hotelList);
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
        for (int i = 0; i < hotelList.size(); i++) {
            if(hotelList.get(i) instanceof PayForRoom){
                if(hotelList.get(i).getId().equals(id)){
                    priceRoom = ((PayForRoom) hotelList.get(i)).payForRoom();
                }
            }
        }
        return priceRoom;
    }
}
