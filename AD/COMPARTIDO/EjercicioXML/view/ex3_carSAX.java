/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import cars.Car;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author AaronFM
 */
public class ex3_carSAX {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            XMLReader read = XMLReaderFactory.createXMLReader();
            ContentHandler gestor = new ContentHandler();
            read.setContentHandler(gestor);
            read.parse(new InputSource(".\\src\\data\\Cars.xml"));
//            
//            ContentHandler gestor = new ContentHandler();
//            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
//            SAXParser parser = parserFactory.newSAXParser();
//            XMLReader reader = parser.getXMLReader();
//            reader.setContentHandler(gestor);
//            parser.parse(Car.getXMLFile(), gestor);

        } catch (SAXException | IOException ex) {
            Logger.getLogger(ex3_carSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class ContentHandler extends DefaultHandler {

        public ContentHandler() {
            super();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String car = new String(ch, start, length);
            //Borramos salto de linea
            car.replaceAll("[\t\n]", "");
            System.out.println("\tCaracteres: " + car);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Fin elemento: " + uri + "\n" + localName + "\n" + qName);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Inicio elemento: " + uri + "\n" + localName + "\n" + qName);
        }

    }
}
