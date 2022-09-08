package model;

import java.io.Serializable;

public abstract class Hotel implements PayForRoom , Serializable {
    private double numOfDay;
    private String roomType;
    private double cost;

    public Hotel() {
    }

    public Hotel(double numOfDay, String roomType, double cost) {
        this.numOfDay = numOfDay;
        this.roomType = roomType;
        this.cost = cost;
    }

    public double getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(double numOfDay) {
        this.numOfDay = numOfDay;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public abstract  String getId();
    @Override
    public String toString() {
        return "Room{" +
                ", name='" + numOfDay + '\'' +
                ", roomType='" + roomType + '\'' +
                ", cost=" + cost +
                '}';
    }
}
