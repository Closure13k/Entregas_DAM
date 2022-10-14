package ad.aaronfm.xml.ejerciciosxml.Car;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    /**
     * Route for DAT file.
     */
    private static final String DAT_PATH = ".\\data\\Cars.dat";
    /**
     * Route for XML file.
     */
    private static final String XML_PATH = ".\\data\\Cars.xml";
    /**
     * Alias para la clase coches.
     */
    public static final String ALIAS = "Coches";
    /**
     * Implicit Collection.
     */
    public static final String IMPLICIT_COLLECTION = "list";

    private List<Car> list = new ArrayList<>();

    public Cars(List<Car> list) {
        this.list = list;
    }

    public Cars() {
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }

    public static File getDATFile() {
        return new File(DAT_PATH);
    }

    public static File getXMLFile() {
        return new File(XML_PATH);
    }

    void add(Car car) {
        this.list.add(car);
    }

}
