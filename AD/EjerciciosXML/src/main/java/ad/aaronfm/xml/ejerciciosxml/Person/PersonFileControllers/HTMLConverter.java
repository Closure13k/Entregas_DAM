/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author AaronFM
 */
public class HTMLConverter {

    /**
     * Converts XML file into HTML, style-supported by its XSL file.Se puede
     * dividir todo en variables por visibilidad, pero si tienes claro qu� usa
     * cada cosa se puede hacer en incluso 1 l�nea.
     *
     * @param xmlFile
     * @param xslFile
     * @param HTMLFile
     * @throws java.io.IOException
     * @throws javax.xml.transform.TransformerConfigurationException
     */
    public static void convertToHTML(File xmlFile, File xslFile, File HTMLFile) throws IOException, TransformerConfigurationException, TransformerException {
        try ( FileOutputStream fileOut = new FileOutputStream(HTMLFile)) {
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(fileOut));
        }

    }

}
