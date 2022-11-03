package FileModification;

import FileModification.CarFiles.CarDataException;
import java.io.File;
import java.io.IOException;
import static FileModification.ProgramController.*;

/**
 * Operaciones de adición, borrado y modificado de registros de coches. Probar
 * varias formas de eliminar datos de un fichero.
 */
public class Ej5_ModifyFile {

    public static void main(String[] args) {
        File fileToWrite = new File(".\\src\\FileModification\\data\\CarData.dat");
        int option = -1;

        try {
            FileController.verifyFile(fileToWrite);
        } catch (IOException ex) {
            System.err.println(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }

        do {
            try {
                option = Integer.parseInt(requestData(menu()));
            } catch (NumberFormatException nfex) {
                System.err.println(nfex.getClass().getSimpleName() + ": Sólo números, por favor.");
            }

            try {
                actionManager(option, fileToWrite);
            } catch (CarDataException ex) {
                System.err.println(ex.getMessage());
            }
        } while (option != 0);
    }
}
