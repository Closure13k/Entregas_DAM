package TestingFiles;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * I changed this
 *
 * @author AaronFM
 */
public class TestingFiles {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Listing a directory. This short program will show all the directories
         * based on the file call and identify whether they are files or not.
         */
        /**
         * Using args. Properties -> Run -> Path to check. First we'll ask
         * whether main has arguments or not.
         */
        String path = args.length >= 0 ? args[0] : ".";
        File file = new File(path);
        System.out.println("Current path: " + file.getAbsolutePath());
        Arrays.stream(file.listFiles()).forEachOrdered((eachFile) -> {
            System.out.println(
                    (eachFile.isDirectory() ? "<DIR>\t(" + eachFile.list().length + ")\t" + eachFile.getName() : "\t" + eachFile.length() + "\t" + eachFile.getName())
            );
        });
        /**
         * Creating directories and files.
         */
        File newDirectory = new File("nuevo_directorio");
        boolean isMade = newDirectory.mkdir();
        System.out.println(isMade ? "Made directory" : "Already exists!");
        File newFileToNewDirectory = new File(newDirectory, "nuevo_fichero");
        try {
            isMade = newFileToNewDirectory.createNewFile();
        } catch (IOException ex) {
            System.err.println("IOException: Couldn't create new file!");
        }
        System.out.println(isMade ? "Created file!" : "Already exists!");
        
    }
}
