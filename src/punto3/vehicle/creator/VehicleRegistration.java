package punto3.vehicle.creator;

import java.io.*;
import java.util.ArrayList;

public class VehicleRegistration {
    private static int count = 0;
    private static File seqFile = new File("vehicle_sequence.ddr");
    private static int id;

    public static void initialize() throws IOException {
        if (seqFile.exists()) {
            DataInputStream input = new DataInputStream(new FileInputStream(seqFile));
            id = input.readInt();
            input.close();
        } else {
            seqFile.createNewFile();
            DataOutputStream output = new DataOutputStream(new FileOutputStream(seqFile));
            output.writeInt(1);
            output.close();
            id = 1;
        }
    }

    public static void save(Vehicle vehicle) throws IOException {
        String filename = "vehicle_" + vehicle.getId() + ".veh";
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(vehicle);
        output.close();
        count++;
        updateSequenceFile();
    }

    private static void updateSequenceFile() throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream(seqFile));
        output.writeInt(id + count);
        output.close();
    }

    public static Vehicle find(int id) throws IOException, ClassNotFoundException {
        String filename = "vehicle_" + id + ".veh";
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        Vehicle vehicle = (Vehicle) input.readObject();
        input.close();
        return vehicle;
    }

    public static ArrayList<Vehicle> findAll() throws IOException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (int i = 1; i <= count; i++) {
            vehicles.add(find(i));
        }
        return vehicles;
    }
}
