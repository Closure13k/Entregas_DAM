package view;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.exceptions.DepartmentException;

/**
 *
 */
public class ex3 {

    /**
     * Realiza un programa que permita eliminar un departamento. O programa
     * recibe dende a liña de comandos o número de departamento a eliminar. Se o
     * departamento non existe visualiza unha mensaxe indicándoo. Visualiza
     * tamén o número total de departamentos que existen no ficheiro.
     *
     * @param args los parámetros a recibir por línea de comandos.
     */
    public static void main(String[] args) {
        File dataFile = Department.getDataFile();
        if (args.length != 1) {
            System.err.println("Sólo un argumento: [NUM DEPARTAMENTO]");
        }
        try {
            deleteDataFromDAT(dataFile, args[0]);
        } catch (DepartmentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     *
     * Seguridad previa a control: Formato de datos correcto y argumentos
     * legales. Posicionamiento del puntero en la posición a buscar.
     * Comprobación de dicha posición. Comprobación de registro existente (-1 si
     * borrado). Borrado si existente. Conteo de registros y fin de método.
     *
     * @param dataFile El archivo del que leer.
     * @param numDept El número de departamento (posición en el raf) a borrar.
     * @throws DepartmentException Si el ID no es número (NumberFormatEx), es
     * menor a 0 (IllegalArgumentEx), supera el tamaño del archivo, o lleva a
     * una posición con ID = -1 (Registro ya borrado).
     */
    protected static void deleteDataFromDAT(File dataFile, String numDept) throws DepartmentException {
        int dept, count;
        try {
            dept = Integer.parseInt(numDept);
        } catch (NumberFormatException nfex) {
            throw new DepartmentException("El ID ha de ser un número: " + nfex.getMessage());
        }
        if (dept <= 0) {
            throw new DepartmentException("Error al pasar argumentos: Se esperaba un número por encima de 0.\n");
        }
        int seek = (dept - 1) * Department.TOTAL_BYTES;
        try ( RandomAccessFile raf = new RandomAccessFile(dataFile, "rw")) {
            if (seek >= raf.length()) {
                throw new DepartmentException("El número buscado no existe en el archivo.");
            }
            raf.seek(seek);
            int current = raf.readInt();
            if (current < 0) {
                throw new DepartmentException("Departamento no encontrado: Num_dept " + dept);
            }
            raf.seek(raf.getFilePointer() - Department.DEPTNUM_BYTES);
            raf.writeInt(-1);
            /**
             * Recojo y cuento departamentos.
             */
            count = 0;
            raf.seek(0);
            for (;;) {
                try {
                    if (raf.readInt() > -1) {
                        count++;
                    }
                    raf.seek(raf.getFilePointer() + Department.TOTAL_BYTES - Department.DEPTNUM_BYTES);
                } catch (EOFException eof) {
                    break;
                }
            }
            System.out.println("Registro borrado. Restan: " + count);

        } catch (IOException ex) {
            throw new DepartmentException(ex.getMessage());
        }

    }
}
