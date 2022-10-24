/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author AaronFM
 */
public class formController {
    protected static void errorMessage(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
