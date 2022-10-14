/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.aaronfm.xml.ejerciciosxml.Person.PersonFileControllers;

import ad.aaronfm.xml.ejerciciosxml.Person.People;
import ad.aaronfm.xml.ejerciciosxml.Person.Person;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author AaronFM
 */
public class XMLController {

    /**
     * Writes people class to XML. Asignamos un alias a cada clase, sino
     * utilizará el nombre de clase completo (y vaya lío si usas maven).
     *
     * Si una propiedad es una lista de clases, es interesante llamar a
     * XStream#addImplicit[Array|Collection|Map] para deshacernos de su
     * propiedad, sino se te mostraría tal que así:
     * <pre>{@code<People><list><Person></list></People>}</pre>
     *
     * @param people
     * @param xmlFile
     * @throws java.io.FileNotFoundException
     */
    public static void writePeopleToXML(People people, File xmlFile) throws FileNotFoundException {
        XStream xStream = new XStream();
        /**
         * Cambiamos nombre de los nodos. Dos formas: GetSimpleName te devuelve
         * el nombre de la clase. Alternativamente puedes crear una constante,
         * por si quieres un nombre customizado, lo cual hace que el código esté
         * más ordenado (sólo tendrías que cambiarlo en la clase, si ya no
         * necesitase ese nombre).
         */
        xStream.alias(People.ALIAS, People.class);
        xStream.alias(Person.class.getSimpleName(), Person.class);
        //Borramos el atributo Lista de People
        xStream.addImplicitCollection(People.class, People.IMPLICIT_COLLECTION);
        //Escribimos el XML
        xStream.toXML(people, new FileOutputStream(xmlFile));
    }

    /**
     * Reads People class from XML file. Esta lectura puede enviar excepciones
     * de seguridad, por lo que habría que modificar los permisos o añadir
     * clases permitidas.
     *
     * Las dos formas: - Para dar permisos de forma indiscriminada:
     * {@link XStream#addPermission} - Para permitir clases específicas:
     * {@link XStream#allowTypes(Class[])}
     *
     * @param xmlFile
     * @return
     * @throws java.io.FileNotFoundException
     */
    public static People readPeopleFromXML(File xmlFile) throws FileNotFoundException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{People.class, Person.class});
        xStream.alias(People.ALIAS, People.class);
        xStream.alias(Person.ALIAS, Person.class);
        xStream.addImplicitCollection(People.class, People.IMPLICIT_COLLECTION);
        People peopleFromXML = (People) xStream.fromXML(new FileInputStream(xmlFile));
        return peopleFromXML;
    }

}
