/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileModification;

import FileModification.CarFiles.CarController;
import FileModification.CarFiles.CarDataException;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author AaronFM
 */
public class ProgramController {

    public static String requestData(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static void showData(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    protected static String menu() {
        return """
               1. A\u00f1adir coche.
               2, Borrar coche.
               3. Modificar coche
               4. Listar coches
               
               0. Salir""";
    }
    protected static void actionManager(int option, File file) throws CarDataException{
        String input;
        switch (option) {
                case 1 -> {
                    CarController.registerNewCar(file);
                }
                case 2 -> {
                    input = requestData("Dame el modelo del coche.");
                    CarController.deleteCar(file, input);
                }
                case 3 -> {
                    input = requestData("Dame el modelo del coche.");
                    CarController.modifyCar(file, input);
                }
                case 4 -> {
                    CarController.listAllCars(file);
                }
                case 0 -> {
                    System.out.println("FINISHED!");
                }
                default -> {
                    showData("Opcion no válida");
                }
            }
    }
}
