package RandomAccessFileIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Optional;

/**
 * Programa que permita realizar a consulta dun empregado determinado cuxo
 * identificador será pasado como parámetro e visualizará os seus datos e se non
 * existe visualizará unha mensaxe de indicándoo.
 */
public class EJ4_SearchEmployee {
    public static void main(String[] args) {
        File file = EmployeeData.getData();
        try {
            searchEmployeeByID(1, file).ifPresentOrElse(
                    System.out::println, 
                    () -> System.out.println("No existe el empleado."));

        } catch (EmployeeData.EmployeeDataException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Optional<EmployeeData> searchEmployeeByID(int id, File fileData) throws EmployeeData.EmployeeDataException {
        if (id < 1) {
            throw new EmployeeData.EmployeeDataException("El id no puede ser negativo.");
        }
        EmployeeData employee = null;
        try ( RandomAccessFile raf = new RandomAccessFile(fileData, "r")) {
            int seeking = (id - 1) * EmployeeData.DATA_SIZE;
            if (seeking > raf.length()) {
                throw new EmployeeData.EmployeeDataException("No se encontró el ID número " + id + ".\nTamaños: (buscar)" + seeking + " (total)" + raf.length());
            }
            int idFound;
            raf.seek(seeking);
            idFound = raf.readInt();
            System.out.println("ID: " + idFound);
            if (idFound > -2) { //-2 para testear
                char[] surname = new char[EmployeeData.SURNAME_SIZE];
                int dept;
                double salary;
                for (int i = 0; i < surname.length; i++) {
                    surname[i] = raf.readChar();
                }
                dept = raf.readInt();
                salary = raf.readDouble();
                employee = new EmployeeData(surname, dept, salary);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(employee);
    }
}
