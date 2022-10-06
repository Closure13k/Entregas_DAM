package view;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import model.Department;
import model.exceptions.DepartmentException;

/**
 *
 */
public class ex2 {

    /**
     * Realiza programa que permita modificar os datos dun departamento. O
     * programa recibe dende a liña de comandos o número de departamento a
     * modificar, o novo nome do departamento e a nova localidade. Se o
     * departamento non existe visualiza unha mensaxe indicándoo. Visualiza
     * tamén os datos antigos do departamento e os novos datos.
     *
     * @param args parámetros a recibir por comandos.
     */
    public static void main(String[] args) {
        File dataFile = Department.getDataFile();
        if (args.length != 3) {
            System.err.println("Los argumentos han de ser 3: [NUMERO] [NOMBRE] [LOCALIZACION]");
        }
        try {
            modifyDataFromDAT(dataFile, args);
        } catch (DepartmentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Proceso dentro del método.
     *
     * @param dataFile archivo del que modificar los datos.
     * @param args parámetros a modificar: 
     * <pre>[ID a buscar] [nombre nuevo] [localización nueva]</pre>
     * @throws DepartmentException
     */
    protected static void modifyDataFromDAT(File dataFile, String[] args) throws DepartmentException {
        int dept;
        try {
            dept = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfex) {
            throw new DepartmentException("Error al pasar argumentos: Se esperaba un número entero.\n" + nfex.getMessage());
        }
        if (dept <= 0) {
            throw new DepartmentException("Error al pasar argumentos: Se esperaba un número por encima de 0.\n");
        }
        String name = args[1];
        String location = args[2];
        StringBuilder stringBuilder;

        int seek = (dept - 1) * Department.TOTAL_BYTES;

        try ( RandomAccessFile raf = new RandomAccessFile(dataFile, "rw")) {
            if (seek >= raf.length()) {
                throw new DepartmentException("El número buscado no existe en el archivo.");
            }
            /**
             * Comienzo a construir la información.
             */
            stringBuilder = new StringBuilder();
            stringBuilder.append("Dept: ").append(raf.readInt());

            stringBuilder.append("\nNombre: ");
            for (int i = 0; i < Department.NAME_CAPACITY; i++) {
                stringBuilder.append(raf.readChar());
            }
            stringBuilder.append("\nLocalizacion: ");
            for (int i = 0; i < Department.LOCATION_CAPACITY; i++) {
                stringBuilder.append(raf.readChar());
            }
            /**
             * Hago retroceder al puntero para comenzar el reemplazo. Antes de
             * la escritura modifico las cadenas (en caso de que sean muy cortas
             * o muy largas).
             */
            raf.seek(raf.getFilePointer() - (Department.NAME_BYTES + Department.LOCATION_BYTES));
            raf.writeChars(Department.normalizeString(name, "name"));
            raf.writeChars(Department.normalizeString(location, "location"));
            /**
             * Finalmente construyo el resultado del cambio.
             */
            stringBuilder.append("\nNombre: ").append(name).append("\nLocalizacion: ").append(location);
            System.out.println("Cambio:\n" + stringBuilder.toString());

        } catch (IOException ex) {
            throw new DepartmentException(ex.getMessage());
        }
    }
}
