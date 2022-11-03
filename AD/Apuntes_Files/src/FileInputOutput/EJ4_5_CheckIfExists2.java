/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Realiza un programa ao que lle pases a ruta dun ficheiro a través do paso de
 * parámetros e indique se o ficheiro existe ou non existe. Se faltan argumentos
 * da main deberase amosar unha mensaxe indicándoo. Posteriormente amosará o
 * número de palabras do ficheiro.
 */
public class EJ4_5_CheckIfExists2 {

    public static void main(String[] args) {
        if (!(args.length > 0)) {
            System.out.println("No hay argumentos para cargar el archivo.");
        } else {
            String fileName = args[0];
            Path filePath = Path.of(fileName);
            System.out.println(filePath + (Files.exists(filePath) ? "" : " NO") + " EXISTE");

            try {
                long count = Files.lines(filePath)
                        .map((string) -> string.split("\\s+"))
                        .flatMap(Arrays::stream)
                        .count();
                System.out.println(count);
            } catch (IOException ex) {
                Logger.getLogger(Ej4_4_CheckIfExists.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
