/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars;

/**
 *
 * @author AaronFM
 */
public class CarException extends Exception{
    private String parent;

    /**
     *
     * @return
     */
    public String getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }
    
    /**
     *
     * @param message
     */
    public CarException(String message) {
        super(message);
    }

    /**
     *
     * @param parent
     * @param message
     */
    public CarException(String parent, String message) {
        super(message);
        this.parent = parent;
    }

    /**
     *
     * @param message
     * @param cause
     */
    public CarException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
