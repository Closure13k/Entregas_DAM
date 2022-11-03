package FileInputOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ej4_9_ReadPeopleAndWriteInFile {

    private static record Person(String name, int age) implements Serializable {

        @Override
        public String toString() {
            return "Persona: " + name + " " + age;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Manolo", "Pepo", "Jaime", "Daniel", "Gustavo", "Francisco", "Martin", "Aaron", "Bruno"};
        int[] ages = {1, 10, 20, 30, 40, 50, 55, 60, 74};
        File fileToWrite = new File("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\FicheroDatos.dat");
        List<Person> peopleList;

        try {
            writeDataToFile(fileToWrite, names, ages);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        peopleList = readFromFileData(fileToWrite);
        peopleList.forEach(System.out::println);

    }

    private static void writeDataToFile(File fileToWrite, String[] names, int[] ages) throws Exception {
        try ( DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(fileToWrite))) {
            if (names.length != ages.length) {
                throw new Exception("Los arrays no tienen el mismo tamaño.");
            }
            for (int i = 0; i < names.length; i++) {
                dataOut.writeUTF(names[i]);
                dataOut.writeInt(ages[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ej4_9_ReadPeopleAndWriteInFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej4_9_ReadPeopleAndWriteInFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<Person> readFromFileData(File fileToWrite) {
        List<Person> peopleList = new ArrayList<>();
        try ( DataInputStream dataIn = new DataInputStream(new FileInputStream(fileToWrite))) {
            try {
                while (true) {
                    peopleList.add(new Person(dataIn.readUTF(), dataIn.readInt()));
                }
            } catch (EOFException eof) {
                System.out.println("Fin de lectura.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ej4_9_ReadPeopleAndWriteInFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej4_9_ReadPeopleAndWriteInFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peopleList;
    }
}