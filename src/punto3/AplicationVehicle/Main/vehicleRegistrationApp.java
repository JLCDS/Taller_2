package punto3.AplicationVehicle.Main;

import punto3.vehicle.creator.Vehicle;
import punto3.vehicle.creator.VehicleRegistration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class vehicleRegistrationApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        VehicleRegistration.initialize();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            System.out.println("1. Create a new vehicle.");
            System.out.println("2. Show all vehicles.");
            System.out.println("3. Show a vehicle by ID.");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("License plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    Vehicle vehicle = new Vehicle(brand, model, year, licensePlate, color);
                    VehicleRegistration.save(vehicle);
                    System.out.println("punto3.vehicle.creator.Vehicle saved with ID " + vehicle.getId() + ".");
                    break;
                case 2:
                    ArrayList<Vehicle> vehicles = VehicleRegistration.findAll();
                    for (Vehicle v : vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 3:
                    System.out.print("Enter vehicle ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Vehicle v = VehicleRegistration.find(id);
                    if (v != null) {
                        System.out.println(v);
                    } else {
                        System.out.println("punto3.vehicle.creator.Vehicle not found.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}