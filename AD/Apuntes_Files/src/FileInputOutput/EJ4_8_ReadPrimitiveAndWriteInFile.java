/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import FileInputOutput.EJ4_7_ReadInputAndWriteInFile.NumberException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author AaronFM
 */
public class EJ4_8_ReadPrimitiveAndWriteInFile {

    public static void main(String[] args) {
        float inputNumber;
        float[] numbersToWrite = new float[10];
        int i = 0;
        File filePath = new File("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\Primitivos.dat");
        while (i < numbersToWrite.length) {
            try {
                inputNumber = requestInputNumber();
                numbersToWrite[i] = inputNumber;
                i++;
            } catch (NumberException ex) {
                System.err.println(ex.getMessage());
            }
        }
        try {
            writeNumbersToBinaryFile(numbersToWrite, filePath);
            readNumbersFromBinaryFile(filePath);
        } catch (FileNotFoundException | NoSuchFileException | NumberException ex) {
            System.err.println(ex.getMessage());
        }

    }

    private static float requestInputNumber() throws NumberException {
        String input = JOptionPane.showInputDialog("Gimme a number!");
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException nfex) {
            throw new NumberException("Por favor sólo números enteros! Lo tuyo: " + input);
        }
    }

    private static void writeNumbersToBinaryFile(float[] numbersToWrite, File filePath) throws FileNotFoundException, NoSuchFileException, NumberException {
        try ( DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(filePath))) {
            for (float i : numbersToWrite) {
                dataOutput.writeFloat(i);
            }
        } catch (IOException ex) {
            throw new NumberException("Hubo un error en tiempo de escritura.");
        }
    }

    private static void readNumbersFromBinaryFile(File filePath) throws NoSuchFileException, FileNotFoundException, NumberException {
        if (!filePath.exists()) {
            throw new NoSuchFileException("File doesn't exist!");
        }
        if (!filePath.isFile()) {
            throw new FileNotFoundException("File target is a directory!");
        }
        List<Float> floatList = new ArrayList<>();
        try ( DataInputStream dataInput = new DataInputStream(new FileInputStream(filePath))) {
            try {
                for(;;) {
                    floatList.add(dataInput.readFloat());
                }
            } catch (EOFException eof) {
                System.out.println("End of file.");
            }
        } catch (IOException ex) {
            throw new NumberException("Hubo un error en tiempo de lectura.");
        }        
        floatList.stream().sorted().forEach(System.out::println);
    }

}
