/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml.Car;

import com.thoughtworks.xstream.XStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author AaronFM
 */
public class CarFileControllers {

    public static void loadCarsInDATFile(File datFile) throws FileNotFoundException, IOException {
        Cars cars = new Cars(List.of(
                new Car("1234ASD", "Ferrari", "Nuse"),
                new Car("GAB4680", "Renault", "Megane"),
                new Car("4323LKV", "Peugeot", "306"),
                new Car("9898MMC", "Seat", "Mii")
        ));
        try ( ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(datFile))) {
            for (Car car : cars.getList()) {
                objOut.writeObject(car);
            }
        }
    }

    public static Cars readCarsFromDATFile(File datFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(datFile))) {
            Cars cars = new Cars();
            for (;;) {
                try {
                    cars.add((Car) objIn.readObject());
                } catch (EOFException eof) {
                    break;
                }
            }
            System.out.println(cars.getList().toString());
            return cars;
        }
    }

    public static void writeCarsToXML(Cars cars, File xmlFile) throws FileNotFoundException {
        XStream xStream = new XStream();
        xStream.alias(Cars.class.getSimpleName(), Cars.class);
        xStream.alias(Car.ALIAS, Car.class);
        xStream.addImplicitCollection(Cars.class, Cars.IMPLICIT_COLLECTION);
        xStream.toXML(cars, new FileOutputStream(xmlFile));
    }

}
