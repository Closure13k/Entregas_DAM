package FileInputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Crea un ficheiro de texto con algún editor de textos e despois realiza un
 * programa en java que visualizará o contido lendo carácter a carácter. O nome
 * do ficheiro aceptarase como argumento.
 */
/**
 * Crea un ficheiro de texto con algún editor de textos e despois realiza un
 * programa en java que visualizará o contido lendo os caracteres de 20 en 20. O
 * nome do ficheiro aceptarase como argumento.
 */
/**
 * Crea un ficheiro de texto con algún editor de textos e despois realiza un
 * programa en java que visualizará o contido lendo de liña en liña. O nome do
 * ficheiro aceptarase como argumento.
 */
public class Ej4_ReadingFromFile {

    public static void main(String[] args) {
        try {
            String pathName = args.length > 0 ? args[0] : "C:/Users/AaronFM/Desktop/ACCESO_A_DATOS/";
            File fileToRead = new File(pathName, "Quijote.txt");

//            readFileByEachCharacter(fileToRead);
            readFileByAmountOfCharacters(fileToRead);
//            readFileByLine(fileToRead);
        } catch (IOException ex) {
            Logger.getLogger(Ej4_ReadingFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void readFileByEachCharacter(File fileToRead) throws FileNotFoundException, IOException {
        try ( FileReader reader = new FileReader(fileToRead)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
                character = reader.read();
            }
        }
    }

    private static void readFileByAmountOfCharacters(File fileToRead) throws FileNotFoundException, IOException {
        try ( FileReader reader = new FileReader(fileToRead)) {
            char[] buffer = new char[20];
            int character;
            while ((character = reader.read(buffer)) != -1) {
                for (char c : buffer) {
                    System.out.print(c);
                }
            }
        }
    }

    /**
     *
     * @param fileToRead
     * @throws IOException
     */
    private static void readFileByLine(File fileToRead) throws IOException {
        /**
         * Otro modo: También se puede usar la propia clase Files. Tiene métodos
         * de gestión y lectura que hacen un trabajo similar.
         *
         * Stream<String> lines = Files.lines(Paths.get(fileToRead.toURI()));
         * String textGathered = lines.collect(Collectors.joining(System.lineSeparator()));
         * System.out.println(textGathered);
         */
        try ( BufferedReader readBuffer = new BufferedReader(new FileReader(fileToRead))) {
        /**
         * Nuevo. Este es de los más actuales y es mucho más legible y
         * práctico.
         */
            System.out.println(readBuffer.lines()
                    .collect(Collectors.joining(System.lineSeparator())));
        /**
         * Viejo. Este ejemplo era malo y es mejor con un StringBuilder.
         * StringBuilder lineBuilder = new StringBuilder(); 
         * String line;
         * while ((line = readBuffer.readLine()) != null) {
         *      lineBuilder.append(line).append("\n");
         * }
         * System.out.println(lineBuilder.toString());
         *
         * while ((line = readBuffer.readLine()) != null) {
         *      System.out.println(line); 
         * }
         */
        }
    }
}