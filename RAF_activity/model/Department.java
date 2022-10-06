package model;

import java.io.File;
import model.exceptions.DepartmentException;

/**
 * Record de Departamento para facilitar la gestión de datos. Incluye las
 * constantes necesarias para el manejo de ficheros aleatorios.
 */
public record Department(int num, String name, String location) {

    /**
     * Ruta del fichero de datos.
     */
    private static final String DATA_PATH = ".\\src\\data\\Departamento.dat";

    /**
     * Número de caracteres de la cadena Name.
     */
    public static final int NAME_CAPACITY = 15;

    /**
     * Bytes de la cadena Name.
     * <pre>{@code NAME_BYTES = Character.BYTES * NAME_CAPACITY;}</pre>
     */
    public static final int NAME_BYTES = Character.BYTES * NAME_CAPACITY;

    /**
     * Número de caracteres de la cadena Location.
     */
    public static final int LOCATION_CAPACITY = 15;

    /**
     * Bytes de la cadena Location.
     * <pre>{@code LOCATION_BYTES = Character.BYTES * LOCATION_CAPACITY;}</pre>
     */
    public static final int LOCATION_BYTES = Character.BYTES * LOCATION_CAPACITY;

    /**
     * Bytes que ocupa el número de departamento = 4.
     */
    public static final int DEPTNUM_BYTES = Integer.BYTES;
    /**
     * Bytes totales de cada entrada. Hace la gestión de saltos con
     * seek(long)más práctica.
     * <pre>{@code TOTAL_BYTES = DEPTNUM_BYTES + (NAME_BYTES + LOCATION_BYTES);}</pre>
     */
    public static final int TOTAL_BYTES = DEPTNUM_BYTES + (NAME_BYTES + LOCATION_BYTES);

    /**
     * Traduce la constante DATA_PATH a objeto de la clase File.
     */
    public static File getDataFile() {
        return new File(DATA_PATH);
    }

    /**
     * Método que convierte la propiedad que le pase a su tamaño.
     */
    public String convertToSize(String property) throws DepartmentException {
        StringBuilder sb;
        switch (property) {
            case "name" -> {
                sb = new StringBuilder(name);
                sb.setLength(NAME_CAPACITY);
            }
            case "location" -> {
                sb = new StringBuilder(location);
                sb.setLength(LOCATION_CAPACITY);
            }
            default -> {
                throw new DepartmentException("No such property.");
            }
        }
        return sb.toString();
    }

    /**
     * Variante del convertToSize. Recibirá una cadena y la propiedad de la cual
     * se recortará o crecerá.
     */
    public static String normalizeString(String string, String property) throws DepartmentException {
        StringBuilder sb;
        switch (property) {
            case "name" -> {
                sb = new StringBuilder(string);
                sb.setLength(NAME_CAPACITY);
            }
            case "location" -> {
                sb = new StringBuilder(string);
                sb.setLength(LOCATION_CAPACITY);
            }
            default -> {
                throw new DepartmentException("No such property.");
            }
        }
        return sb.toString();
    }
}
