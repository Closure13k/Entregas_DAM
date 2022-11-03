/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileModification.CarFiles;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author AaronFM
 */
public class CarOutputStream extends ObjectOutputStream{

    public CarOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public CarOutputStream() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {}

    @Override
    protected boolean enableReplaceObject(boolean enable) throws SecurityException {
        return super.enableReplaceObject(enable);
    }

    @Override
    protected Object replaceObject(Object obj) throws IOException {
        return super.replaceObject(obj);
    }
    
}
