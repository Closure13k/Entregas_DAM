/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import cars.Car;
import cars.CarController;
import cars.CarException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AaronFM
 */
public class ex1_StoreCarsInFile {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        File file = Car.getDataFile();
        List<Car> carList = List.of(
                new Car("1000ABC", "Escarabajo"),
                new Car("1212ABD", "A3"),
                new Car("1238BDC", "A2"),
                new Car("1237ESD", "206"),
                new Car("1264FED", "306"),
                new Car("3534REF", "Furgoneta")
        );
        try {
            CarController.writeCarsInFile(file, carList);
        } catch (CarException ex) {
            System.err.println(ex.getParent() + ex.getMessage());
        }
    }
    
}
