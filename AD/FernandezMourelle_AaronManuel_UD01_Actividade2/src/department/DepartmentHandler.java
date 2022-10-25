/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Gestión de nodos utilizando SAX. Genero el objeto {@link DepartmentList} a
 * partir del XML.
 *
 * @author AaronFM
 */
public class DepartmentHandler extends DefaultHandler {

    //<editor-fold defaultstate="collapsed" desc="Constantes de identificación">
    /**
     * Nombres para identificar los nodos.
     */
    private static final String DEPARTMENTS = "Departamentos";
    private static final String DEPARTMENT = "Department";
    private static final String ID = "id";
    private static final String NAME = "nombre";
    private static final String LOCATION = "localización";
//</editor-fold>

    private DepartmentList departmentList;
    private StringBuilder elementValue;

    /**
     * Paso final: devuelvo la lista.
     *
     * @return
     */
    public DepartmentList getDepartmentList() {
        return departmentList;
    }

    /**
     * Construye cada propiedad leyendo caracteres.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    /**
     * Genera el objeto {@link DepartmentList} para recolectar la información.
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        departmentList = new DepartmentList();
    }

    /**
     * Compara el nombre del nodo y actúa en consecuencia. Si es padre, le
     * asigna una lista a su propiedad. Si es hijo, genera un nuevo objeto. Si
     * es propiedad de hijo, resetea el StringBuilder para construir la
     * información.
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case DEPARTMENTS -> {
                departmentList.setDepartmentList(new ArrayList<>());
            }
            case DEPARTMENT -> {
                departmentList.getDepartmentList().add(new Department());
            }
            case ID -> {
                elementValue = new StringBuilder();
            }
            case NAME -> {
                elementValue = new StringBuilder();
            }
            case LOCATION -> {
                elementValue = new StringBuilder();
            }
        }
    }

    /**
     * Al terminar la lectura del elemento, si es propiedad asigna el valor
     * mediante Setters.
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID -> {
                latestDepartment().setId(Integer.valueOf(elementValue.toString()));
            }
            case NAME -> {
                latestDepartment().setName(elementValue.toString());
            }
            case LOCATION -> {
                latestDepartment().setLocation(elementValue.toString());
            }
        }
    }

    /**
     * Por ser práctico, devuelvo el último elemento que se encuentra
     * ACTUALMENTE en la lista.
     *
     * @return El elemento.
     */
    private Department latestDepartment() {
        List<Department> departmentList1 = departmentList.getDepartmentList();
        int last = departmentList1.size() - 1;
        return departmentList1.get(last);
    }
}
