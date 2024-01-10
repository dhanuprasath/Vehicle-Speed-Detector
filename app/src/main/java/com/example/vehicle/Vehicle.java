package com.example.vehicle;
public class Vehicle {
    private String name;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleNumber;

    public Vehicle() {
        // Default constructor required for Firebase
    }

    public Vehicle(String name, String vehicleType, String vehicleModel, String vehicleNumber) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
