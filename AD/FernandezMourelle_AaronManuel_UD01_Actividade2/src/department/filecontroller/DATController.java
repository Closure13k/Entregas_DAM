package department.filecontroller;

import department.Department;
import department.controller.DepartmentException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DATController {

    public static void writeDepartmentListToDat(List<Department> departments, File datFile) throws DepartmentException {
        try ( ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(datFile))) {
            for (Department department : departments) {
                objOut.writeObject(department);
            }
        } catch (IOException ex) {
            throw new DepartmentException(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }
    //<editor-fold defaultstate="collapsed" desc="Sin uso, no planteé bien el enunciado.">

    public static List<Department> readDepartmentListFromDat(File datFile) throws DepartmentException {
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(datFile))) {
            List<Department> deptList = new ArrayList<>();
            for (;;) {
                try {
                    Object readObject = objIn.readObject();
                    if (readObject instanceof Department department) {
                        deptList.add(department);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
            return deptList;
        } catch (IOException ex) {
            throw new DepartmentException(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        } catch (ClassNotFoundException cnfe) {
            throw new DepartmentException(cnfe.getClass().getSimpleName() + ": Durante la lectura de objetos.");
        }
    }
//</editor-fold>

}
