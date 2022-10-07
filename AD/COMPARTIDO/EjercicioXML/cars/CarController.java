/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author AaronFM
 */
public class CarController {

    /**
     *
     * @param file
     * @param carList
     * @throws CarException
     */
    public static void writeCarsInFile(File file, List<Car> carList) throws CarException {
        try ( ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Car car : carList) {
                objOut.writeObject(car);
            }
            carList.stream();
            writeCarsInXML(file, file);
        } catch (IOException ioex) {
            throw new CarException("IOException - ", ioex.getMessage());
        }
    }

    /**
     * Lee objetos y genera XML. Comenzamos el proceso declarando nuestro
     * {@link DocumentBuilder}. Para ello generamos su
     * {@link DocumentBuilderFactory} llamando a
     * {@link DocumentBuilderFactory#newInstance()}.
     * <p>
     * Generamos el DocumentBuilder, que se encargará de gestionar el archivo.
     * Para generar y gestionar el documento llamaremos a
     * {@link DocumentBuilder#getDOMImplementation()} y dentro del mismo a
     * <pre>{@code
     *  createDocument(
     *      String nameSpaceURI,
     *      String rootDelXML,
     *      String tipoDocumento (default = null)
     * )}</pre>
     * <p>
     * Tras generar el documento le asignamos su versión XML con
     * {@linkplain Document#setXmlVersion(String xmlVersion)}
     * <p>
     * Comenzamos la lectura de objetos. Una vez hechas las verificaciones
     * necesarias, construimos cada objeto:
     * <ol>
     * <li>Creamos el elemento del objeto con
     * {@link Document#createElement(String nombreElemento)}</li>
     * <li>Recogemos el raiz y le conectamos el objeto como hijo.
     * {@link Element#appendChild(hijo)}</li>
     * <li>Generamos los hijos del nene que hemos creado.</li>
     * </ol><p>
     * Una vez terminado, necesitamos dos objetos más:
     * <ul>
     * <li>{@link DOMSource#DOMSource(Node documento)}</li>
     * <li>{@link StreamResult#StreamResult(File ficheroXML)}</li>
     * </ul><p>
     * Finalmente transformamos nuestro documento.
     * {@link Transformer#transform(Source DOMSourceAnterior, Result StreamResultAnterior) }
     *
     * @param file El archivo (.dat) del que recoger los objetos.
     * @param xmlFile El archivo XML que se genera o sobreescribe.
     * @throws CarException Wrapper de las excepciones que saque el programa.
     */
    public static void writeCarsInXML(File file, File xmlFile) throws CarException {
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
            //DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //DocumentBuilder newDocumentBuilder = dbf.newDocumentBuilder();
            //DOMImplementation domImplementation = documentBuilder.getDOMImplementation();
            //Document createDocument = domImplementation.createDocument(null, Car.XML_ROOT, null);
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.getDOMImplementation().createDocument(null, Car.XML_ROOT, null);
            document.setXmlVersion(Car.XML_VERSION);
            for (;;) {
                try {
                    Object read = objIn.readObject();
                    if (read instanceof Car car) {
                        Element element = document.createElement(Car.class.getSimpleName().toLowerCase());
                        document.getDocumentElement().appendChild(element);
                        generateCar(car, element, document);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(xmlFile);
            //Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //transformer.transform(domSource, streamResult);

            TransformerFactory.newInstance().newTransformer().transform(domSource, streamResult);

        } catch (IOException | ClassNotFoundException | ParserConfigurationException | TransformerException ex) {
            throw new CarException(ex.getClass().getSimpleName() + System.lineSeparator(), ex.getMessage());
        }
    }

    /**
     * Convierte la propiedad que le pases en un elemento.
     * <p>
     * {@code <rootElement> <node> value </node> </rootElement>}
     * @param node Nombre del nodo.
     * @param value Valor a mostrar.
     * @param rootElement Elemento del que cuelga.
     * @param document El documento por llamar a sus referencias.
     */
    protected static void generateElement(String node, String value, Element rootElement, Document document) {
        Element element = document.createElement(node);
        Text text = document.createTextNode(value);
        rootElement.appendChild(element);
        element.appendChild(text);
    }

    /**
     * Genera toda la entrada de coche.
     *
     * @param car El objeto a registrar.
     * @param rootElement Elemento del que cuelga (en este caso coches)
     * @param document El documento a llamar.
     */
    protected static void generateCar(Car car, Element rootElement, Document document) {
        generateElement(Car.REGISTRATION, car.registration(), rootElement, document);
        generateElement(Car.MODEL, car.model(), rootElement, document);
    }
}
