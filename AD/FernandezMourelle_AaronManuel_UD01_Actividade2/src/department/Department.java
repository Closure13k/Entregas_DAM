package department;

import java.io.Serializable;

public class Department implements Serializable {
    //<editor-fold defaultstate="collapsed" desc="Code for DOM (exercicio 1)">

    public static String XML_ROOT = "Departamentos";
    public static final String XML_VERSION = "1.0";

    public static final String ID = "id";
    public static final String NAME = "nombre";
    public static final String LOCATION = "localización";
//</editor-fold>
    private int id;
    private String name;
    private String location;

    public Department() {
    }

    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", location=" + location + '}';
    }

}
