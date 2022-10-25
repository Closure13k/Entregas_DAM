package department.filecontroller;

import com.thoughtworks.xstream.XStream;
import department.Department;
import department.DepartmentHandler;
import department.DepartmentList;
import department.controller.DepartmentException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XMLController {

    //<editor-fold defaultstate="collapsed" desc="DOM Methods">
    public static void convertToXMLusingDOM(File datFile, File xmlFile) throws DepartmentException {
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(datFile))) {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = docBuilder.getDOMImplementation().createDocument(null, Department.XML_ROOT, null);
            document.setXmlVersion(Department.XML_VERSION);
            for (;;) {
                try {
                    Object readObject = objIn.readObject();
                    if (readObject instanceof Department department) {
                        Element element = document.createElement(Department.class.getSimpleName());
                        document.getDocumentElement().appendChild(element);
                        generateDepartment(department, element, document);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
            TransformerFactory.newInstance()
                    .newTransformer()
                    .transform(new DOMSource(document), new StreamResult(xmlFile));

        } catch (IOException | ParserConfigurationException | TransformerException ex) {
            throw new DepartmentException(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        } catch (ClassNotFoundException cnfe) {
            throw new DepartmentException(cnfe.getClass().getSimpleName() + ": Durante la lectura de objetos.");
        }
    }

    private static void generateDepartment(Department department, Element rootElement, Document document) {
        generateElement(Department.ID, String.valueOf(department.getId()), rootElement, document);
        generateElement(Department.NAME, department.getName(), rootElement, document);
        generateElement(Department.LOCATION, department.getLocation(), rootElement, document);
    }

    private static void generateElement(String node, String value, Element rootElement, Document document) {
        Element element = document.createElement(node);
        Text text = document.createTextNode(value);
        rootElement.appendChild(element);
        element.appendChild(text);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SAX Methods">
    public static DepartmentList readXMLusingSAX(File xmlFile) throws DepartmentException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DepartmentHandler handler = new DepartmentHandler();
            
            saxParser.parse(xmlFile, handler);
            
            return handler.getDepartmentList();            
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new DepartmentException(ex.getMessage());
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="XStream Methods">
    public static void writeXMLusingXStream(DepartmentList departmentList, File xmlFile) throws FileNotFoundException {
        XStream xStream = new XStream();
        xStream.alias(DepartmentList.class.getSimpleName(), DepartmentList.class);
        xStream.alias(Department.class.getSimpleName(), Department.class);
        xStream.addImplicitCollection(DepartmentList.class, DepartmentList.IMPLICIT_COLLECTON);
        xStream.toXML(departmentList, new FileOutputStream(xmlFile));
    }

    public static DepartmentList readXMLusingXStream(File xmlFile) {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{DepartmentList.class, Department.class});
        xStream.alias(DepartmentList.class.getSimpleName(), DepartmentList.class);
        xStream.alias(Department.class.getSimpleName(), Department.class);
        xStream.addImplicitCollection(DepartmentList.class, DepartmentList.IMPLICIT_COLLECTON);
        DepartmentList departmentList = new DepartmentList();
         xStream.fromXML(xmlFile, departmentList);
        return departmentList;
    }    
    //</editor-fold>


}
