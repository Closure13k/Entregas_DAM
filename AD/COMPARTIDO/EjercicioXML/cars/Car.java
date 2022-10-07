/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author AaronFM
 */
public record Car(String registration, String model) implements Serializable {

    private static final String FILE_PATH = ".\\src\\data\\Cars.dat";
    private static final String XML_PATH = ".\\src\\data\\Cars.xml";
    
    protected static final String XML_VERSION = "1.0";
    protected static final String XML_ROOT = "cars";
    protected static final String REGISTRATION = "registration";
    protected static final String MODEL = "model";
    
    
    

    public static File getDataFile() {
        return new File(FILE_PATH);
    }

    public static File getXMLFile() {
        return new File(XML_PATH);
    }
}
