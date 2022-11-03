/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileModification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author AaronFM
 */
class FileController {

    protected static boolean verifyFile(File fileToWrite) throws FileNotFoundException, IOException {
        if(!fileToWrite.exists()){
         return fileToWrite.createNewFile();
        }
        if(!fileToWrite.isFile()){
            throw new FileNotFoundException("Esto no es un archivo.");
        }
        return false;
    }
    
}
