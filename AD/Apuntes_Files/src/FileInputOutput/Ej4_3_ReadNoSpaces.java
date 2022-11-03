/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import FileInputOutput.Ej4_2_FileManagement.ExcepcionFicheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crea un ficheiro de texto co nome e contido que ti desexes. Realiza un
 * programa que lea un ficheiro de texto cuxo nome será pasado como argumento e
 * amose o seu contido por pantalla sen espazos.
 */
public class Ej4_3_ReadNoSpaces {

    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "C:/Users/AaronFM/Desktop/ACCESO_A_DATOS/Quijote.txt";
        System.out.println(filePath);
        try {
            //        try {
//            String readString = Files.readString(Path.of(filePath));
//            String newString = readString.replace(" ", "");
//            System.out.println(newString);
//        } catch (IOException ex) {
//            Logger.getLogger(Ej4_3_ReadNoSpaces.class.getName()).log(Level.SEVERE, null, ex);
//        }
            readWithoutSpaces(filePath);
        } catch (IOException | ExcepcionFicheros ex) {
            Logger.getLogger(Ej4_3_ReadNoSpaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void readWithoutSpaces(String filePath) throws FileNotFoundException, IOException, Ej4_2_FileManagement.ExcepcionFicheros {
        File fileToRead = new File(filePath);
        if (!fileToRead.isFile()) {
            throw new ExcepcionFicheros("No es un archivo.");
        }
        try ( BufferedReader buffer = new BufferedReader(new FileReader(fileToRead))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                line = line.replaceAll("\\s+", "");
                System.out.println(line);
            }
        }
    }
}
