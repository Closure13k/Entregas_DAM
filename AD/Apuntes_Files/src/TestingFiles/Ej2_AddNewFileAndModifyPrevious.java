/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestingFiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author AaronFM
 */
public class Ej2_AddNewFileAndModifyPrevious {
    public static void main(String[] args) {
        File oldFile = new File(".", "FicheroViejo.txt");
        try {
            oldFile.createNewFile();
            TimeUnit.SECONDS.sleep(20);
            oldFile.renameTo(new File(".", "FicheroViejoRenombrado.txt"));
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Ej2_AddNewFileAndModifyPrevious.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
