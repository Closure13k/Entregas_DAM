/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Realiza un programa Java que ao executalo reciba como argumento un nome de
 * directorio. O programa deberá eliminar o directorio e os ficheiros contidos
 * nel emitindo unha mensaxe de cada elemento eliminado co seguinte formato
 * "nome eliminado correctamente".
 *
 * @author AaronFM
 */
public class Ej3_DeleteDirectoryByString {

    public static void main(String[] args) {
        try {
            File fileToDelete = requestPathName();
            deleteRecursively(fileToDelete);

        } catch (FileNotFoundException ex) {
            errorMessage(ex.getMessage());
        }
    }

    private static String requestData(String message) {
        return JOptionPane.showInputDialog(message);
    }

    private static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private static File requestPathName() throws FileNotFoundException {
        String pathname = requestData("Give me a path:");
        File fileFromPathName = new File(pathname);
        System.out.println(fileFromPathName.getAbsolutePath());
        if (fileFromPathName.isFile()) {
            throw new FileNotFoundException("Pathname leads to a file. Must be a directory.");
        }
        if (!fileFromPathName.exists()) {
            throw new FileNotFoundException("No such file in this pathname.");
        }
        return fileFromPathName;
    }

    private static boolean deleteRecursively(File fileToDelete) {
        File[] allContents = fileToDelete.listFiles();
        if (allContents != null) {
            Arrays.stream(allContents).forEach((file) -> deleteRecursively(file));
        }

        System.out.println(fileToDelete.getParent() + " -> " + fileToDelete.getName());
        return fileToDelete.delete();
    }
}
