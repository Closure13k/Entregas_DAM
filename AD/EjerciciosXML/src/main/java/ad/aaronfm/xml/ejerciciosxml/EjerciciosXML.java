/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml;

import ad.aaronfm.xml.ejerciciosxml.Car.CarFileControllers;
import ad.aaronfm.xml.ejerciciosxml.Car.Cars;
import ad.aaronfm.xml.ejerciciosxml.Person.People;
import ad.aaronfm.xml.ejerciciosxml.Person.Person;
import ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers.DATController;
import ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers.HTMLConverter;
import ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers.XMLController;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;

/**
 *
 * @author AaronFM
 */
public class EjerciciosXML {

    public static void main(String[] args) {
        ex1_People();
    }

    private static void ex1_People() {
        File datFile = People.getDatFile();
        File xmlFile = People.getXmlFile();
        File xslFile = People.getXslFile();

        try {
            DATController.loadPeopleInDATFile(datFile);
            People people = DATController.readPeopleFromDATFile(datFile);
            XMLController.writePeopleToXML(people, xmlFile);
            People newPeople = XMLController.readPeopleFromXML(xmlFile);
            HTMLConverter.convertToHTML(xmlFile, xslFile, new File(xmlFile.getParent(), "Personas.html"));
            newPeople.getPersonList().stream()
                    .map(Person::getName).forEach(System.out::println);
            
        } catch (IOException | ClassNotFoundException | TransformerException ex) {
            Logger.getLogger(EjerciciosXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void ex2_Cars() {
        File datFile = Cars.getDATFile();
        File xmlFile = Cars.getXMLFile();
        
        try {
            CarFileControllers.loadCarsInDATFile(datFile);
            Cars cars = CarFileControllers.readCarsFromDATFile(datFile);
            CarFileControllers.writeCarsToXML(cars, xmlFile);
        } catch (ClassNotFoundException | IOException cnfex) {
            System.err.println(cnfex.getMessage());
        }
        
    }

}
