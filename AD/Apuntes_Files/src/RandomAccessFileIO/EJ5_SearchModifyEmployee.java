package RandomAccessFileIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Programa que reciba como parámetros un identificador dun empregado e un
 * importe. Se debe realizar a modificación do seu salario que consistirá en
 * sumar ao salario do empregado o importe introducido. O programa debe
 * visualizar o apelido, o salario antigo e o novo. Se o identificador non
 * existe visualizarase unha mensaxe indicándoo.
 */
public class EJ5_SearchModifyEmployee {

    public static void main(String[] args) {
        File file = EmployeeData.getData();
        try {
            searchEmployeeAndModifySalary(1, 500.0, file);
        } catch (EmployeeData.EmployeeDataException ex) {
            if (ex.getMessage().equalsIgnoreCase("EOF")) {
                System.err.println("Empleado no encontrado.");
            } else {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void searchEmployeeAndModifySalary(int id, double salaryToModify, File fileData) throws EmployeeData.EmployeeDataException {
        if (id < 1) {
            throw new EmployeeData.EmployeeDataException("El id no puede ser negativo.");
        }
        try ( RandomAccessFile raf = new RandomAccessFile(fileData, "rw")) {
            double oldSalary, newSalary;
            int seekingSurname = EmployeeData.getSizeToReach(id, "surname");
            int seekingSalary = EmployeeData.getSizeToReach(id, "salary");

            //Putero sobre apellido.
            raf.seek(seekingSurname);
            char[] surname = new char[EmployeeData.SURNAME_SIZE];
            for (int i = 0; i < surname.length; i++) {
                surname[i] = raf.readChar();
            }

            //Puntero sobre salario
            raf.seek(seekingSalary);
            oldSalary = raf.readDouble();
            newSalary = oldSalary + salaryToModify;
            raf.seek(seekingSalary);
            raf.writeDouble(newSalary);

            System.out.printf("Empleado: %s\nSalario viejo: %.2f\nSalario nuevo: %.2f\nModificado: %.2f", new String(surname).trim(), oldSalary, newSalary, salaryToModify);

        } catch (IOException ex) {
            if (ex.getMessage() == null) {
                throw new EmployeeData.EmployeeDataException("EOF");
            } else {
                throw new EmployeeData.EmployeeDataException(ex.getMessage());
            }
        } catch (Exception ex){
            throw new EmployeeData.EmployeeDataException(ex.getMessage());
        }

    }
}
