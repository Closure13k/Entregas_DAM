package department.filecontroller;

import department.controller.DepartmentException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTMLConversion {

    public static void convertXMLtoHTML(File xmlFile, File xslFile, File htmlFile) throws DepartmentException {
        try ( FileOutputStream fileOut = new FileOutputStream(htmlFile)) {
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(fileOut));
        } catch (IOException | TransformerException ex) {
            throw new DepartmentException(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

}
