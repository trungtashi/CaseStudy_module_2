package model;

import java.io.Serializable;

public class Customer extends Hotel implements PayForRoom, Serializable {
    private String id;
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer(double numOfDay, String roomType, double cost, String id, String name, int age) {
        super(numOfDay, roomType, cost);
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public double payForRoom() {
        double total = getNumOfDay()*getCost();
        return total;
    }
}
