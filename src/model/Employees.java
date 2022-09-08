package model;

import java.io.Serializable;

public class Employees extends Hotel implements PayWage, Serializable {
    private String id;
    private int numberOfWorkingDays;
    private String name;
    private double wage;

    public Employees() {
    }

    public Employees(String id, int numberOfWorkingDays, String name, double wage) {
        this.id = id;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.name = name;
        this.wage = wage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(int numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", numberOfWorkingDays=" + numberOfWorkingDays +
                ", name='" + name + '\'' +
                ", wage=" + wage +
                '}';
    }

    @Override
    public double payWage() {
        double total = getNumberOfWorkingDays()*getWage();
        return total;
    }

    @Override
    public double payForRoom() {
        return 0;
    }
}
