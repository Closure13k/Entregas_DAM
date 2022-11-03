package FileModification.CarFiles;

import FileModification.ProgramController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CarController {

    public static void registerNewCar(File file) throws CarDataException {
        String brand, model, price;
        
        brand = ProgramController.requestData("Dame la marca:");
        model = ProgramController.requestData("Dame el modelo:");
        price = ProgramController.requestData("Dame el precio en formato '0.00':");
        
        Car car = new Car(brand, model, price);
        
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));  
                ObjectOutputStream objOut = (objIn.available() > 0)
                ? new ObjectOutputStream(new FileOutputStream(file))
                : new CarOutputStream(new FileOutputStream(file, true));) {
            Car carToCheck;
            try {
                for (;;) {
                    carToCheck = (Car) objIn.readObject();
                    System.out.println(carToCheck);
                    if(carToCheck.getModel().equalsIgnoreCase(car.getModel())){
                        throw new CarDataException("Modelo ya registrado.");
                    }
                }
            } catch (EOFException | ClassNotFoundException ex) {
                System.err.println(ex.getClass().getSimpleName() + " : "+ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println(ex.getClass().getSimpleName() + " : "+ex.getMessage());
        }

    }

    public static void deleteCar(File file, String input) {

    }

    public static void modifyCar(File file, String input) {

    }

    public static void listAllCars(File file) {

    }

}
