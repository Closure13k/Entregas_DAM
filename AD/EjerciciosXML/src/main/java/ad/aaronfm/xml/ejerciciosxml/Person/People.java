/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AaronFM
 */
public class People {

    /**
     * Future-proof maintenance. Nombre del alias para XStream.
     */
    public static final String ALIAS = "People";
    /**
     * Borrado de propiedad redundante en XStream.
     */
    public static final String IMPLICIT_COLLECTION = "personList";
    /**
     * Ease of use. Rutas predefinidas.
     */
    private static final String DAT_PATH = ".\\data\\People.dat";
    private static final String XML_PATH = ".\\data\\People.xml";
    private static final String XSL_PATH = ".\\data\\PeopleStyle.xsl";

    private List<Person> personList = new ArrayList<>();

    public People(List<Person> list) {
        this.personList = list;
    }

    public People() {
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void add(Person person) {
        this.getPersonList().add(person);
    }

    public static File getDatFile() {
        return new File(DAT_PATH);
    }

    public static File getXmlFile() {
        return new File(XML_PATH);
    }
    public static File getXslFile(){
        return new File(XSL_PATH);
    }
}
