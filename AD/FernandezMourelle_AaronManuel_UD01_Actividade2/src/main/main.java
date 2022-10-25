/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import department.Department;
import department.DepartmentList;
import static department.controller.DepartmentController.generateSample;
import department.controller.DepartmentException;
import department.filecontroller.DATController;
import department.filecontroller.HTMLConversion;
import department.filecontroller.XMLController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author AaronFM
 */
public class main {

    public static void main(String[] args) {
        try {
            //<editor-fold defaultstate="collapsed" desc="Previo a ejercicios">
            File datFile = DepartmentList.getDatFile();
            List<Department> departments = generateSample();
            DATController.writeDepartmentListToDat(departments, datFile);
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Ejercicio 1">
            /**
             * 1. A partir do ficheiro de obxectos Departamento.dat xerado na
             * Actividade1_Entregar crea un documento XML utilizando DOM.
             *
             * No realizo comprobaciones por no ser necesarias para estos
             * ejercicios. Los genero y gestiono yo mismo.
             */
            XMLController.convertToXMLusingDOM(DepartmentList.getDatFile(), DepartmentList.getXmlFile());
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Ejercicio 2">
            /**
             * 2. A partir do ficheiro XML xerado anteriormente visualiza o seu
             * contido utilizando SAX.
             * 
             * Saco solo los nombres.
             */
            DepartmentList departmentList = XMLController.readXMLusingSAX(DepartmentList.getXmlFile());
            departmentList.getDepartmentList()
                    .stream().map(Department::getName)
                    .forEach(System.out::println);
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Ejercicio 3">
            /**
             * 3. A partir do ficheiro de obxectos Departamento crea un
             * documento XML utilizando a libraría XStream.
             */
            XMLController.writeXMLusingXStream(departmentList, DepartmentList.getXmlFile());
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Ejercicio 4">
            /**
             * 4. A partir do documento XML xerado anteriormente realiza a
             * lectura utilizando XStream.
             * 
             * Saco las localizaciones para distinguirlos.
             */
            XMLController.readXMLusingXStream(DepartmentList.getXmlFile())
                    .getDepartmentList()
                    .stream().map(Department::getLocation)
                    .forEach(System.out::println);
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Ejercicio 5">
            /**
             * 5. Crea unha plantilla XML para dar unha representación ao
             * ficheiro xml de departamentos e realiza un programa Java para
             * transformalo.
             */
            HTMLConversion.convertXMLtoHTML(DepartmentList.getXmlFile(), DepartmentList.getXslFile(), DepartmentList.getHtmlFile());
//</editor-fold>
        } catch (DepartmentException | FileNotFoundException ex) {
            //ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }

}
