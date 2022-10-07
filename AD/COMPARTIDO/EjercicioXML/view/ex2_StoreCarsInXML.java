/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import cars.Car;
import cars.CarController;
import cars.CarException;

/**
 *
 * @author AaronFM
 */
public class ex2_StoreCarsInXML {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            CarController.writeCarsInXML(Car.getDataFile(), Car.getXMLFile());
        } catch (CarException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
