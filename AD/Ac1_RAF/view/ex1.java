package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import model.Department;
import model.exceptions.DepartmentException;

/**
 *
 */
public class ex1 {

    /**
     * Realiza un programa que cree un ficheiro binario para gardar os datos de
     * departamentos, dalle o nome Departamento.dat.Introduce varios
     * departamentos. Datos departamento: Integer/int Número. String Nombre.
     * String Localidad.
     *
     * @param args Sin uso.
     */
    public static void main(String[] args) {
        File dataFile = Department.getDataFile();
        List<Department> loadDepts = List.of(
                new Department(1, "RRHH", "A Coruña"),
                new Department(2, "Comercio", "Santiago"),
                new Department(3, "Producción", "Ferrol"),
                new Department(4, "I+D", "Lugo")
        );
        try {
            writeDataToDAT(dataFile, loadDepts);
        } catch (DepartmentException ex) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Escritura en DAT.
     * @param file
     * @param data
     * @throws DepartmentException
     */
    protected static void writeDataToDAT(File file, List<Department> data) throws DepartmentException {
        try ( RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            for (Department department : data) {
                raf.writeInt(department.num());
                raf.writeChars(department.convertToSize("name"));
                raf.writeChars(department.convertToSize("location"));
            }
        } catch (FileNotFoundException ex) {
            throw new DepartmentException(ex.getMessage());
        } catch (IOException | DepartmentException ex) {
            throw new DepartmentException(ex.getMessage());
        }
    }
}
