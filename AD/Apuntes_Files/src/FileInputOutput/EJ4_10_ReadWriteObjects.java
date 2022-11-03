package FileInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EJ4_10_ReadWriteObjects {

    private static record Person(String name, int age) implements Serializable {

        @Override
        public String toString() {
            return "Persona: " + name + " " + age;
        }
    }

    public static void main(String[] args) {
        
    }

    private static List<Person> readPeopleFromFile(File file) {
        List<Person> peopleList = new ArrayList<>();
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
            Object objectToRead;
            while (objIn.available() > 0) {
                objectToRead = objIn.readObject();
                if (objectToRead instanceof Person person) {
                    peopleList.add(person);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EJ4_10_ReadWriteObjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peopleList;
    }

    private static void writePeopleToFile(File file, List<Person> peopleList) {
        try ( ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Person person : peopleList) {
                objOut.writeObject(person);
            }
        } catch (IOException ex) {
            Logger.getLogger(EJ4_10_ReadWriteObjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
