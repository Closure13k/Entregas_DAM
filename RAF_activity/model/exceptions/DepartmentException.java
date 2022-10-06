package model.exceptions;

public class DepartmentException extends Exception {

    /**
     * Excepciones personalizadas. Principalmente trabajará como wrapper de
     * otras. Su principal propósito es añadir contexto para el usuario.
     *
     * @param message
     */
    public DepartmentException(String message) {
        super(message);
    }

}
