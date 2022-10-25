package department;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase componente raiz. Almacena también las rutas a los archivos.
 *
 * @author AaronFM
 */
public class DepartmentList {
    //<editor-fold defaultstate="collapsed" desc="Private file paths">

    /**
     * Ruta del fichero de datos.
     */
    private static final String DATA_PATH = ".\\src\\data\\Departamento.dat";
    /**
     * Ruta del fichero de datos.
     */
    private static final String XML_PATH = ".\\src\\data\\Departamento.xml";
    /**
     * Ruta del fichero de datos.
     */
    private static final String XSL_PATH = ".\\src\\data\\Departamento.xsl";
    /**
     * Ruta del fichero de datos.
     */
    private static final String HTML_PATH = ".\\src\\data\\Departamento.html";
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Final values">
    public static final String IMPLICIT_COLLECTON = "departmentList";
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Properties, Getter & Setter">
    List<Department> departmentList = new ArrayList<>();

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="File Getters">
    public static File getDatFile() {
        return new File(DATA_PATH);
    }

    public static File getXmlFile() {
        return new File(XML_PATH);
    }

    public static File getXslFile() {
        return new File(XSL_PATH);
    }

    public static File getHtmlFile() {
        return new File(HTML_PATH);
    }
    //</editor-fold>
}
