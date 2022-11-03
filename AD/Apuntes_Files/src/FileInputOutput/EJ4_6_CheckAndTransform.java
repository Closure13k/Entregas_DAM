/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Realiza un programa ao que lle pases a ruta dun ficheiro a través do paso de
 * parámetros e indique se o ficheiro existe ou non existe. Se faltan argumentos
 * da main deberase amosar unha mensaxe indicándoo. Posteriormente se pasamos un
 * ficheiro cuxo contido son caracteres en maiúscula os debe transformar en
 * caracteres en minúscula e viceversa.
 */
public class EJ4_6_CheckAndTransform {

    public static void main(String[] args) {
        if (!(args.length > 0)) {
            System.out.println("No hay argumentos para cargar el archivo.");
        } else {
            String fileName = args[0];
            Path filePath = Path.of(fileName);
            System.out.println(filePath + (Files.exists(filePath) ? "" : " NO") + " EXISTE");

            try {
                List<String> readAllLines = Files.readAllLines(filePath);

                Stream<IntStream> map = readAllLines.stream().map((line) -> line.chars()
                        .map((value) -> Character.isUpperCase(value) ? Character.toLowerCase(value) : Character.toUpperCase(value))
                );
            } catch (IOException ex) {
                Logger.getLogger(EJ4_6_CheckAndTransform.class.getName()).log(Level.SEVERE, null, ex);
            }

            fileName.chars()
                    .map((value) -> Character.isUpperCase(value) ? Character.toLowerCase(value) : Character.toUpperCase(value))
                    .forEach((value) -> System.out.print((char) value));

        }
    }
}
