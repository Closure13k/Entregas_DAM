package FileInputOutput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Leer números enteros por teclao y escribirlos en un fichero binario. Luego
 * leer el binario y sacarlo por pantalla.
 */
public class EJ4_7_ReadInputAndWriteInFile {

    public static void main(String[] args) {
        int inputNumber;
        int[] numbersToWrite = new int[10];
        int i = 0;
        File filePath = new File("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\Numeros.bin");
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

    private static int requestInputNumber() throws NumberException {
        String input = JOptionPane.showInputDialog("Gimme a number!");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfex) {
            throw new NumberException("Por favor sólo números enteros! Lo tuyo: " + input);
        }
    }

    private static void writeNumbersToBinaryFile(int[] numbersToWrite, File filePath) throws FileNotFoundException, NoSuchFileException, NumberException {
        if (!filePath.isFile()) {
            throw new FileNotFoundException("File target is a directory!");
        }
        try ( FileOutputStream fileOutput = new FileOutputStream(filePath)) {
            for (int i : numbersToWrite) {
                fileOutput.write(i);
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
        try(BufferedInputStream buffInput = new BufferedInputStream(new FileInputStream(filePath))){
            byte[] readAllBytes = buffInput.readAllBytes();
            for (byte readByte : readAllBytes) {
                System.out.println(readByte);
            }
        } catch (IOException ex) {
            throw new NumberException("Hubo un error en tiempo de lectura.");
        }
    }


    protected static class NumberException extends Exception {

        public NumberException(String message) {
            super(message);
        }

    }
}
