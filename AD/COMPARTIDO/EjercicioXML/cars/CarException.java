/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars;

/**
 * Wrapper para excepciones. Añade contexto (parent = getClass().getSimpleName()).
 * @author AaronFM
 */
public class CarException extends Exception{
    private String parent;
    
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public CarException(String message) {
        super(message);
    }

    /**
     *
     * @param parent Normalmente lo uso para reconocer el tipo de excepción en el mensaje que lance.
     * @param message
     */
    public CarException(String parent, String message) {
        super(message);
        this.parent = parent;
    }
    public CarException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
