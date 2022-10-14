package ad.aaronfm.xml.ejerciciosxml.Car;

import java.io.Serializable;

/**
 * Representation of a car entity.
 * Recuerda implementar Serializable para poder guardarlo en archivos.
 * @author AaronFM
 */
public class Car implements Serializable {

    /**
     * Alias for XStream
     */
    public static final String ALIAS = "Coche";

    private String license;
    private String brand;
    private String model;

    public Car(String license, String brand, String model) {
        this.license = license;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "license=" + license + ", brand=" + brand + ", model=" + model + '}';
    }
}
