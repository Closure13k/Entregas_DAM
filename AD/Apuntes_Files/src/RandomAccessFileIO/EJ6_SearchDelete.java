package RandomAccessFileIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Programa Java que ao executalo dende a liña de comandos reciba un
 * identificador dun empregado e o borre. Farase un borrado lóxico marcando o
 * rexistro coa seguinte información: o identificador será igual a -1, o apelido
 * será igual ao identificador eliminado, e o departamento e salario serán igual
 * a 0.
 */
public class EJ6_SearchDelete {

    public static void main(String[] args) {
        File file = EmployeeData.getData();
        try {
            searchEmployeeAndDelete(1, file);
        } catch (EmployeeData.EmployeeDataException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void searchEmployeeAndDelete(int id, File fileData) throws EmployeeData.EmployeeDataException {
        if (id < 1) {
            throw new EmployeeData.EmployeeDataException("El id no puede ser negativo.");
        }

        try ( RandomAccessFile raf = new RandomAccessFile(fileData, "rw")) {
            raf.seek(EmployeeData.getByID(1));
            int idRead = raf.readInt();
            raf.seek(EmployeeData.getByID(1));
            raf.writeInt(-1); //ID

            StringBuilder stringBuilder = new StringBuilder(String.valueOf(idRead));
            stringBuilder.setLength(10);
            raf.writeChars(stringBuilder.toString());
            
            raf.seek(EmployeeData.getSizeToReach(id, "dept"));
            raf.writeInt(0);
            raf.writeDouble(0);
        } catch (IOException ex) {
            if (ex.getMessage() == null) {
                System.out.println("EOF");
            } else {
                throw new EmployeeData.EmployeeDataException(ex.getMessage());
            }
        }
    }
}
