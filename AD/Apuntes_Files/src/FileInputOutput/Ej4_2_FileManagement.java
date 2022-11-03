package FileInputOutput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Realiza un programa que copie dous ficheiros. O nome dos ficheiros, orixe e
 * destino, introdúcense dende a liña de comandos ao executar o programa.
 */
public class Ej4_2_FileManagement {

    public static void main(String[] args) {
        String sourceName, resultingFile;
        sourceName = requestData("Dame el nombre del archivo o carpeta.");
        File sourceFile = new File("C:/Users/AaronFM/Desktop/ACCESO_A_DATOS/", sourceName);
        resultingFile = requestData("Dame el nombre del nuevo archivo generado a partir de " + sourceFile.getName());

        try {
            copyFile(sourceFile, resultingFile);
        } catch (ExcepcionFicheros | IOException ex) {
            errorMessage(ex.getMessage());
        }
        
        //Otra forma de hacerlo.
        try {
            File fileGenerated = new File(sourceFile.getParentFile(), resultingFile);
            Files.copy(sourceFile.toPath(), fileGenerated.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            errorMessage(ex.getMessage());
        }

    }

    private static String requestData(String message) {
        return JOptionPane.showInputDialog(message);
    }

    private static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private static void informationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Forma VIEJA.
     *
     * @param source
     * @param result
     * @throws FileInputOutput.Ej4_2_FileManagement.ExcepcionFicheros
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void copyFile(File source, String result) throws ExcepcionFicheros, FileNotFoundException, IOException {
        if (source.isDirectory()) {
            throw new ExcepcionFicheros(ExcepcionFicheros.IS_DIRECTORY);
        }
        File resultingFile = new File(source.getParentFile(), result);

        try ( FileInputStream input = new FileInputStream(source);  FileOutputStream output = new FileOutputStream(resultingFile)) {
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
        }
    }

    protected static class ExcepcionFicheros extends Exception {

        protected static final String IS_DIRECTORY = "Lo que se intenta copiar es un directorio. Este ejercicio no lo permitirá.";

        public ExcepcionFicheros(String message) {
            super(message);
        }
    }
}
