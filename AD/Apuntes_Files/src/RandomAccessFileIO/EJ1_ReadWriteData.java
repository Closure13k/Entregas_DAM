package RandomAccessFileIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


public class EJ1_ReadWriteData {

    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            readNumbers("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\nuevo.dat");
            writeNumbers(numbers, "C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\nuevo.dat");
        } catch (EJ1Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void writeNumbers(int[] numbers, String file) throws EJ1Exception {
        try ( RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            for (int numero : numbers) {
                raf.writeInt(numero);
            }

        } catch (IOException ex) {
            throw new EJ1Exception(ex.getMessage());
        }
    }

    public static void readNumbers(String file) throws EJ1Exception {
        try ( RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            
            while(raf.getFilePointer() < raf.length()){
                System.out.print(raf.readInt()+" ");
            }
            
            raf.seek(0);
            raf.seek(Integer.BYTES);
            System.out.println("\nSaltado a mano: " + raf.readInt());
            
            raf.seek(raf.getFilePointer()-Integer.BYTES);
            raf.writeInt(9);
            
            raf.seek(0);
            while(raf.getFilePointer() < raf.length()){
                System.out.print(raf.readInt()+" ");
                if(raf.getFilePointer() == raf.length()){
                    System.out.println("");
                }
            }
        } catch (IOException ex) {
            throw new EJ1Exception(ex.getMessage());
        }

    }

    private static class EJ1Exception extends Exception {

        public EJ1Exception(String message) {
        }
    }
}
