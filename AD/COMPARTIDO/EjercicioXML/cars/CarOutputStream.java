/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author AaronFM
 */
public class CarOutputStream extends ObjectOutputStream{

    /**
     *
     * @param out
     * @throws IOException
     */
    public CarOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /**
     *
     * @throws IOException
     * @throws SecurityException
     */
    public CarOutputStream() throws IOException, SecurityException {
    }

    /**
     *
     * @throws IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException {}

    
}
