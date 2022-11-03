package RandomAccessFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EJ2_ReadWriteData2 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\nuevo.dat");
        try ( RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            String[] surnames = {"FERNANDEZ", "LOPEZ"};
            int[] ages = {20, 40};
            double[] salaries = {1000.50, 2000.42};

            StringBuffer stringBuffer;
            int n = surnames.length;

            int distance = Integer.BYTES*2 + Character.BYTES * 10 + Double.BYTES;
            int position = 0;

            int readID;
            char[] readSurname = new char[10];
            String surname;
            int readAge;
            double readSalary;

            for (int i = 0; i < n; i++) {
                raf.writeInt(i + 1);
                stringBuffer = new StringBuffer(surnames[i]);
                stringBuffer.setLength(10);
                raf.writeChars(stringBuffer.toString());
                raf.writeInt(ages[i]);
                raf.writeDouble(salaries[i]);
            }

            while (true){
                if(raf.getFilePointer() == raf.length()){
                    break;
                }
                raf.seek(position);
                readID = raf.readInt();
                for (int i = 0; i < readSurname.length; i++) {
                    readSurname[i] = raf.readChar();
                }
                surname = new String(readSurname);
                readAge = raf.readInt();
                readSalary = raf.readDouble();

                if (readID > 0) {
                    System.out.printf("ID: %d Apellido: %s Edad: %d Salario: %.2f \n", readID, surname, readAge, readSalary);
                }
                position = position + distance;
            }

        } catch (IOException ex) {
            Logger.getLogger(EJ2_ReadWriteData2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
