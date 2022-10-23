/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers;

import ad.aaronfm.xml.ejerciciosxml.Person.People;
import ad.aaronfm.xml.ejerciciosxml.Person.Person;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author AaronFM
 */
public class DATController {

    /**
     * Pre-set list of people written into DAT file. Normalmente se cargaría de
     * otro sitio. Para practicar: Cargar desde un RAF con datos.
     *
     * @param datFile
     * @throws IOException
     */
    public static void loadPeopleInDATFile(File datFile) throws IOException {
        People people = new People(List.of(new Person("Manolo", 32), new Person("Lupe", 23), new Person("Lola", 12), new Person("Alex", 77), new Person("Diego", 44)));
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(datFile))) {
            for (Person person : people.getPersonList()) {
                objOut.writeObject(person);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Reads for person instances in DAT file, returns People class (list of
     * Person). El instanceOf check no sería necesario.
     *
     * @param datFile
     * @return People: clase wrapper para lista de Person.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static People readPeopleFromDATFile(File datFile) throws IOException, ClassNotFoundException {
        People people = new People();
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(datFile))) {
            Object objToRead;
            for (;;) {
                try {
                    objToRead = objIn.readObject();
                    if (objToRead instanceof Person person) {
                        people.add(person);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        }
        return people;
    }

}
