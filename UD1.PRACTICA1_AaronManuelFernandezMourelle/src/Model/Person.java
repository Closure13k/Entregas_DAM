package Model;

/**
 * Habrá que tener en cuenta las siguientes restricciones: • Todos los campos
 * son obligatorios (realizar una validación de campos total). • En caso de que
 * la opción Otra esté seleccionada, la caja de texto asociada a la opción
 * estará habilitada. • En caso de que la opción Otra no esté seleccionada, la
 * caja de texto asociada a la opción estará vacía y deshabilitada. • En caso de
 * seleccionar Otra, al guardar se debe validar que en la caja de texto asociada
 * hay algo escrito (si no es así informar del error). • No puede haber 2
 * registros con el mismo DNI. En caso de intentar introducir un DNI repetido
 * mostrar un mensaje de error. • No es necesario validar el formato del DNI.
 *
 *
 * Al pulsar sobre el botón buscar se buscará en memoria el DNI insertado en la
 * caja de texto adjunta al botón buscar (se debe comprobar que se ha escrito
 * algo. En caso de no ser así mostrar un mensaje de error). En caso de que no
 * exista el registro buscado en memoria, se informará al usuario. En caso de
 * que exista el registro buscado en memoria, se utilizará el formulario para
 * mostrar la información almacenada en el registro (antes de volcar los datos
 * al formulario es necesario limpiar los datos que había en él previamente para
 * que no haya inconsistencias en la información mostrada). Todos los errores
 * que puedan surgir durante la utilización de la aplicación deben de ser
 * mostrados al usuario para que pueda subsanarlos.
 *
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto para ease of use.
 */
public class Person {

    public static final String OTHER_SEPARATOR = ": ";
    
    private String DNI;
    private String name;
    private String surnameOne;
    private String surnameTwo;
    private Sex sex;
    private List<String> license;
    private String degree;

    public Person(String DNI, String name, String surname1, String surname2, Sex sex, List<String> license, String degree) {
        this.DNI = DNI;
        this.name = name;
        this.surnameOne = surname1;
        this.surnameTwo = surname2;
        this.sex = sex;
        this.license = license;
        this.degree = degree;
    }

    public Person() {
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurnameOne() {
        return surnameOne;
    }

    public String getSurnameTwo() {
        return surnameTwo;
    }

    public Sex getSex() {
        return sex;
    }

    public List<String> getLicense() {
        if (license == null) {
            return new ArrayList<>();
        }
        return license;
    }

    public String getDegree() {
        return degree;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnameOne(String surnameOne) {
        this.surnameOne = surnameOne;
    }

    public void setSurnameTwo(String surnameTwo) {
        this.surnameTwo = surnameTwo;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setLicense(List<String> license) {
        this.license = license;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return '[' + DNI + "] " + surnameOne + " " + surnameTwo + ", " + name + "\nSexo: " + sex + "\nPermiso conducir: " + license + "\nTitulación Máxima: " + degree;
    }

}
