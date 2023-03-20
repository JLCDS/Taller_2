package punto3.vehicle.creator;

import java.io.*;
import java.util.*;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private String brand;
    private String model;
    private int year;
    private String licensePlate;
    private String color;
    private int id;

    public Vehicle(String brand, String model, int year, String licensePlate, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.color = color;
        this.id = ++count;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + "\nBrand: " + brand + "\nModel: " + model + "\nYear: " + year +
                "\nLicense Plate: " + licensePlate + "\nColor: " + color + "\n";
    }
}

